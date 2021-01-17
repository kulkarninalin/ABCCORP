package com.abc.corp.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.abc.corp.modal.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private final String INSERT_EMPLOYEE = "INSERT INTO Employee(employee_id,first_name, last_name, city, age, salary, department) values(:employeeId,:firstName,:lastName,:city,:age,:salary,:department)";

	private final String COUNT_EMPLOYEE = "select count(*) from employee";
	
	private final String DEPARTMENT_EMPLOYEE_COUNT = "select count(*) from Employee where department=:department";

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	

	private Map<Integer, Employee> repository;

	public EmployeeDaoImpl() {
		this.repository = new HashMap<>();
	}

	@Override
	public boolean store(final Employee employee) {
		boolean flag = false;
		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource parameters = new MapSqlParameterSource().addValue("first_name", employee.getFirstName())
				.addValue("last_name", employee.getLastName()).addValue("city", employee.getCity())
				.addValue("salary", employee.getSalary()).addValue("department", employee.getDepartment())
				.addValue("employee_id", employee.getEmployeeId());

		namedParameterJdbcTemplate.update(INSERT_EMPLOYEE, parameters, holder);
		
		if (employee != null)
			flag= true;

		return flag;
	}

	@Override
	public Long deptEmpCount() {
		 return jdbcTemplate.queryForObject(DEPARTMENT_EMPLOYEE_COUNT, Long.class);
	}

	@Override
	public Long count() {
		 return jdbcTemplate.queryForObject(COUNT_EMPLOYEE, Long.class);
	}

	@Override
	public void update(Employee emp) {
		//repository.put(emp.getEmployeeId(), emp);
	}

}
