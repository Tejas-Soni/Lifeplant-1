package com.example.user.lifeplant;


import okhttp3.MediaType;

/**
 * Created by  on 11/01/16.
 */
public class WSConstants {
    public final static String BASE_URL = "http://192.168.2.9/iant/";

    public final static int CONNECTION_TIMEOUT = 30;
    public final static int SUCCESS_1 = 1;
    public final static int SUCCESS_2 = 2;
    public final static int SUCCESS_100 = 100;


    public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");


    public final String DEVICE_TYPE = "ANDROID";
    public final String DEVICE_TYPE_ANDROID = "android";
    public final String PARAMS_RESPONSE = "response";
    public final String PARAMS_SUCCESS = "success";
    public final String PARAMS_NEXT_PAGE = "next_page";
    public final String PARAMS_RESULT = "result";
    public final String PARAMS_ID = "id";
    public final String PARAMS_QUESTION_MARK = "?";
    public final String PARAMS_AND = "&";
    public final String PARAMS_EQUAL = "=";
    public final String PARAMS_SPACE = "%20";

    public enum Language {
        EN,
        NL,
    }


    /**
     * Settings Name
     */
    public final String PARAMS_SETTINGS = "settings";

    /**
     * Methods Name
     */
    public final static String METHOD_LOGIN = "Login.php";
    public final static String METHOD_SIGNUP = "insert.php";


    /**
     * Parameters Name
     */
    public final String PARAMS_COMPANY_NAME = "company_name";
public final String PARAMS_EMAIL = "email";
public final String PARAMS_PASSWORD = "password";
    public final String PARAMS_FNAME = "fname";
    public final String PARAMS_LNAME = "lname";
    public final String PARAMS_GENDER = "gender";
    public final String PARAMS_MOBNO = "mobileno";
    public final String PARAMS_BIRTHD = "birthdate";

}
