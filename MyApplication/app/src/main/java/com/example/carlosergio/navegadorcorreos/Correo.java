package com.example.carlosergio.navegadorcorreos;

/**
 * Created by CarloSergio on 03/05/2017.
 */

public class Correo
{
    private String de;
    private String asunto;
    private String texto;

    public Correo(String de, String asunto, String texto){
        this.de = de;
        this.asunto = asunto;
        this.texto = texto;
    }

    public String getDe(){
        return de;
    }

    public void setDe(String d){
        de = d;
    }
    public String getAsunto(){
        return asunto;
    }



    public String getTexto(){
        return texto;
    }
}
