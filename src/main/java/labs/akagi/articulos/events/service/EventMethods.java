package labs.akagi.articulos.events.service;

import labs.akagi.articulos.response.Response;

public interface EventMethods {
    // Not so basic CRUD, as I dont think the events table should be modified by end user.
    Response guardar(String evento);

    Response editar(Integer id);

    Response mostrar();

    Response buscar(Integer id);

    Response eliminar(Integer id);
}
