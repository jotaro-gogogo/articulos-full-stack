package labs.akagi.articulos.articulos.service;

import labs.akagi.articulos.articulos.entity.Articulo;
import labs.akagi.articulos.respuesta.Respuesta;

public interface MetodosArticulo {
    // CRUD básico
    Respuesta guardar(Articulo a);

    Respuesta editar(Articulo a);

    Respuesta mostrar();

    Respuesta buscar(Integer id);

    Respuesta eliminar(Integer id);
}
