package com.nieyue.dao;

import com.nieyue.bean.Account;

/** 账户管理接口 */
public interface AccountDao extends BaseDao<Account,Integer> {

	/** 账户登录 */
	public Account accountLogin(String identifier,String password);
}