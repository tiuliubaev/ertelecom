package com.ertelecom.gwt.client;

import com.ertelecom.gwt.common.EmployeeDto;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.*;
import java.util.List;

@Path("/")
public interface EmployeesClient extends RestService {

    @GET
    @Path("employees/")
    void refresh(@HeaderParam("Authorization") String token, MethodCallback<List<EmployeeDto>> employees);

    @GET
    @Path("employees?last_name={last_name}&fst_name={fst_name}")
    void getAllEmployees(@HeaderParam("Authorization") String token, @PathParam("last_name") String last_name, @PathParam("fst_name") String fst_name, MethodCallback<List<EmployeeDto>> employees);

    @POST
    @Path("tasks/")
    void saveEmployee(@HeaderParam("Authorization") String token, @BeanParam EmployeeDto employeeDto, MethodCallback<List<EmployeeDto>> employees);

    @GET
    @Path("employees/delete/{id}")
    void removeEmployee(@HeaderParam("Authorization") String token, @PathParam("id") String id, MethodCallback<Void> result);

}
