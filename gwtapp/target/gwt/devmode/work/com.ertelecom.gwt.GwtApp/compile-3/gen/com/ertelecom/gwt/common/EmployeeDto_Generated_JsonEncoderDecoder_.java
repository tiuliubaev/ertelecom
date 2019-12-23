package com.ertelecom.gwt.common;

public class EmployeeDto_Generated_JsonEncoderDecoder_ extends org.fusesource.restygwt.client.AbstractJsonEncoderDecoder<com.ertelecom.gwt.common.EmployeeDto> {
  
  public static final EmployeeDto_Generated_JsonEncoderDecoder_ INSTANCE = new EmployeeDto_Generated_JsonEncoderDecoder_();
  
  public com.google.gwt.json.client.JSONValue encode(com.ertelecom.gwt.common.EmployeeDto value) {
    if( value==null ) {
      return getNullType();
    }
    com.google.gwt.json.client.JSONObject rc = new com.google.gwt.json.client.JSONObject();
    com.ertelecom.gwt.common.EmployeeDto parseValue = (com.ertelecom.gwt.common.EmployeeDto)value;
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.LONG.encode(parseValue.getId()), rc, "id");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getLast_name()), rc, "last_name");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getFst_name()), rc, "fst_name");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getMid_name()), rc, "mid_name");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getJob_title()), rc, "job_title");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getWork_ph_num()), rc, "work_ph_num");
    return rc;
  }
  
  public com.ertelecom.gwt.common.EmployeeDto decode(com.google.gwt.json.client.JSONValue value) {
    if( value == null || value.isNull()!=null ) {
      return null;
    }
    com.google.gwt.json.client.JSONObject object = toObject(value);
    com.ertelecom.gwt.common.EmployeeDto rc = new com.ertelecom.gwt.common.EmployeeDto();
    rc.setId(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.LONG.decode(object.get("id")), null));
    rc.setLast_name(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("last_name")), null));
    rc.setFst_name(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("fst_name")), null));
    rc.setMid_name(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("mid_name")), null));
    rc.setJob_title(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("job_title")), null));
    rc.setWork_ph_num(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("work_ph_num")), null));
    return rc;
  }
  
}
