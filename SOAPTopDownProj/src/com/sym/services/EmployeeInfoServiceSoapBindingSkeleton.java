/**
 * EmployeeInfoServiceSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sym.services;

public class EmployeeInfoServiceSoapBindingSkeleton implements com.sym.services.EmployeeInfoService, org.apache.axis.wsdl.Skeleton {
    private com.sym.services.EmployeeInfoService impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://services.sym.com", "empId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getEmployeeInfo", _params, new javax.xml.namespace.QName("http://services.sym.com", "getEmployeeInfoReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dto.sym.com", "EmployeeDTO"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://services.sym.com", "getEmployeeInfo"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getEmployeeInfo") == null) {
            _myOperations.put("getEmployeeInfo", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getEmployeeInfo")).add(_oper);
    }

    public EmployeeInfoServiceSoapBindingSkeleton() {
        this.impl = new com.sym.services.EmployeeInfoServiceSoapBindingImpl();
    }

    public EmployeeInfoServiceSoapBindingSkeleton(com.sym.services.EmployeeInfoService impl) {
        this.impl = impl;
    }
    public com.sym.dto.EmployeeDTO getEmployeeInfo(java.lang.String empId) throws java.rmi.RemoteException
    {
        com.sym.dto.EmployeeDTO ret = impl.getEmployeeInfo(empId);
        return ret;
    }

}
