package com.ulp.request;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.ulp.model.Usuario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ApiClient {

    private static File directorio;
    private static File archivo;

    private static File conectar(Context context) {

        if (directorio == null) {
            directorio = context.getFilesDir();
            archivo = new File(directorio, "configuracion.txt");
            if (!archivo.exists()) {
                try {
                    archivo.createNewFile();
                } catch (IOException e) {
                    Log.d("error", e.toString());
                }
            }

        }
        return archivo;
    }


    public static void guardar(Context context, Usuario usuario) {

        try {
            File a = conectar(context);
            FileOutputStream fo = new FileOutputStream(a);
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(usuario);
            fo.flush();
            fo.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

        public static Usuario leer(Context context){

            Usuario usuario =null;
            try{
                File a= conectar(context);
                FileInputStream fi=new FileInputStream(a);
                ObjectInputStream ois=new ObjectInputStream(fi);
                usuario = (Usuario) ois.readObject();
                fi.close();
            } catch (FileNotFoundException | ClassNotFoundException e) {
                e.printStackTrace();
            }catch (IOException io){
                io.printStackTrace();
            }
            return usuario;
        }

    public static Usuario login(Context context, String mail, String pass){

            Usuario u = null;
            Boolean loginOk= false;
            try{
                File a= conectar(context);
                FileInputStream fi=new FileInputStream(a);
                ObjectInputStream ois=new ObjectInputStream(fi);
                Usuario usuario = (Usuario) ois.readObject();
                fi.close();
                if(usuario.getEmail().equals(mail) && usuario.getPassword().equals(pass)){
                    u= new Usuario(usuario.getDni(), usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getPassword());
                    loginOk=true;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if(loginOk){
                return u;
            }else
            {
                return null;
            }
        }
    }

    /*
    public static Usuario leer(Context context){
        SharedPreferences sp = conectar(context);
        Long dni = sp.getLong("dni", -1);
        String apellido = sp.getString("apellido", "null");
        String nombre = sp.getString("nombre", "null");
        String email = sp.getString("email", "null");
        String password = sp.getString("password", "null");

        Usuario user = new Usuario(dni,nombre,apellido,email,password);
        return user;
    }

    public static Usuario login(Context context,String mail, String pass){
        Usuario user = null;
        SharedPreferences sp = conectar(context);
        Long dni = sp.getLong("dni", -1);
        String apellido = sp.getString("apellido", "null");
        String nombre = sp.getString("nombre", "null");
        String email = sp.getString("email", "null");
        String password = sp.getString("password", "null");

        if(email.equals(mail) && password.equals(pass)){
            user = new Usuario(dni,nombre,apellido,email,password);
        }
        return user;
    }

}
*/