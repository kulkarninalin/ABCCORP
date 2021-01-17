package com.abc.corp.dao;

import com.abc.corp.modal.Employee;

public interface EmployeeDao {

	boolean store(Employee emp);

	Long deptEmpCount();

	Long count();

	void update(Employee emp);

}
