package labs.akagi.articulos.events.service;

import labs.akagi.articulos.response.Response;

public interface MetodosEvento {
    // CRUD básico
    Response guardar(String evento);

    Response editar(Integer id);

    Response mostrar();

    Response buscar(Integer id);

    Response eliminar(Integer id);
}
