package com.ertelecom.gwt.common;

public class StatusDto_Generated_JsonEncoderDecoder_ extends org.fusesource.restygwt.client.AbstractJsonEncoderDecoder<com.ertelecom.gwt.common.StatusDto> {
  
  public static final StatusDto_Generated_JsonEncoderDecoder_ INSTANCE = new StatusDto_Generated_JsonEncoderDecoder_();
  
  public com.google.gwt.json.client.JSONValue encode(com.ertelecom.gwt.common.StatusDto value) {
    if( value==null ) {
      return getNullType();
    }
    com.google.gwt.json.client.JSONObject rc = new com.google.gwt.json.client.JSONObject();
    com.ertelecom.gwt.common.StatusDto parseValue = (com.ertelecom.gwt.common.StatusDto)value;
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getId()), rc, "id");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getText()), rc, "text");
    return rc;
  }
  
  public com.ertelecom.gwt.common.StatusDto decode(com.google.gwt.json.client.JSONValue value) {
    if( value == null || value.isNull()!=null ) {
      return null;
    }
    com.google.gwt.json.client.JSONObject object = toObject(value);
    com.ertelecom.gwt.common.StatusDto rc = new com.ertelecom.gwt.common.StatusDto();
    rc.setId(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("id")), 0));
    rc.setText(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("text")), null));
    return rc;
  }
  
}
