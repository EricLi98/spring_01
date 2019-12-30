package com.inspur.spring;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class AccountDaoImpl implements IAccountDao {
	private DataSource dataSource;//数据源，可以注入
	private DataSourceTransactionManager tm;//事务管理器,进行注入

	public DataSource getDataSource() {
		return dataSource;
	}

	public DataSourceTransactionManager getTm() {
		return tm;
	}

	public void setTm(DataSourceTransactionManager tm) {
		this.tm = tm;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void addMoney(String userName, Integer money) {
		// TODO Auto-generated method stub
		
		//TransactionDefinition tdefinition=new DefaultTransactionDefinition(DefaultTransactionDefinition.PROPAGATION_NEVER);
		//根据事务的定义，开启一个事务
		//TransactionStatus ts=this.tm.getTransaction(tdefinition);
		JdbcTemplate jdbcTemplate=new JdbcTemplate(this.dataSource);
		jdbcTemplate.update("update accounttb set money=money+? where username=?",new String[]{money.toString(),userName});
		//tm.commit(ts);
	}

	@Override
	public void subMoney(String userName, Integer money) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(this.dataSource);
		jdbcTemplate.update("update accounttb set money=money-? where username=?",new String[]{money.toString(),userName});
	}

	@Override
	public String getAccountMoney(String userName) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate=new JdbcTemplate(this.dataSource);
		int result=jdbcTemplate.queryForInt("select money from accounttb where username=?",new String[]{userName});
		return ""+result;
	}

	//编程式事务管理
	@Override
	public void transAccount(String source, String target, Integer money) {
		// TODO Auto-generated method stub
		//使用默认的事务定义
		TransactionDefinition tdefinition=new DefaultTransactionDefinition();
		
		//根据事务的定义，开启一个事务
		TransactionStatus ts=this.tm.getTransaction(tdefinition);
		try{
			subMoney(source,money);
			int a=1/0;
			addMoney(target,money);
			tm.commit(ts);//正常提交
		}catch(Exception e){
			tm.rollback(ts);//进行回滚
			e.printStackTrace();
		}
		
	}

	@Override
	public void transAccountDeclare(String source, String target, Integer money) {
		// TODO Auto-generated method stub
		subMoney(source,money);
		int a=1/0;
		addMoney(target,money);
	}

	@Override
	@Transactional
	public void transAccountDeclareAnnotation(String source, String target,
			Integer money) {
		// TODO Auto-generated method stub
		
		subMoney(source,money);
		int a=1/0;
		addMoney(target,money);
		
	}

}
