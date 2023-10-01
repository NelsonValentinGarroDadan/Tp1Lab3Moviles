package com.example.login.Request;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.login.Models.Usuario;

public class ApiClient {
    private static SharedPreferences sp;

    private static SharedPreferences conextar(Context context){
        if(sp==null){
            sp = context.getSharedPreferences("Datos",0) ;
        }
        return sp;
    }
    public static void guardar(Context context, Usuario usuario){
        SharedPreferences sp = conextar(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("DNI",usuario.getDNI());
        editor.putString("Nombre",usuario.getNombre());
        editor.putString("Apellido",usuario.getApellido());
        editor.putString("Mail",usuario.getMail());
        editor.putString("Password",usuario.getPassword());
        editor.commit();
    }
    public static Usuario leer(Context context){
        SharedPreferences sp = conextar(context);
        String dni = sp.getString("DNI","");
        String nombre = sp.getString("Nombre","");
        String apellido = sp.getString("Apellido","");
        String mail = sp.getString("Mail","");
        String password = sp.getString("Password","");
        Usuario user = new Usuario(dni,nombre,apellido,mail,password);
        return user;

    }
    public static Usuario login (Context context, String mail , String password){
        Usuario userPrefe = leer(context);
        Usuario user = null;
        if(userPrefe.getMail().equals(mail)&&userPrefe.getPassword().equals(password)){
            return userPrefe;
        }else{
            return user;
        }
    }
}
