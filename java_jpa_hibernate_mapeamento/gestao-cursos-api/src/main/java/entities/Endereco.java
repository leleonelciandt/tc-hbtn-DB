package entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Endereco {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro, endereco, numero, bairro, cidade, estado;
    private Integer cep;

}
