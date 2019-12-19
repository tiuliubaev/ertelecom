package com.ertelecom.gwt.common;

public class TaskDto_Generated_JsonEncoderDecoder_ extends org.fusesource.restygwt.client.AbstractJsonEncoderDecoder<com.ertelecom.gwt.common.TaskDto> {
  
  public static final TaskDto_Generated_JsonEncoderDecoder_ INSTANCE = new TaskDto_Generated_JsonEncoderDecoder_();
  
  public com.google.gwt.json.client.JSONValue encode(com.ertelecom.gwt.common.TaskDto value) {
    if( value==null ) {
      return getNullType();
    }
    com.google.gwt.json.client.JSONObject rc = new com.google.gwt.json.client.JSONObject();
    com.ertelecom.gwt.common.TaskDto parseValue = (com.ertelecom.gwt.common.TaskDto)value;
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.LONG.encode(parseValue.getId()), rc, "id");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getName()), rc, "name");
    isNotNullValuePut(com.ertelecom.gwt.common.EmployeeDto_Generated_JsonEncoderDecoder_.INSTANCE.encode(parseValue.getOwner()), rc, "owner");
    isNotNullValuePut(com.ertelecom.gwt.common.EmployeeDto_Generated_JsonEncoderDecoder_.INSTANCE.encode(parseValue.getExecutor()), rc, "executor");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getDescription()), rc, "description");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getStatus()), rc, "status");
    return rc;
  }
  
  public com.ertelecom.gwt.common.TaskDto decode(com.google.gwt.json.client.JSONValue value) {
    if( value == null || value.isNull()!=null ) {
      return null;
    }
    com.google.gwt.json.client.JSONObject object = toObject(value);
    com.ertelecom.gwt.common.TaskDto rc = new com.ertelecom.gwt.common.TaskDto();
    rc.setId(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.LONG.decode(object.get("id")), null));
    rc.setName(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("name")), null));
    rc.setOwner(getValueToSet(com.ertelecom.gwt.common.EmployeeDto_Generated_JsonEncoderDecoder_.INSTANCE.decode(object.get("owner")), null));
    rc.setExecutor(getValueToSet(com.ertelecom.gwt.common.EmployeeDto_Generated_JsonEncoderDecoder_.INSTANCE.decode(object.get("executor")), null));
    rc.setDescription(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("description")), null));
    rc.setStatus(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("status")), null));
    return rc;
  }
  
}
