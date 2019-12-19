package com.ertelecom.gwt.client;

public class TasksClient_Generated_RestServiceProxy_ implements com.ertelecom.gwt.client.TasksClient, org.fusesource.restygwt.client.RestServiceProxy {
  private org.fusesource.restygwt.client.Resource resource = null;
  
  public void setResource(org.fusesource.restygwt.client.Resource resource) {
    this.resource = resource;
  }
  public org.fusesource.restygwt.client.Resource getResource() {
    if (this.resource == null) {
      String serviceRoot = org.fusesource.restygwt.client.Defaults.getServiceRoot();
      this.resource = new org.fusesource.restygwt.client.Resource(serviceRoot).resolve("/");
    }
    return this.resource;
  }
  private org.fusesource.restygwt.client.Dispatcher dispatcher = null;
  
  public void setDispatcher(org.fusesource.restygwt.client.Dispatcher dispatcher) {
    this.dispatcher = dispatcher;
  }
  
  public org.fusesource.restygwt.client.Dispatcher getDispatcher() {
    return this.dispatcher;
  }
  public void deleteItem(java.lang.String id, org.fusesource.restygwt.client.MethodCallback<java.lang.Void> result) {
    final java.lang.String final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/"+(id== null? null : com.google.gwt.http.client.URL.encodePathSegment(id))+"")
    .delete();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.lang.Void>(__method, result) {
        protected java.lang.Void parseResult() throws Exception {
          return (java.lang.Void) null;
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      result.onFailure(__method,__e);
    }
  }
  public void getAllExecutors(java.lang.String token, org.fusesource.restygwt.client.MethodCallback<java.util.List<com.ertelecom.gwt.common.EmployeeDto>> result) {
    final java.lang.String final_token = token;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("tasks/executors")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.header("Authorization", token);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.util.List<com.ertelecom.gwt.common.EmployeeDto>>(__method, result) {
        protected java.util.List<com.ertelecom.gwt.common.EmployeeDto> parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toList(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()), com.ertelecom.gwt.common.EmployeeDto_Generated_JsonEncoderDecoder_.INSTANCE);
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      result.onFailure(__method,__e);
    }
  }
  public void getAllOwners(java.lang.String token, org.fusesource.restygwt.client.MethodCallback<java.util.List<com.ertelecom.gwt.common.EmployeeDto>> result) {
    final java.lang.String final_token = token;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("tasks/owners")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.header("Authorization", token);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.util.List<com.ertelecom.gwt.common.EmployeeDto>>(__method, result) {
        protected java.util.List<com.ertelecom.gwt.common.EmployeeDto> parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toList(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()), com.ertelecom.gwt.common.EmployeeDto_Generated_JsonEncoderDecoder_.INSTANCE);
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      result.onFailure(__method,__e);
    }
  }
  public void getAllStatus(java.lang.String token, org.fusesource.restygwt.client.MethodCallback<java.util.List<com.ertelecom.gwt.common.StatusDto>> result) {
    final java.lang.String final_token = token;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("tasks/taskStatus")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.header("Authorization", token);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.util.List<com.ertelecom.gwt.common.StatusDto>>(__method, result) {
        protected java.util.List<com.ertelecom.gwt.common.StatusDto> parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toList(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()), com.ertelecom.gwt.common.StatusDto_Generated_JsonEncoderDecoder_.INSTANCE);
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      result.onFailure(__method,__e);
    }
  }
  public void getAllTasks(java.lang.String token, java.lang.String status, java.lang.String executor, org.fusesource.restygwt.client.MethodCallback<java.util.List<com.ertelecom.gwt.common.TaskDto>> tasks) {
    final java.lang.String final_token = token;
    final java.lang.String final_status = status;
    final java.lang.String final_executor = executor;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("tasks?status="+(status== null? null : com.google.gwt.http.client.URL.encodePathSegment(status))+"&executor="+(executor== null? null : com.google.gwt.http.client.URL.encodePathSegment(executor))+"")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.header("Authorization", token);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.util.List<com.ertelecom.gwt.common.TaskDto>>(__method, tasks) {
        protected java.util.List<com.ertelecom.gwt.common.TaskDto> parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toList(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()), com.ertelecom.gwt.common.TaskDto_Generated_JsonEncoderDecoder_.INSTANCE);
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      tasks.onFailure(__method,__e);
    }
  }
  public void refresh(java.lang.String token, org.fusesource.restygwt.client.MethodCallback<java.util.List<com.ertelecom.gwt.common.TaskDto>> tasks) {
    final java.lang.String final_token = token;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("tasks/")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.header("Authorization", token);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.util.List<com.ertelecom.gwt.common.TaskDto>>(__method, tasks) {
        protected java.util.List<com.ertelecom.gwt.common.TaskDto> parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toList(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()), com.ertelecom.gwt.common.TaskDto_Generated_JsonEncoderDecoder_.INSTANCE);
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      tasks.onFailure(__method,__e);
    }
  }
  public void removeItem(java.lang.String token, java.lang.String id, org.fusesource.restygwt.client.MethodCallback<java.lang.Void> result) {
    final java.lang.String final_token = token;
    final java.lang.String final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("tasks/delete/"+(id== null? null : com.google.gwt.http.client.URL.encodePathSegment(id))+"")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.header("Authorization", token);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.lang.Void>(__method, result) {
        protected java.lang.Void parseResult() throws Exception {
          return (java.lang.Void) null;
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      result.onFailure(__method,__e);
    }
  }
  public void saveTask(java.lang.String token, com.ertelecom.gwt.common.TaskDto taskDto, org.fusesource.restygwt.client.MethodCallback<java.util.List<com.ertelecom.gwt.common.TaskDto>> tasks) {
    final java.lang.String final_token = token;
    final com.ertelecom.gwt.common.TaskDto final_taskDto = taskDto;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("tasks/")
    .post();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.header("Authorization", token);
    __method.json(com.ertelecom.gwt.common.TaskDto_Generated_JsonEncoderDecoder_.INSTANCE.encode(taskDto));
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.util.List<com.ertelecom.gwt.common.TaskDto>>(__method, tasks) {
        protected java.util.List<com.ertelecom.gwt.common.TaskDto> parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toList(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()), com.ertelecom.gwt.common.TaskDto_Generated_JsonEncoderDecoder_.INSTANCE);
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      tasks.onFailure(__method,__e);
    }
  }
}
