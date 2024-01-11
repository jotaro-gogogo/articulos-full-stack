package labs.akagi.articulos.articulos.dao;

import labs.akagi.articulos.articulos.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
TODO:
    crear metodos para buscar y eliminar por clave
 */

@Repository
public interface DaoArticulo extends JpaRepository<Articulo, Integer> {
    boolean existsByClave(String clave);
    Articulo findByClave(String clave);
}
