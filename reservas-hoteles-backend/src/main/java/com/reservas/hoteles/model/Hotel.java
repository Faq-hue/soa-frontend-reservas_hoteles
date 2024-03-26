package com.reservas.hoteles.model;

public class Hotel {
    private String nombre;
    private String ubicacion;
    private int habitaciones;
    private float precio;
    private String img;

    public Hotel(String nombre, String ubicacion, int habitaciones, float precio, String img){
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.habitaciones = habitaciones;
        this.precio = precio;
        this.img = img;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getHabitaciones() {
        return this.habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
