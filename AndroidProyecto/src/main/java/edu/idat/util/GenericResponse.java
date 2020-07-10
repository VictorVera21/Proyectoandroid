package edu.idat.util;

public class GenericResponse {
    private String type;
    private int rpta;
    private String message;
    private Object body;

    public GenericResponse() {
        type = "";
        rpta = 0;
        message = "";
        body = new Object();
    }

    public GenericResponse(String bodyType, Object body) {
        type = "";
        rpta = 0;
        message = "";
        this.body = body;
    }

    public GenericResponse(String type, int rpta, String message, Object body) {
        this.type = type;
        this.rpta = rpta;
        this.message = message;
        this.body = body;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRpta() {
        return rpta;
    }

    public void setRpta(int rpta) {
        this.rpta = rpta;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
