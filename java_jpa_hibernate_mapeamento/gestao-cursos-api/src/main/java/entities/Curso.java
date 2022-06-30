package entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Curso {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome, sigla;
    @ManyToOne(optional = false, cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_professor", referencedColumnName = "id")
    private Professor professor;
    @OneToOne(optional = false, cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_material", referencedColumnName = "id")
    private MaterialCurso material;
    @ManyToMany
    @JoinTable(
            name = "Alunos_Curso",
            joinColumns =  @JoinColumn(name = "id_curso", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_aluno", referencedColumnName = "id")
    )
    private List<Aluno> aluno;


}
