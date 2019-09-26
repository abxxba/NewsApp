package com.example.newsapp.utils;

public class httpConfig {

    public static String googleClientId = "24562798768-o8dv5t3noertd8ig95ghbnco5ipf2g1u.apps.googleusercontent.com";

    private String serverUrl = "http://192.168.8.100";

    private String selectedFont = "roboto_thin.ttf";

    private static httpConfig httpconfig = new httpConfig();

    public static synchronized httpConfig getInstance() {
        return httpconfig;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public String getSelectedFont() {
        return selectedFont;
    }

    public String getGoogleClientId() {
        return googleClientId;
    }

}
