package com.ulp.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Usuario implements Serializable {
    private long dni;
    private String nombre;
    private String apellido;
    private String email;
    private String password;

    public Usuario(long dni, String nombre, String apellido, String email, String password) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NonNull
    @Override
    public String toString() {
        return "Usuario{"+
                " Dni: " + dni + "" +
                " ,Nombre: "+ nombre +"" +
                " ,Apellido: "+ apellido +"" +
                " ,Email: "+ email +"" +
                " ,Contraseña: "+ password +
                "}";
    }
}
