package com.inspur.spring;

public interface IAccountDao {
	public void addMoney(String userName,Integer money);
	public void subMoney(String userName,Integer money);
	public String getAccountMoney(String userName);
	public void transAccount(String source,String target,Integer money);
	public void transAccountDeclare(String source,String target,Integer money);
	public void transAccountDeclareAnnotation(String source,String target,Integer money);
	
}
