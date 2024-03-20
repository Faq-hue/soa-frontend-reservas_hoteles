public class Usuario {
    private String username;
    private String nombre;
    private String apellido;
    private String pwd;

    // Constructor
    public Usuario(String username, String nombre, String apellido, String pwd) {
        this.username = username;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pwd = pwd;
    }

    // Métodos getter y setter para cada campo
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
