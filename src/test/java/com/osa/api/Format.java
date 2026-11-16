package com.osa.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import io.restassured.response.Response;

public class Format {
    public static String prettyPrint(Response response) {
        return prettyPrint(response.asString());
    }

    public static String prettyPrint(String value) {
        if (value == null || value.trim().isEmpty()) return "<empty response>";
        String trimmed = value.trim();
        try {
            if (trimmed.startsWith("{")) return new JSONObject(trimmed).toString(4);
            if (trimmed.startsWith("[")) return new JSONArray(trimmed).toString(4);
        } catch (JSONException ignored) {
            // Logging must preserve non-JSON responses rather than fail the scenario.
        }
        return value;
    }
}
