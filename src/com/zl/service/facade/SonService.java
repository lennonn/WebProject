/**
 * 
 */
package com.zl.service.facade;

import com.zl.dto.domain.Dept;
import com.zl.dto.domain.Son;

/**
 * @author zlennon
 *
 */
public interface SonService {
		public void saveSon(Son son);
		public Son getById(String id);
}
