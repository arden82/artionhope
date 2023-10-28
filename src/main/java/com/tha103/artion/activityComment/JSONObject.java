package com.tha103.artion.activityComment;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONObject {
    private JsonObject jsonObject;

    public JSONObject(String jsonString) {
        JsonParser parser = new JsonParser();
        this.jsonObject = parser.parse(jsonString).getAsJsonObject();
    }

    public String getString(String key) {
        return jsonObject.get(key).getAsString();
    }

    public double getDouble(String key) {
        return jsonObject.get(key).getAsDouble();
    }

    public long getLong(String key) {
        return jsonObject.get(key).getAsLong();
    }
}

    
    

