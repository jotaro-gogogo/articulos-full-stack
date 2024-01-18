package labs.akagi.articulos.products.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "unit")
    private String unit;
    @Column(name = "product_key")
    private String productKey;
    @Column(name = "price")
    private Double price;
}
