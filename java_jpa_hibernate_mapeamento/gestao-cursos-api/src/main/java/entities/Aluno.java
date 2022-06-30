package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto, matricula, email;
    private LocalDate nascimento;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_endereco", referencedColumnName = "id")
    private List<Endereco> enderecoList;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_telefone", referencedColumnName = "id")
    private List<Telefone> telefoneList;
}
