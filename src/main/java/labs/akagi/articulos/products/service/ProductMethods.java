package labs.akagi.articulos.products.service;

import labs.akagi.articulos.products.entity.Product;
import labs.akagi.articulos.response.Response;

public interface ProductMethods {
    // Basic CRUD
    Response pSave(Product p);

    Response pUpdate(Product p);

    Response pShow();

    Response pSearch(Integer id);

    Response pDelete(Integer id);
}
