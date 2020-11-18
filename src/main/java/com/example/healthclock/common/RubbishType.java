package com.example.healthclock.common;

public enum RubbishType {
    HARMFUL("A","有害垃圾"),
    KITCHEN("B","厨余垃圾"),
    OTHER("C","其他垃圾"),
    RECYCLABLE("D","可回收物"),
    ;

    private String option;
    private String message;

    RubbishType() {
    }

    RubbishType(String option, String message) {
        this.option = option;
        this.message = message;
    }


    public static String getOption(String message) {
        for (RubbishType value : RubbishType.values()) {
                if(value.getMessage().equals(message)) {
                    return value.option;
                }
        }
        return null;
    }

    public static String getMessage(String option) {
        for (RubbishType value : RubbishType.values()) {
            if(value.getOption().equals(option)) {
                return value.message;
            }
        }
        return null;
    }



    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RubbishType{" +
                "option='" + option + '\'' +
                ", message='" + message + '\'' +
                '}';
    }


}
