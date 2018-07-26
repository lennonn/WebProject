/**
 * 
 */
package com.zlennon.admin.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import com.zlennon.Constants;
import com.zlennon.PjException;
import com.zlennon.admin.model.ImpulseSender;
import com.zlennon.admin.model.SequenceVo;
import com.zlennon.admin.service.ISequenceService;
import com.zlennon.admin.service.ImpulseSenderService;
import com.zlennon.utils.DateUtil;

import com.zlennon.utils.StringHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OracleSequenceService implements ISequenceService {
	@Resource
	ImpulseSenderService impulseSenderService;
	private final String TABLE_NAME = "BASE_IMPULSE_SENDER";
	// 日期字段名
	private final String FIELD_DATE = "update_date";
	// 当期值字段名
	private final String FIELD_CURRENT_VALUE = "current_value";
	// 序列值长度
	private final String FIELD_SEQUENCE_LEN = "sequence_len";
	// 当期格式化后序列值
	private final String FIELD_CURRENT_FMT_VALUE = "current_fmt_value";
	// 序列化格式规则
	private final String FIELD_SEQUENCE_RULE = "sequence_rule";
	// 序列名称
	private final String FIELD_SEQUENCE = "sequence_name";
	// 周期类型
	private final String FIELD_CYCLE_TYPE = "cycle_type";
	// 格式序列化值串
	private final String FMT_SEQ_VALUE = "%value";
	// 备注
	private final String FIELD_REMARK = "remark";


	/**
	 * 获取下一批序列值
	 *
	 * @param size
	 *            序列个数
	 * @param sequenceName
	 *            序列名称
	 * @param args
	 *            参数列表
	 * */
	public String[] doGetNextSequenceValue(int size, String sequenceName, Object... args) {
		try {
			return getNextSequenceValue(size, sequenceName, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取下一批序列值
	 *
	 * @param size
	 *            序列个数
	 * @param sequenceName
	 *            序列名称
	 * @param args
	 *            参数列表
	 * */
	private String[] getNextSequenceValue(int size, String sequenceName, Object... args) throws Exception {
		// 序列记录加锁
		String sql;
		// 判断size的值
		if (size <= 0) {
			//throw new Exception("无效获取序列个数:" + size);
		}
		ImpulseSender impulseSender = (ImpulseSender) impulseSenderService.selectByPrimaryKey(sequenceName);
		if (impulseSender == null ) {
			//throw new Exception("序列名称:" + sequenceName + "不存在!");
		}

		Date sqlDate=impulseSender.getUpdateDate();

		if (sqlDate == null) {
			sqlDate = new Date();
		}
		// 取出周期类型
		String cycleDateType = Constants.CYCLE_TYPE_NO;
		if (impulseSender.getCycleType() != null) {
			cycleDateType = impulseSender.getCycleType();
		}
		Integer curVal;
		String fmtCurVal = "";
		BigDecimal currentValue;
		// 判断是否有周期
		if (!Constants.CYCLE_TYPE_NO.equals(cycleDateType)) {
			// 按年
			if (Constants.CYCLE_TYPE_YEAR.equals(cycleDateType)) {
				Integer curryear = DateUtil.getYear(sqlDate);
				Integer dbYear = 0;
				try {
					dbYear = Integer.parseInt(DateUtil.getDateStr(sqlDate, "yyyy"));
				} catch (Exception e) {
					//throw new PjException(e.getMessage());
				}
				if (!dbYear.equals(curryear)) {
					// 年份不同,需要从size开始
					curVal = size;
				} else {
					currentValue = impulseSender.getCurrentValue();
					// 当期值加size
					if (currentValue != null) {
						curVal = currentValue.intValue();
					} else {
						curVal = 0;
					}
					if (curVal == null) {
						curVal = 0;
					}
					curVal = curVal + size;
				}
				// 按月
			} else if (Constants.CYCLE_TYPE_MONTH.equals(cycleDateType)) {
				// 改成年和月联合比较 ，以免出现年份不同，月份相同的bug modify at 2014-12-12
				String currMonth = DateUtil.getDateStr(sqlDate, "yyyyMM");
				String dbMonth = "";
				dbMonth = DateUtil.getDateStr(sqlDate, "yyyyMM");

				if (!dbMonth.equals(currMonth)) {
					// 月份不同,需要从size开始
					curVal = size;
				} else {
					// 当期值加size
					currentValue =  impulseSender.getCurrentValue();
					// 当期值加size
					if (currentValue != null) {
						curVal = currentValue.intValue();
					} else {
						curVal = 0;
					}
					if (curVal == null) {
						curVal = 0;
					}
					curVal = curVal + size;
				}
				// 按天
			} else if (Constants.CYCLE_TYPE_DAY.equals(cycleDateType)) {
				// 改成年，月和日联合比较 ，以免出现年份不同，月份不同，但日相同的bug modify at 2014-12-12
				String currDay = DateUtil.getDateStr(sqlDate, "yyyyMMdd");
				String dbDay = "";
				dbDay = DateUtil.getDateStr(sqlDate, "yyyyMMdd");
				if (!dbDay.equals(currDay)) {
					// 天不同,需要从size开始
					curVal = size;
				} else {
					// 当期值加size
					currentValue =  impulseSender.getCurrentValue();
					if (currentValue != null) {
						curVal = currentValue.intValue();
					} else {
						curVal = 0;
					}
					if (curVal == null) {
						curVal = 0;
					}
					curVal = curVal + size;
				}
				// 其他按无周期处理
			} else {
				// 当期值加size
				currentValue =  impulseSender.getCurrentValue();
				// 当期值加size
				if (currentValue != null) {
					curVal = currentValue.intValue();
				} else {
					curVal = 0;
				}
				if (curVal == null) {
					curVal = 0;
				}
				curVal = curVal + size;
			}
		} else {
			// 当期值加size
			currentValue =  impulseSender.getCurrentValue();
			// 当期值加size
			if (currentValue != null) {
				curVal = currentValue.intValue();
			} else {
				curVal = 0;
			}
			if (curVal == null) {
				curVal = 0;
			}
			curVal = curVal + size;
		}
		String retVals[] = new String[size];
		int startVal = curVal - size + 1;
		// 格式当期值为字符串
		BigDecimal sequenceLen;
		sequenceLen = impulseSender.getSequenceLen();
		Integer valLen = sequenceLen.intValue();
		if (valLen == null) {
			throw new PjException("序列名称:" + sequenceName + "的长度尚未定义!");
		}
		// 获取序列格式化规则
		String sequenRule = impulseSender.getSequenceRule();
		if (StringUtils.isEmpty(sequenRule)) {
			throw new PjException("序列名称:" + sequenceName + "的规则尚未定义!");
		}
		String curValFmt = "%0" +String.valueOf(valLen) + "d";

		for (int i = startVal; i <= curVal; i++) {
			String strCurVal = String.format(curValFmt, i);
			// 将规则中的%value替换为strCurVal,然后再格式化
			sequenRule = StringHelper.replaceAll(impulseSender.getSequenceRule(), FMT_SEQ_VALUE, strCurVal).toString();
			fmtCurVal = String.format(sequenRule, args);
			retVals[i - startVal] = fmtCurVal;
		}

		impulseSender.setCurrentValue(new BigDecimal(curVal));
		impulseSender.setCurrentFmtValue(new BigDecimal(fmtCurVal));
		impulseSender.setUpdateDate(new Date());
		int rowNum= impulseSenderService.updateByPrimaryKey(impulseSender);

		if (rowNum < 1) {
			//throw new PjException("产生序列名称:" + sequenceName + "失败!原因为更新记录数小于1!");
		}
		return retVals;
	}

	/**
	 * 获取下一个序列值
	 * 
	 * @param sequenceName
	 *            序列名称
	 * @param args
	 *            参数列表
	 * @return
	 */
	public String doGetNextSequenceValue(String sequenceName, Object... args) {
		String seqValues[];
		try {
			seqValues = getNextSequenceValue(1, sequenceName, args);
			if (seqValues != null && seqValues.length > 0) {
				return seqValues[0];
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 生成随机数
	 * 
	 */

	public long doRandomNum(long max, long min) {

		return Math.round(Math.random() * (max - min)) + min;

	}

	/**
	 * 获取数据库时间戳
	 * 
	 * @return
	 */
	public Timestamp getDBTimestamp() {
		//RmCommonVo vo = RmProjectHelper.getCommonServiceInstance().doQueryForObject("select sysdate from dual");
		Timestamp t = new Timestamp(new Date().getTime());
		return t;
	}

	/**
	 * 判断序列名称是否存在
	 * 
	 * @param sequenceName
	 * @return
	 */
	public boolean isExistsSequence(String sequenceName) {
		return isExistsSequence(sequenceName);
	}

	/**
	 * 插入序列
	 * 
	 * @param vo
	 */
	public void insert(SequenceVo vo) {
		StringBuilder sqlTemp = new StringBuilder();
		sqlTemp.append("insert into ").append(TABLE_NAME).append("(").append(FIELD_SEQUENCE).append(",").append(FIELD_CYCLE_TYPE).append(",").append(FIELD_CURRENT_VALUE).append(",").append(FIELD_SEQUENCE_RULE).append(",").append(FIELD_SEQUENCE_LEN).append(",").append(FIELD_REMARK).append(",").append(FIELD_DATE).append(") values('%s','%s',%d,'%s',%d,'%s',sysdate)");
		String sql = String.format(sqlTemp.toString(), vo.getSequenceName(), vo.getCycleType(), vo.getCurrentValue(), vo.getSequenceRule(), vo.getSequenceLen(), vo.getRemark());
		//RmProjectHelper.getCommonServiceInstance().doUpdate(sql);
		ImpulseSender is = new ImpulseSender();
		impulseSenderService.insert(is);
	}

	/**
	 * 获取表主键
	 * 
	 * @param tableName
	 * @return
	 */
	public String getTablePK(String tableName) {
//		java.util.Date data = new java.util.Date();
		Timestamp dbTime = getDBTimestamp();
		return doGetNextSequenceValue(tableName, dbTime, dbTime, dbTime);
	}


}
