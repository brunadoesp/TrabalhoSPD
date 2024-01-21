package modelo;

import javax.persistence.*;
import java.time.LocalDate;
import javax.persistence.EnumType;

@Entity
@Table(name = "Agendas")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate data;
    private String hora;
    @Enumerated(EnumType.STRING)
    private Situacao situacao;
    private LocalDate data_situacao;
    private String observacoes;

    @ManyToOne
    private Vacina vacina;
    @ManyToOne
    private Usuario usuario;
    public enum Situacao {
        AGENDADO,
        CANCELADO,
        REALIZADO;
    }
    public Agenda(){
        super();
    }

    public Agenda(LocalDate data, String hora, Situacao situacao, LocalDate data_situacao, String observacoes, Vacina vacina, Usuario usuario) {
        this.data = data;
        this.hora = hora;
        this.situacao = situacao;
        this.data_situacao = data_situacao;
        this.observacoes = observacoes;
        this.vacina = vacina;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public LocalDate getData_situacao() {
        return data_situacao;
    }

    public void setData_situacao(LocalDate data_situacao) {
        this.data_situacao = data_situacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
