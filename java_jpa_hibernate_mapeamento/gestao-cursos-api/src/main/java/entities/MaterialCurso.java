package entities;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class MaterialCurso {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;

}
