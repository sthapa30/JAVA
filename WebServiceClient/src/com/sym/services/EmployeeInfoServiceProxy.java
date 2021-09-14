package com.sym.services;

public class EmployeeInfoServiceProxy implements com.sym.services.EmployeeInfoService {
  private String _endpoint = null;
  private com.sym.services.EmployeeInfoService employeeInfoService = null;
  
  public EmployeeInfoServiceProxy() {
    _initEmployeeInfoServiceProxy();
  }
  
  public EmployeeInfoServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmployeeInfoServiceProxy();
  }
  
  private void _initEmployeeInfoServiceProxy() {
    try {
      employeeInfoService = (new com.sym.services.EmployeeInfoServiceServiceLocator()).getEmployeeInfoService();
      if (employeeInfoService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)employeeInfoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)employeeInfoService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (employeeInfoService != null)
      ((javax.xml.rpc.Stub)employeeInfoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.sym.services.EmployeeInfoService getEmployeeInfoService() {
    if (employeeInfoService == null)
      _initEmployeeInfoServiceProxy();
    return employeeInfoService;
  }
  
  public com.sym.dto.EmployeeDTO getEmployeeInfo(java.lang.String empId) throws java.rmi.RemoteException{
    if (employeeInfoService == null)
      _initEmployeeInfoServiceProxy();
    return employeeInfoService.getEmployeeInfo(empId);
  }
  
  
}