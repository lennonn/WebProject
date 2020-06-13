/**
 * 
 */
package com.zl.persistence.dao;

import com.zl.dto.domain.Dept;
import com.zl.dto.domain.Son;

/**
 * @author zlennon
 *
 */
public interface SonDao {
	public void saveSon(Son son);

    Son getSonById(String id);
}
