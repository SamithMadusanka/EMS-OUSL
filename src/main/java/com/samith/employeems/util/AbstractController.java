package com.samith.employeems.util;

/**
 * @author - Samith Madusanka on 2020-01-06
 * @project - bgk
 **/


import com.samith.employeems.response.EMPResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;


public class AbstractController {

    HashMap<Integer, String> codeStatusMap = new HashMap<>();

    public AbstractController() {
        codeStatusMap.put(200, "OK");
        codeStatusMap.put(201, "Created");
        codeStatusMap.put(204, "No Content");
        codeStatusMap.put(400, "Bad Request");
        codeStatusMap.put(401, "Unauthorized");
        codeStatusMap.put(403, "Forbidden");
        codeStatusMap.put(404, "Not Found");
        codeStatusMap.put(500, "Server Error");
    }

    public ResponseEntity<Object> sendSuccessResponse(Object object) {
        return ResponseEntity.ok().body(new EMPResponse(object, codeStatusMap.get(200)));
    }

    public ResponseEntity<Object> sendSuccessResponseWithHeader(String header, Object objectHeader, Object entity) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(header, objectHeader.toString());
        return ResponseEntity.ok().headers(headers).body(new EMPResponse(entity, codeStatusMap.get(200)));
    }

    public ResponseEntity<Object> sendSuccessResponseWithHeaderNoContent(String header, Object objectHeader) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(header, objectHeader.toString());
        return ResponseEntity.noContent().headers(headers).build();
    }

    public ResponseEntity<Object> handleServiceException(Exception e) {
        EMPResponse EMPResponse = new EMPResponse();
        EMPResponse.setSuccess(false);
        EMPResponse.setErrorMessage(e.getMessage());
        EMPResponse.setRequestedURI(null);
        EMPResponse.setStatusInfo(codeStatusMap.get(500));
        return ResponseEntity.badRequest().body(EMPResponse);

    }

    public ResponseEntity<Object> sendUnAuthenticationResponse(Exception e) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Subject", "Authentication Fail.");
        return ResponseEntity.badRequest().body(new EMPResponse(e.getMessage(), codeStatusMap.get(401)));
    }
}



