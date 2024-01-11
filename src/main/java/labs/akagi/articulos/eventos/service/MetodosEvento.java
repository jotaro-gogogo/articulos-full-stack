package labs.akagi.articulos.eventos.service;

import labs.akagi.articulos.respuesta.Respuesta;

public interface MetodosEvento {
    // CRUD básico
    Respuesta guardar(String evento);

    Respuesta editar(Integer id);

    Respuesta mostrar();

    Respuesta buscar(Integer id);

    Respuesta eliminar(Integer id);
}
