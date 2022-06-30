package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.beans.ConstructorProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Endereco {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro, endereco, numero, bairro, cidade, estado;
    private Integer cep;

    @ManyToOne
    private Aluno aluno;

}
