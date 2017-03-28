/**
 * 
 */
package com.zl.persistence.dao;


import com.zl.dto.domain.CUser;


/**
 * @author zlennon
 *
 */
public interface UserDao {
	
	public void saveUser(CUser user);
	public  CUser getUser(String username);
}
