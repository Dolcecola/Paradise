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
	-Usuario: String
	-Password: String
	+InitComponents()
	+crearCuenta()
}

class CreacionCuenta{
	-Nombre: String
	-Apellidos: String
	-Email: String
	-Telefono: int
	+VentanaCreacionCuenta()
	+CrearUsuario()
}

class Admin{
	-Usuario_admin: String
	-Email: String
	+Actualizar_tienda()
}

class TiendaMain{
	-Buscador: String
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
