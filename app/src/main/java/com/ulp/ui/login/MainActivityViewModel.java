package com.ulp.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ulp.model.Usuario;
import com.ulp.request.ApiClient;
import com.ulp.ui.registro.Registro;

public class MainActivityViewModel extends AndroidViewModel {


    private Context context;



    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        context = application.getApplicationContext();
    }

    public void login(String eMail, String password){


        if (eMail.isEmpty() || password.isEmpty()){
         //   mensajeMutable.setValue("Los datos de eMail y Password deben estar llenos..");
            Toast.makeText(context,"Falta Usuario y Pass", Toast.LENGTH_LONG).show();
        }else{

        Usuario usuario = ApiClient.login(context, eMail, password);

        if (usuario!= null  ){

            Intent i=new Intent(context, Registro.class);
            i.putExtra("Registro",0);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);


        }else {

            //mensajeMutable.setValue();
            Toast.makeText(context,"Usuario o Password incorrectos!", Toast.LENGTH_LONG).show();
        }

        }





    }

public void registrarse(){

    Intent i=new Intent(context, Registro.class);
    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    i.putExtra("Registro", 1);
    context.startActivity(i);


}


}
