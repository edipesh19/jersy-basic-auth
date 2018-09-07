package org.dipesh.jersey.rest.simple_restapi.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.dipesh.jersey.rest.simple_restapi.model.User;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class UserDao implements GenericDao<User> {

	static Logger log = Logger.getLogger(UserDao.class.getName());

	private static Reader rd;
	private static SqlMapClient smc;

	private static UserDao INSTANCE = new UserDao();

	static {
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			log.fatal("Unable to start because " + e.getMessage());
		}
	}

	public static UserDao getInstance() {
		return INSTANCE;
	}

	@Override
	public List<User> getAll() {
		List<User> queryForList = null;
		try {
			queryForList = (List<User>) smc.queryForList("User.getAll", null);
			return queryForList;
		} catch (SQLException e) {
			log.error("Unable to get the user because " + e.getMessage());
		}
		return queryForList;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User create(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
