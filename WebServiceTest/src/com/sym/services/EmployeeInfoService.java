/**
 * EmployeeInfoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sym.services;

public interface EmployeeInfoService extends java.rmi.Remote {
    public java.lang.String addEmployee(java.lang.String empId, java.lang.String firstName, java.lang.String lastName, java.lang.String email, java.lang.String hireDate, java.lang.String jobID) throws java.rmi.RemoteException;
    public com.sym.dto.EmployeeDTO getEmployeeInfo(java.lang.String empId) throws java.rmi.RemoteException;
    public java.lang.String updateEmployeeInfo(java.lang.String empId, java.lang.String firstName, java.lang.String lastName, java.lang.String email, java.lang.String hireDate, java.lang.String jobID) throws java.rmi.RemoteException;
    public java.lang.String deleteEmployee(java.lang.String empId) throws java.rmi.RemoteException;
}
