package com.abc.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.corp.dao.EmployeeDao;
import com.abc.corp.modal.Employee;

@Service
public class EmplyeeServiceImpl implements EmplyeeService {

	@Autowired
	private EmployeeDao empDao;
	
	@Override
	public boolean insertData(Employee employee) throws Exception {
		boolean result = false;
		if(employee != null & employee.getEmployeeId() > 0) {
			result = empDao.store(employee);
		}else {
			throw new Exception("Invalid request");
		}
		return result;
		
	}

	@Override
	public void getDeptWiseCount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getCount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}

}
