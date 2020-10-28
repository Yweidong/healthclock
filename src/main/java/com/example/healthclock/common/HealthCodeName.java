package com.example.healthclock.common;

public enum HealthCodeName {
    GREEN(1,"正常上学"),
    CYAN(2,"予以准假"),
    YELLOW(3,"居家观察或前往就诊"),
    RED(4,"继续诊治,早日复学"),
    ;

    private Integer code;
   private String message;

    HealthCodeName(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HealthCodeName{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
