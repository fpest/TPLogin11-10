package com.ulp.ui.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ulp.login.R;
import com.ulp.model.Usuario;
import com.ulp.ui.login.MainActivityViewModel;

public class Registro extends AppCompatActivity {

    private EditText etDNI, etApellido, etNombre, eteMail, etPassword;
    private Button btGuardar;
    private RegistroViewModel vm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroViewModel.class);

        vm.getusuarioMutable().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {

                etApellido.setText(usuario.getApellido() + "");
                etNombre.setText(usuario.getNombre()+"");
                etDNI.setText(usuario.getDni()+"");
                etPassword.setText(usuario.getPassword()+"");
                eteMail.setText(usuario.getEmail()+"");
            }
        });


    inicializarvista();


    }


private void inicializarvista(){
    vm.leerUsuario(getIntent());
    etApellido = findViewById(R.id.etApellido);
    etDNI = findViewById(R.id.etDNI);
    etNombre = findViewById(R.id.etNombre);
    eteMail = findViewById(R.id.etEmail);
    etPassword = findViewById(R.id.etPassword);

    btGuardar = findViewById(R.id.btGuardar);


    btGuardar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            long dni;
            if(etDNI.getText().toString().equals("")){
                dni =0;
            }
            else{ dni= Long.parseLong(etDNI.getText().toString());}
            String nombre= etNombre.getText().toString();
            String apellido= etApellido.getText().toString();
            String email= eteMail.getText().toString();
            String password= etPassword.getText().toString();
            Usuario u = new Usuario(dni,nombre,apellido,email,password);

            vm.guardarUsuario(u);


        }
    });





}


}