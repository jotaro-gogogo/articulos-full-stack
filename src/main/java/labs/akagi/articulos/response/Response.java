package labs.akagi.articulos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Response {
    private String msg;
    private Object obj;
    private Boolean success;
}
