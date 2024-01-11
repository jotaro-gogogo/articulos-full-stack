package labs.akagi.articulos.articulos.service;

import labs.akagi.articulos.articulos.dao.DaoArticulo;
import labs.akagi.articulos.articulos.entity.Articulo;
import labs.akagi.articulos.respuesta.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//TODO: Revisar la clase de Evento

@Service
public class ImpArticulos implements MetodosArticulo {
    @Autowired
    DaoArticulo daoA;

    @Override
    public Respuesta guardar(Articulo a) {
        if (daoA.findAll().isEmpty() || !daoA.existsById(a.getId()) || !daoA.existsByClave(a.getClave())) {
            daoA.save(a);
            // Mandar "guardar" a la clase Evento
            return new Respuesta("El artículo se registró correctamente", a, true);
        } else if (daoA.existsById(a.getId()))
            return new Respuesta("Ya existe un artículo registrado con ese ID", null, false);
        else if (daoA.existsByClave(a.getClave()))
            return new Respuesta("Ya existe un articulo registrado con esa clave:", daoA.findByClave(a.getClave()), false);
        else
            return new Respuesta("No se pudo guardar el artículo, verifique la información", null, false);
    }

    @Override
    public Respuesta editar(Articulo a) {
        if (daoA.findAll().isEmpty())
            return new Respuesta("No hay artículos en la base de datos, pruebe de nuevo", null, false);
        else if (daoA.existsById(a.getId())) {
            daoA.save(a);
            // Llamar a clase evento
            return new Respuesta("El artículo se editó correctamente", a, true);
        } else
            return new Respuesta("El ID del artñiculo no existe en la base de datos, verifique la información", null, false);
    }

    @Override
    public Respuesta mostrar() {
        if (daoA.findAll().isEmpty())
            return new Respuesta("Base de datos vacía, nada por mostrar", null, false);
        else
            return new Respuesta("Se encontró lo siguiente en la base de datos:", daoA.findAll(), true);
    }

    @Override
    public Respuesta buscar(Integer id) {
        if (daoA.findAll().isEmpty())
            return new Respuesta("La base de datos está vacía, nada para buscar", null, false);
        else if (daoA.existsById(id))
            return new Respuesta("Se encontró lo siguiente:", daoA.findById(id), true);
        else
            return new Respuesta("No se encontró el ID, pruebe de nuevo", null, false);
    }

    public Respuesta buscarClave(String clave) {
        if (daoA.findAll().isEmpty())
            return new Respuesta("La base de datos está vacía, nada por buscar", null, false);
        else if (daoA.existsByClave(clave)) {
            Articulo a = daoA.findByClave(clave).orElse(null);
            return new Respuesta("Se encontró lo siguiente:", a, true);
        } else
            return new Respuesta("No existe la clave en la base de datos", null, false);
    }

    @Override
    public Respuesta eliminar(Integer id) {
        if (daoA.findAll().isEmpty())
            return new Respuesta("La base de datos está vacía, nada por eliminar", null, false);
        else if(daoA.existsById(id)) {
            Articulo tmp = daoA.findById(id).orElse(null);
            daoA.deleteById(id);
            // Clase evento
            return new Respuesta("El artículo se eliminó correctamente", tmp, true);
        } else
            return new Respuesta("No se encontró el artículo, pruebe de nuevo", null, false);
    }

    public Respuesta eliminarClave(String clave) {
        if (daoA.findAll().isEmpty())
            return new Respuesta("Base de datos vacía, nada para eliminar", null, false);
        else if (daoA.existsByClave(clave)) {
            Articulo tmp = daoA.findByClave(clave).orElse(null);
            daoA.deleteByClave(clave);
            // Clase Evento
            return new Respuesta("Artículo eliminado correctamente", tmp, true);
        } else
            return new Respuesta("No se encontró la clave", null, false);
    }
}
