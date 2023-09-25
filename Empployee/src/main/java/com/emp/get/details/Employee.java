package com.emp.get.details;

public class Employee {
	private String employeeId;
	private String employeeName;
	private String employeeDesignation;
	private double employeeSal;

	public Employee(String employeeId, String employeeName, String employeeDesignation, double employeeSal) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeDesignation = employeeDesignation;
		this.employeeSal = employeeSal;
	}

	public Employee() {
		super();
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public double getEmployeeSal() {
		return employeeSal;
	}

	public void setEmployeeSal(double employeeSal) {
		this.employeeSal = employeeSal;
	}
	
	

}
