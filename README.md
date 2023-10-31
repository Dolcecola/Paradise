# Paradise - Beyond the stars

```mermaid
classDiagram
TiendaInicio <|--CreacionCuenta
TiendaInicio <|--TiendaMain
TiendaInicio <|--Admin

TiendaMain <|--Cuenta
TiendaMain <|--Productos
TiendaMain <|--Categoria

Cuenta <|--Carrito
Cuenta <|--Pago

class TiendaInicio{
	-Usuario: JTextField
	-Password: JTextField
	-ventanaCuenta: JFrame
	-crear: JButton
	-inicioS: JButton
	-ventana: JFrame
	-imagenFondo: JLabel
	-mainPanel: JPanel
	+InitComponents()
	+crearCuenta()
}

class CreacionCuenta{
	-ventanaCuenta: JFrame
	-guardar: JButton
	-panelSesion: JPanel
	-usuario: JLabel
	-password: JLabel
	-nombre: JLabel
	-apellidos: JLabel
	-email_usuario: JLabel
	-telefono_usuario: JLabel
	-nombreUsuarioCrear: JTextField
	-password2: JTextField
	-nombrePersona: JTextField
	-apellidosUsuario: JTextField
	-email: JTextField
	-telefono: JTextField
	-fondoCuenta: JLabel

	+VentanaCreacionCuenta()
	+CrearUsuario()
}

class Admin{
	-Usuario_admin: String
	-Email: String
	+Actualizar_tienda()
}

class TiendaMain{
	-ventanaTienda: JFrame
	-mainTienda: JPanel
	-imagenC1: JLabel
	-fondoMain: JLabel
	-bannerMain: JLabel
	-imagenP2: JLabel
	-imagenP3: JLabel
	-bannerDown: JLabel

	+Tienda()
	+Productos_oferta()
	+Favoritos()
	+Buscador()
	+Top_ventas()
}

class Productos{
	+Tallas()
	+Favoritos()
	+Color()
	+Descripcion()
	+Comentarios()
	+Valoraciones()
}

class Categoria{
	+Categorias_ropa()
}

class Cuenta{
	+Perfil()
	+Ajustes()
}

class Carrito{
	-n_productos: int
	+Productos_oferta()
	+Seguir_comprando()
}

class Pago{
	-Tarjeta: int
	-Caducidad: int
	-CVV: int
	-Nombre: int
	-Direccion: string
	-Descuento: string
	+Calcular_coste()
	+Finalizar()
	+Opciones_pago()
}
```
