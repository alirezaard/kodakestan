package com.kodakestan.kodak.configuration;

public final class Constants {


    public static final String LOGIN_REGEX = "^[_'.@A-Za-z0-9-]*$";
    public static final String SPRING_PROFILE_TEST = "test";
    public static final String SPRING_PROFILE_PRODUCTION = "prod";
    public static final String SPRING_PROFILE_CLOUD = "cloud";
    public static final String SPRING_PROFILE_HEROKU = "heroku";
    public static final String SYSTEM_ACCOUNT = "system";
    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    public final static String GATEWAY_RATE_LIMITING_CACHE_NAME = "gateway-rate-limiting";

    private Constants() {
    }
}