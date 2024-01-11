package labs.akagi.articulos.articulos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "articulos")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Articulo {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "unidad")
    private String unidad;
    @Column(name = "clave")
    private String clave;
    @Column(name = "precio")
    private Double precio;
}
