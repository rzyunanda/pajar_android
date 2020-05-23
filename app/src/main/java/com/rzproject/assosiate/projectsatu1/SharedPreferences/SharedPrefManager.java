package com.rzproject.assosiate.projectsatu1.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    public static final String SP_TOKEN = null;
    public static final String SP_User = "spUser";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharedPrefManager(Context context){
        sp = context.getSharedPreferences(SP_User, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPToken(String token){
        spEditor.putString(SP_TOKEN, token);
        spEditor.commit();
    }

    public String getSpToken(){
        return sp.getString(SP_TOKEN, "");
    }

}
