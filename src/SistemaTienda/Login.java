package SistemaTienda;

public class Login {
    String nombre;
    String pass;
    String usuario;
    String apellidos;
    String email;
    int telefono = 0;

    public Login() {
    }

    public Login(String n, String p, String u, String a, String e, int t) {
        this.nombre = n;
        this.pass = p;
        this.usuario = u;
        this.apellidos = a;
        this.email = e;
        this.telefono = t;
    }

    public void setUsuario(String u) {
        usuario = u;
    }

    public void setApellidos(String a) {
        apellidos = a;
    }

    public void setEmail(String e) {
        email = e;
    }

    public void setTelefono(int t) {
        telefono = t;
    }

    String getUsuario() {
        return usuario;
    }

    String getApellidos() {
        return apellidos;
    }

    String getEmail() {
        return email;
    }

    int getTelefono() {
        return telefono;
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public void setPass(String p) {
        pass = p;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPass() {
        return pass;
    }
}
