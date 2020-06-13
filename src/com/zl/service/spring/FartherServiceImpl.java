/**
 * 
 */
package com.zl.service.spring;

import com.zl.dto.domain.Farther;
import com.zl.persistence.dao.FartherDao;
import com.zl.service.facade.FartherService;

/**
 * @author zlennon
 *
 */
public class FartherServiceImpl implements FartherService {
	FartherDao fartherDaoDao;
	public void setFartherDao(FartherDao fartherDaoDao) {
		this.fartherDaoDao = fartherDaoDao;
	}

	public void saveFarther(Farther father) {
		fartherDaoDao.saveFarther(father);
	}
}
