package labs.akagi.articulos.respuesta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Respuesta {
    private String msg;
    private Object obj;
    private Boolean success;
}
