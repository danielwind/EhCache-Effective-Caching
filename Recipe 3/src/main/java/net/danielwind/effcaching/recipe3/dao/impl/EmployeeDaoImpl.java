package net.danielwind.effcaching.recipe3.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import net.danielwind.effcaching.recipe3.dao.EmployeeDao;
import net.danielwind.effcaching.recipe3.domain.Employee;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {

	private static final Logger log = Logger.getLogger(EmployeeDaoImpl.class);
	
	@Autowired
	public EmployeeDaoImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	/**
	 * @{inheritDoc}
	 */
	@Cacheable("employeeCache")
	public List<Employee> findAll() {
		log.info("--- Accessing Dao Layer: EmployeeDaoImpl.findAll() ---");
		String sql = "SELECT * FROM employees";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
	}

}
