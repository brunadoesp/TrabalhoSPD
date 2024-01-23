package com.candidate.candidate;

import java.sql.Date;
public class Candidato {
    private int codigo;
    private String nome;
    private char sexo;
    private Date dataNasc;
    private String cargoPretendido;
    private String textoCurriculo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCargoPretendido() {
        return cargoPretendido;
    }

    public void setCargoPretendido(String cargoPretendido) {
        this.cargoPretendido = cargoPretendido;
    }

    public String getTextoCurriculo() {
        return textoCurriculo;
    }

    public void setTextoCurriculo(String textoCurriculo) {
        this.textoCurriculo = textoCurriculo;
    }
}

