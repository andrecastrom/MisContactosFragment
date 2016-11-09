package com.andrecastrom.miscontactosfragment.pojo;

/**
 * Created by 47369176d on 24/10/2016.
 */

public class Contacto {

    private String id;
    private String nombreCompleto;
    private String urlFoto;
    private int likes;

    public Contacto() {
    }

    public Contacto(String nombreCompleto, String urlFoto, String email, int likes) {
        this.nombreCompleto = nombreCompleto;
        this.urlFoto = urlFoto;
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }


}
