package com.asyncapi.v2;

import com.asyncapi.v2.model.security_scheme.SecurityScheme;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        SecurityScheme securityScheme = SecurityScheme.builder()
                .type(SecurityScheme.Type.X509)
                .build();
        SecurityScheme scheme = objectMapper.readValue("{\"type\": \"X509\"}", SecurityScheme.class);

        System.out.println("Built: " + securityScheme);
        System.out.println("Read: " + scheme);
        System.out.println(securityScheme.equals(scheme));
    }

}
