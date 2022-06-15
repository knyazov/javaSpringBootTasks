package firstproject.javaspringboot.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {

    private Long id;
    private String name;
    private String description;
    private double price;

}
