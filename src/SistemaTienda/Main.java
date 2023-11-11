package SistemaTienda;

public class Main{

    public Main(){}

    public static void main(String[] args) {

        //TiendaInicio x = new TiendaInicio();
        Inicio x = new Inicio();
    }

}

/*hacer una clase abstracta "Usuario" que tenga de hijos a "Cliente" (que es "Login") y a "Admin".
Luego hacer una clase intermedia "x" para realizar la conexion con la base de datos y que desde ahí
llame a las clases que leen y escriben en la base de datos

"Admin" tiene "nombre de administrador" y "contraseña" en otro registro de la BD
 */