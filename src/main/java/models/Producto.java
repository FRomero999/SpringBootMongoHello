package models;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("productos")
@Data
public class Producto implements Serializable{

        @Id
        private String id;

        private String nombre;
        private int cantidad;
        private String categoria;
        
        @DBRef
        private Categoria cat;       
        
}
