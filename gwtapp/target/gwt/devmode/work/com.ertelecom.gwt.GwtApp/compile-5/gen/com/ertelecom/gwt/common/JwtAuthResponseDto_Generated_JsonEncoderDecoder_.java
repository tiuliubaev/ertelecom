package com.ertelecom.gwt.common;

public class JwtAuthResponseDto_Generated_JsonEncoderDecoder_ extends org.fusesource.restygwt.client.AbstractJsonEncoderDecoder<com.ertelecom.gwt.common.JwtAuthResponseDto> {
  
  public static final JwtAuthResponseDto_Generated_JsonEncoderDecoder_ INSTANCE = new JwtAuthResponseDto_Generated_JsonEncoderDecoder_();
  
  public com.google.gwt.json.client.JSONValue encode(com.ertelecom.gwt.common.JwtAuthResponseDto value) {
    if( value==null ) {
      return getNullType();
    }
    com.google.gwt.json.client.JSONObject rc = new com.google.gwt.json.client.JSONObject();
    com.ertelecom.gwt.common.JwtAuthResponseDto parseValue = (com.ertelecom.gwt.common.JwtAuthResponseDto)value;
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getToken()), rc, "token");
    return rc;
  }
  
  public com.ertelecom.gwt.common.JwtAuthResponseDto decode(com.google.gwt.json.client.JSONValue value) {
    if( value == null || value.isNull()!=null ) {
      return null;
    }
    com.google.gwt.json.client.JSONObject object = toObject(value);
    com.ertelecom.gwt.common.JwtAuthResponseDto rc = new com.ertelecom.gwt.common.JwtAuthResponseDto();
    rc.setToken(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("token")), null));
    return rc;
  }
  
}
