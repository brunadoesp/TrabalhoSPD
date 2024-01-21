package modelo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private LocalDate data_nascimento;

    private char sexo;
    private String logradouro;
    private int numero;
    private String setor;
    private String cidade;
    private String uf;

    @OneToMany(mappedBy = "usuario")
    private Set<UsuarioAlergia> usuarioAlergias = new HashSet<>();

    public Usuario(String nomeDoUsuário, LocalDate localDate, char f, String ruaTeste, int i, String setorTeste, String cidadeTeste, String uf, List<Alergia> alergias) {
    }

    public Usuario(String nome, LocalDate data_nascimento, char sexo, String logradouro, int numero, String setor, String cidade, String uf) {
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.setor = setor;
        this.cidade = cidade;
        this.uf = uf;
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

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Set<UsuarioAlergia> getUsuarioAlergias() {
        return usuarioAlergias;
    }

    public void setUsuarioAlergias(Set<UsuarioAlergia> usuarioAlergias) {
        this.usuarioAlergias = usuarioAlergias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id &&
                Objects.equals(nome, usuario.nome) &&
                Objects.equals(data_nascimento, usuario.data_nascimento) &&
                Objects.equals(sexo,  usuario.sexo )&&
                Objects.equals(logradouro, usuario.logradouro) &&
                Objects.equals(setor, usuario.setor) &&
                Objects.equals(cidade, usuario.cidade) &&
                Objects.equals(uf, usuario.uf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, data_nascimento, sexo, logradouro, setor, cidade, uf);
    }
}
