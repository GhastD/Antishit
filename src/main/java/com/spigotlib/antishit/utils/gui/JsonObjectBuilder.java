package com.spigotlib.antishit.utils.gui;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * @author 7x6
 * @since 14/08/2019
 */
public class JsonObjectBuilder {

    private JsonObject jsonObject = new JsonObject();

    public JsonObjectBuilder addProperty(String key, String value) {
        jsonObject.addProperty(key, value);
        return this;
    }

    public JsonObjectBuilder addProperty(String key, int value) {
        jsonObject.addProperty(key, value);
        return this;
    }

    public JsonObjectBuilder addProperty(String key, double value) {
        jsonObject.addProperty(key, value);
        return this;
    }

    public JsonObjectBuilder addProperty(String key, long value) {
        jsonObject.addProperty(key, value);
        return this;
    }

    public JsonObjectBuilder addProperty(String key, float value) {
        jsonObject.addProperty(key, value);
        return this;
    }

    public JsonObjectBuilder addProperty(String key, char value) {
        jsonObject.addProperty(key, value);
        return this;
    }

    public JsonObjectBuilder addProperty(String key, boolean value) {
        jsonObject.addProperty(key, value);
        return this;
    }

    public JsonObjectBuilder addProperty(String key, JsonElement value) {
        jsonObject.add(key, value);
        return this;
    }

    public JsonObject get() {
        return jsonObject;
    }
}
