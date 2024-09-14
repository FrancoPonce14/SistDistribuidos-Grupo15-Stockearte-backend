package com.server.util;

import java.util.UUID;

public class Utility {

    public static String generarCaracteresAlAzar() {
        UUID caracteresAlAzar = UUID.randomUUID();
        String response = caracteresAlAzar.toString().replace("-", "");
        return response.substring(0, 10);
    }
    
}
