package com.abc.corp.service;

import com.abc.corp.modal.Employee;

public interface EmplyeeService {

	boolean insertData(Employee employee) throws Exception;

	void getDeptWiseCount();

	void getCount();

	void updateData();

}
