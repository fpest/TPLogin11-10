package com.ulp.ui.registro;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ulp.model.Usuario;
import com.ulp.request.ApiClient;

import java.util.List;

public class RegistroViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<Usuario> usuarioMutable;

    public RegistroViewModel(@NonNull Application application) {
        super(application);

        context = application.getApplicationContext();
    }

    public LiveData<Usuario> getusuarioMutable() {
        if (usuarioMutable == null) {
            usuarioMutable = new MutableLiveData<>();
        }
        return usuarioMutable;
    }

    public void leerUsuario(Intent i) {

        if (i.getIntExtra("Registro", -1) == 0) {
            Usuario usuario = ApiClient.leer(context);

            if (usuario.getApellido() != "null") {


                usuarioMutable.setValue(usuario);

            }
        }


    }


    public void guardarUsuario(Usuario u) {

        if (!camposVacios(u)) {
            ApiClient.guardar(context, u);
            Toast.makeText(context, "Datos Guardados Correctamente", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "Todos los campos deben estar completos", Toast.LENGTH_LONG).show();

        }
    }

    public boolean camposVacios(Usuario usuario) {


        if (usuario.getEmail().isEmpty() ||
                usuario.getNombre().isEmpty() ||
                usuario.getApellido().isEmpty() ||
                usuario.getDni()==0 ||
                usuario.getEmail().isEmpty()) {
            return true;
        } else {


            return false;
        }
    }

}