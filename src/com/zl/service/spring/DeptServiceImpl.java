/**
 * 
 */
package com.zl.service.spring;

import com.zl.dto.domain.Dept;
import com.zl.persistence.dao.DeptDao;
import com.zl.service.facade.DeptService;

/**
 * @author zlennon
 *
 */
public class DeptServiceImpl implements DeptService {
	DeptDao deptDao;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	/* (non-Javadoc)
	 * @see com.zl.service.facade.DeptService#saveDept(com.zl.dto.domain.Dept)
	 */
	@Override
	public void saveDept(Dept dept) {
		deptDao.saveDept(dept);
	}
}
