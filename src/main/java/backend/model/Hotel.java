package backend.model;

public class Hotel {
    private String nombre;
    private String ciudad;
    private int habitaciones;
    private float precio;
    private String img;

    public Hotel(String nombre, String ciudad, int habitaciones, float precio, String img){
        this.nombre = nombre;
        this.ciudad = ciudad;
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

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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
