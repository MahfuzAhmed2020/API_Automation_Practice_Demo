package com.osa.utility;

import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.JSONObject;
import org.testng.Assert;

public class Utilities {
    public static JSONObject getJsonObject(Map<String, String> values) {
        return new JSONObject(values);
    }

    public static void verifyStatu(String expected, String actual) {
        Assert.assertEquals(actual, expected);
    }

    public static Logger getLog(Class<?> type) {
        java.net.URL configuration = Utilities.class.getClassLoader().getResource("log4j.properties");
        if (configuration != null) PropertyConfigurator.configure(configuration);
        return Logger.getLogger(type);
    }
}
