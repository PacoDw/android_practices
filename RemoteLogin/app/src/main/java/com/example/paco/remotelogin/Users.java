package com.example.paco.remotelogin;

import org.json.JSONException;
import org.json.JSONObject;

public class Users {

    public int id_user;
    public String name;
    public String username;
    public String password;

    public Users(JSONObject objJSON) {
        try {
            id_user = objJSON.getInt("id_user");
            name = objJSON.getString("name");
            username = objJSON.getString("username");
            password = objJSON.getString("password");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
