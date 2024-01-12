package labs.akagi.articulos.products.controller;

import labs.akagi.articulos.products.entity.Product;
import labs.akagi.articulos.products.service.ProductImp;
import labs.akagi.articulos.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
@CrossOrigin
public class ProductWS {
    @Autowired
    ProductImp imp;

    @PostMapping("save")
    Response pSaveWS(@RequestBody Product p) {
        return imp.pSave(p);
    }

    @PostMapping("edit")
    Response pEditWS(@RequestBody Product p) {
        return imp.pEdit(p);
    }

    @PostMapping("delete")
    Response pDeleteWS(@RequestBody Integer id) {
        return imp.pDelete(id);
    }

    @PostMapping("delete-key")
    Response pDeleteKeyWS(@RequestBody String k) {
        return imp.deleteKey(k);
    }

    @GetMapping("show")
    Response pShowWS() {
        return imp.pShow();
    }

    @GetMapping("search")
    Response pSearchWS(@RequestBody Integer id) {
        return imp.pSearch(id);
    }

    @GetMapping("search-key")
    Response pSearchKeyWS(@RequestBody String k) {
        return imp.searchKey(k);
    }
}
