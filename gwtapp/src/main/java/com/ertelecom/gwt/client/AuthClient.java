package com.ertelecom.gwt.client;

import com.ertelecom.gwt.common.JwtAuthRequestDto;
import com.ertelecom.gwt.common.JwtAuthResponseDto;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

public interface AuthClient  extends RestService {
    @POST
    @Path("http://localhost:8189/gwt-rest/authenticate")
    void authenticate(@BeanParam() JwtAuthRequestDto authRequest, MethodCallback<JwtAuthResponseDto> result);
}
