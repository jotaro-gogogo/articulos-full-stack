package labs.akagi.articulos.articulos.dao;

import labs.akagi.articulos.articulos.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DaoArticulo extends JpaRepository<Articulo, Integer> {
    boolean existsByClave(String clave);
    Optional<Articulo> findByClave(String clave);
    void deleteByClave(String clave);
}
