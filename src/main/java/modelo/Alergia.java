package modelo;

import javax.persistence.*;

@Entity
@Table(name = "Alergias")
public class Alergia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    public Alergia( String nome) {
        this.nome = nome;
    }

    public Alergia() {
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

