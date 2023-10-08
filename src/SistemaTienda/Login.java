package SistemaTienda;

public class Login{
    private String nombre;
    private String pass;

    public Login(){}

    public Login(String n, String p){
        this.nombre = n;
        this.pass = p;
    }

    public void setN(String n){
        nombre = n;
    }

    public void setP(String p){
        pass = p;
    }

    public String getN(){
        return nombre;
    }

    public String getP(){
        return pass;
    }
}
