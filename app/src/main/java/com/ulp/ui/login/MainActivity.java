package com.ulp.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ulp.login.R;
import com.ulp.model.Usuario;
import com.ulp.request.ApiClient;

public class MainActivity extends AppCompatActivity {



    private EditText etEmail, etPassword;
    private Button btLogin, btRegistrarse;
    private MainActivityViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        inicializarVista();
    }



    private void   inicializarVista(){
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btLogin = findViewById(R.id.btLogin);
        btRegistrarse = findViewById(R.id.btRegistrarse);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.login(etEmail.getText().toString(), etPassword.getText().toString());

            }
        });



        btRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.registrarse();

            }
        });






    }
}