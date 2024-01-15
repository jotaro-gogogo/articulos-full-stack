package labs.akagi.articulos.products.service;

import labs.akagi.articulos.products.dao.ProductDao;
import labs.akagi.articulos.products.entity.Product;
import labs.akagi.articulos.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

//TODO: Revisar la clase de Evento

@Service
public class ProductImp implements ProductMethods {
    @Autowired
    ProductDao pDao;

    List<String> units = Arrays.asList("PIEZA", "KILOGRAMO", "PULGADA", "LITRO");

    @Override
    public Response pSave(Product p) {
        if (validate(p)) {
            if (pDao.findAll().isEmpty() || !pDao.existsById(p.getId()) || !pDao.existsByProductKey(p.getProductKey())) {
                pDao.save(p);
                // Mandar "guardar" a la clase Evento
                return new Response("Product was saved correctly", p, true);
            } else if (pDao.existsById(p.getId()))
                return new Response("Product ID was already registered in the database, please verify your information.", null, false);
            else if (pDao.existsByProductKey(p.getProductKey()))
                return new Response("Cannot save, this product key already exists on the database:", pDao.findByProductKey(p.getProductKey()), false);
            else
                return new Response("Cannot save product, please verify your information.", null, false);
        } else
            return new Response("Product data does not conforms to requirements, please verify your information.", null, false);
    }

    @Override
    public Response pUpdate(Product p) {
        if (validate(p)) {
            if (pDao.findAll().isEmpty())
                return new Response("Database empty, cannot update anything", null, false);
            else if (pDao.existsById(p.getId())) {
                pDao.save(p);
                // Llamar a clase evento
                return new Response("Product was correctly updated", p, true);
            } else
                return new Response("Product ID could not be found on database, please verify your information.", null, false);
        } else
            return new Response("Product data does not conforms to requirements, please verify your information.", null, false);
    }

    @Override
    public Response pShow() {
        if (pDao.findAll().isEmpty())
            return new Response("Database empty, nothing to show.", null, false);
        else
            return new Response("Found in database:", pDao.findAll(), true);
    }

    @Override
    public Response pSearch(Integer id) {
        if (pDao.findAll().isEmpty())
            return new Response("Database empty, nothing to search for.", null, false);
        else if (pDao.existsById(id))
            return new Response("Found next coincidence:", pDao.findById(id), true);
        else
            return new Response("ID not found in database, please verify your information.", null, false);
    }

    public Response searchKey(String key) {
        if (pDao.findAll().isEmpty())
            return new Response("Database empty, nothing to search for.", null, false);
        else if (pDao.existsByProductKey(key)) {
            Product a = pDao.findByProductKey(key).orElse(null);
            return new Response("Found next coincidence:", a, true);
        } else
            return new Response("Product key not found on database, verify your information", null, false);
    }

    @Override
    public Response pDelete(Integer id) {
        if (pDao.findAll().isEmpty())
            return new Response("Database empty, nothing to delete", null, false);
        else if (pDao.existsById(id)) {
            Product tmp = pDao.findById(id).orElse(null);
            pDao.deleteById(id);
            // Clase evento
            return new Response("Product correctly deleted.", tmp, true);
        } else
            return new Response("Product cannot be found, please verify your information.", null, false);
    }

    public Response deleteKey(String key) {
        if (pDao.findAll().isEmpty())
            return new Response("Database empty, npthing to delete.", null, false);
        else if (pDao.existsByProductKey(key)) {
            Product tmp = pDao.findByProductKey(key).orElse(null);
            pDao.deleteByProductKey(key);
            // Clase Evento
            return new Response("Product correctly deleted.", tmp, true);
        } else
            return new Response("Cannot found product key, please verify your information.", null, false);
    }

    private Boolean validate(Product p) {
        if (p.getName().length() <= 30)
            if (units.contains(p.getUnit()))
                return p.getProductKey().length() >= 3 && p.getProductKey().length() <= 30;
        return false;
    }
}
