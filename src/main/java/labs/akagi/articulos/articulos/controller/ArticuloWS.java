package labs.akagi.articulos.articulos.controller;

import labs.akagi.articulos.articulos.entity.Articulo;
import labs.akagi.articulos.articulos.service.ImpArticulos;
import labs.akagi.articulos.respuesta.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("articulos")
@CrossOrigin
public class ArticuloWS {
    @Autowired
    ImpArticulos imp;

    @PostMapping("guardar")
    Respuesta guardar(@RequestBody Articulo a) {
        return imp.guardar(a);
    }

    @PostMapping("editar")
    Respuesta editar(@RequestBody Articulo a) {
        return imp.editar(a);
    }

    @PostMapping("eliminar")
    Respuesta eliminar(@RequestBody Integer id) {
        return imp.eliminar(id);
    }

    @PostMapping("eliminar-clave")
    Respuesta eliminarClave(@RequestBody String k) {
        return imp.eliminarClave(k);
    }

    @GetMapping("mostrar")
    Respuesta mostrar() {
        return imp.mostrar();
    }

    @GetMapping("buscar")
    Respuesta buscar(@RequestBody Integer id) {
        return imp.buscar(id);
    }

    @GetMapping("buscar-clave")
    Respuesta buscarClave(@RequestBody String k) {
        return imp.buscarClave(k);
    }
}
