package org.patsimas.school.api;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.patsimas.school.model.entity.User;


public class JsonHelper {
    
    static void writeJson(Writer w, String key, String value) throws IOException {
        JsonWriter json = new JsonWriter(w);
        json.beginObject();
        json.name(key).value(value);
        json.endObject();
    }
    
    
    static void writeJson(Writer w, List<User> users) throws IOException {
        JsonWriter json = new JsonWriter(w);
        json.beginArray();
        for(User u: users) {
            json.beginObject();
            writeJson(json, u);
            json.endObject();
        }
        json.endArray();
    }
    
    private static void writeJson(JsonWriter json, User u) throws IOException {
        json.name("id").value(u.getId());
        json.name("username").value(u.getUsername());
        json.name("password").value(u.getPassword());
    }
}
