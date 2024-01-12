package labs.akagi.articulos.products.service;

import labs.akagi.articulos.products.dao.ProductDao;
import labs.akagi.articulos.products.entity.Product;
import labs.akagi.articulos.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//TODO: Revisar la clase de Evento

@Service
public class ProductImp implements ProductMethods {
    @Autowired
    ProductDao pDao;

    @Override
    public Response pSave(Product p) {
        if (pDao.findAll().isEmpty() || !pDao.existsById(p.getId()) || !pDao.existsByProductKey(p.getProductKey())) {
            pDao.save(p);
            // Mandar "guardar" a la clase Evento
            return new Response("El artículo se registró correctamente", p, true);
        } else if (pDao.existsById(p.getId()))
            return new Response("Ya existe un artículo registrado con ese ID", null, false);
        else if (pDao.existsByProductKey(p.getProductKey()))
            return new Response("Ya existe un articulo registrado con esa clave:", pDao.findByProductKey(p.getProductKey()), false);
        else
            return new Response("No se pudo guardar el artículo, verifique la información", null, false);
    }

    @Override
    public Response pEdit(Product p) {
        if (pDao.findAll().isEmpty())
            return new Response("No hay artículos en la base de datos, pruebe de nuevo", null, false);
        else if (pDao.existsById(p.getId())) {
            pDao.save(p);
            // Llamar a clase evento
            return new Response("El artículo se editó correctamente", p, true);
        } else
            return new Response("El ID del artñiculo no existe en la base de datos, verifique la información", null, false);
    }

    @Override
    public Response pShow() {
        if (pDao.findAll().isEmpty())
            return new Response("Base de datos vacía, nada por mostrar", null, false);
        else
            return new Response("Se encontró lo siguiente en la base de datos:", pDao.findAll(), true);
    }

    @Override
    public Response pSearch(Integer id) {
        if (pDao.findAll().isEmpty())
            return new Response("La base de datos está vacía, nada para buscar", null, false);
        else if (pDao.existsById(id))
            return new Response("Se encontró lo siguiente:", pDao.findById(id), true);
        else
            return new Response("No se encontró el ID, pruebe de nuevo", null, false);
    }

    public Response searchKey(String key) {
        if (pDao.findAll().isEmpty())
            return new Response("La base de datos está vacía, nada por buscar", null, false);
        else if (pDao.existsByProductKey(key)) {
            Product a = pDao.findByProductKey(key).orElse(null);
            return new Response("Se encontró lo siguiente:", a, true);
        } else
            return new Response("No existe la clave en la base de datos", null, false);
    }

    @Override
    public Response pDelete(Integer id) {
        if (pDao.findAll().isEmpty())
            return new Response("La base de datos está vacía, nada por eliminar", null, false);
        else if(pDao.existsById(id)) {
            Product tmp = pDao.findById(id).orElse(null);
            pDao.deleteById(id);
            // Clase evento
            return new Response("El artículo se eliminó correctamente", tmp, true);
        } else
            return new Response("No se encontró el artículo, pruebe de nuevo", null, false);
    }

    public Response deleteKey(String key) {
        if (pDao.findAll().isEmpty())
            return new Response("Base de datos vacía, nada para eliminar", null, false);
        else if (pDao.existsByProductKey(key)) {
            Product tmp = pDao.findByProductKey(key).orElse(null);
            pDao.deleteByProductKey(key);
            // Clase Evento
            return new Response("Artículo eliminado correctamente", tmp, true);
        } else
            return new Response("No se encontró la clave", null, false);
    }
}
