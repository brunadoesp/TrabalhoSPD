package com.candidate.candidate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidatoDAO {
    private Connection connection;

    public CandidatoDAO() {
        connection = ConexaoDB.getConnection();
    }

    public void criarTabela() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS candidato ("
                    + "codigo INT PRIMARY KEY AUTO_INCREMENT, "
                    + "nome VARCHAR(60), "
                    + "sexo CHAR(1), "
                    + "data_nasc DATE, "
                    + "cargo_pretendido VARCHAR(25), "
                    + "texto_curriculo VARCHAR(800))";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adicionarCandidato(Candidato candidato) {
        try {
            criarTabela();
            String sql = "INSERT INTO candidato (nome, sexo, data_nasc, cargo_pretendido, texto_curriculo) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, candidato.getNome());
            statement.setString(2, String.valueOf(candidato.getSexo()));
            statement.setDate(3, candidato.getDataNasc());
            statement.setString(4, candidato.getCargoPretendido());
            statement.setString(5, candidato.getTextoCurriculo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Candidato> listarCandidatos() {
        List<Candidato> candidatos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM candidato";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Candidato candidato = new Candidato();
                candidato.setCodigo(resultSet.getInt("codigo"));
                candidato.setNome(resultSet.getString("nome"));
                candidato.setSexo(resultSet.getString("sexo").charAt(0));
                candidato.setDataNasc(resultSet.getDate("data_nasc"));
                candidato.setCargoPretendido(resultSet.getString("cargo_pretendido"));
                candidato.setTextoCurriculo(resultSet.getString("texto_curriculo"));
                candidatos.add(candidato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidatos;
    }

    public void atualizarCandidato(Candidato candidato) {
        try {
            String sql = "UPDATE candidato SET nome=?, sexo=?, data_nasc=?, cargo_pretendido=?, texto_curriculo=? WHERE codigo=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, candidato.getNome());
                statement.setString(2, String.valueOf(candidato.getSexo()));
                statement.setDate(3, candidato.getDataNasc());
                statement.setString(4, candidato.getCargoPretendido());
                statement.setString(5, candidato.getTextoCurriculo());
                statement.setInt(6, candidato.getCodigo());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirCandidato(int codigo) {
        try {
            String sql = "DELETE FROM candidato WHERE codigo=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, codigo);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Candidato getCandidato(int codigo) {
        Candidato candidato = null;
        try {
            String sql = "SELECT * FROM candidato WHERE codigo=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, codigo);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        candidato = new Candidato();
                        candidato.setCodigo(resultSet.getInt("codigo"));
                        candidato.setNome(resultSet.getString("nome"));
                        candidato.setSexo(resultSet.getString("sexo").charAt(0));
                        candidato.setDataNasc(resultSet.getDate("data_nasc"));
                        candidato.setCargoPretendido(resultSet.getString("cargo_pretendido"));
                        candidato.setTextoCurriculo(resultSet.getString("texto_curriculo"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidato;
    }


}