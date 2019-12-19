package com.ertelecom.gwt.client;

import com.ertelecom.gwt.common.EmployeeDto;
import com.ertelecom.gwt.common.StatusDto;
import com.ertelecom.gwt.common.TaskDto;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.*;
import java.util.List;

@Path("/")
public interface TasksClient extends RestService {

    @GET
    @Path("tasks/")
    void refresh(@HeaderParam("Authorization") String token, MethodCallback<List<TaskDto>> tasks);

    @POST
    @Path("tasks/")
    void saveTask(@HeaderParam("Authorization") String token, @BeanParam TaskDto taskDto, MethodCallback<List<TaskDto>> tasks);

    @GET
    @Path("tasks?status={status}&executor={executor}")
    void getAllTasks(@HeaderParam("Authorization") String token, @PathParam("status") String status, @PathParam("executor") String executor, MethodCallback<List<TaskDto>> tasks);

    @GET
    @Path("tasks/delete/{id}")
    void removeItem(@HeaderParam("Authorization") String token, @PathParam("id") String id, MethodCallback<Void> result);

    @DELETE
    @Path("/{id}")
    void deleteItem(@PathParam("id") String id, MethodCallback<Void> result);

    @GET
    @Path("tasks/taskStatus")
    void getAllStatus(@HeaderParam("Authorization") String token, MethodCallback<List<StatusDto>> result);

    @GET
    @Path("tasks/executors")
    void getAllExecutors(@HeaderParam("Authorization") String token, MethodCallback<List<EmployeeDto>> result);

    @GET
    @Path("tasks/owners")
    void getAllOwners(@HeaderParam("Authorization") String token, MethodCallback<List<EmployeeDto>> result);

}
