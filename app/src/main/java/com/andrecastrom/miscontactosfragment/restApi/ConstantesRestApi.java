package com.andrecastrom.miscontactosfragment.restApi;

public final class ConstantesRestApi {

    //https://api.instagram.com/v1/

    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "3918358801.3ffdea6.42f6cf9d434b4309aba72d072ed3e6db";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";

    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS_TOKEN
    public static final String URL_GET_RECENT_MEDIA_USER =
            KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;



}
