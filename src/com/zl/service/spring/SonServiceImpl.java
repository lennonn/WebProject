/**
 * 
 */
package com.zl.service.spring;

import com.zl.dto.domain.Son;
import com.zl.persistence.dao.SonDao;
import com.zl.service.facade.SonService;

/**
 * @author zlennon
 *
 */
public class SonServiceImpl implements SonService {
	SonDao sonDao;
	public void setSonDao(SonDao sonDao) {
		this.sonDao = sonDao;
	}

	@Override
	public Son getById(String id) {
		return sonDao.getSonById(id);
	}

	/* (non-Javadoc)
	 * @see com.zl.service.facade.SonService#saveSon(com.zl.dto.domain.Son)
	 */
	@Override
	public void saveSon(Son Son) {
		sonDao.saveSon(Son);
	}
}
