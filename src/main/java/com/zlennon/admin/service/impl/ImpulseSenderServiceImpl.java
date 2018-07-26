package com.zlennon.admin.service.impl;

import com.zlennon.admin.mapper.ImpulseSenderMapper;
import com.zlennon.admin.model.ImpulseSender;
import com.zlennon.admin.service.ImpulseSenderService;
import com.zlennon.business.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/07/07.
 */
@Service("impulseSenderService")
public class ImpulseSenderServiceImpl extends AbstractService<ImpulseSender> implements ImpulseSenderService<ImpulseSender> {

    @Autowired
    private ImpulseSenderMapper impulseSenderMapper;

    public ImpulseSenderMapper getImpulseSenderMapper() {
        return impulseSenderMapper;
    }

    public void setImpulseSenderMapper(ImpulseSenderMapper impulseSenderMapper) {
        this.impulseSenderMapper = impulseSenderMapper;
    }


    @Override
    public int deleteByPrimaryKey(String sequenceName) {
        return impulseSenderMapper.deleteByPrimaryKey(sequenceName);
    }

    public int insert(ImpulseSender impulseSender){
       return impulseSenderMapper.insert(impulseSender);
    }

    public ImpulseSender selectByPrimaryKey(String sequenceName){
       return  impulseSenderMapper.selectByPrimaryKey(sequenceName);
    }

    public List<ImpulseSender> selectAll(){
       return impulseSenderMapper.selectAll();
    }

    public int updateByPrimaryKey(ImpulseSender impulseSender){
       return impulseSenderMapper.updateByPrimaryKey(impulseSender);
    }

    @Override
    public int isExists(String sequenceName) {
        return impulseSenderMapper.isExistsSequence(sequenceName);

    }
}
