package com.projeto.DAO;

import com.projeto.model.observacoes_laudos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class observacoes_laudosDAO extends ConexaoDB {

    private static final String INSERT_OBSERVACOES_LAUDOS_SQL = "INSERT INTO observacoes_laudos (descricao, id_receitas_oculos) VALUES (?, ?);";
    private static final String SELECT_OBSERVACOES_LAUDOS_BY_ID = "SELECT id, descricao, id_receitas_oculos FROM observacoes_laudos WHERE id = ?";
    private static final String SELECT_ALL_OBSERVACOES_LAUDOS = "SELECT * FROM observacoes_laudos;";
    private static final String DELETE_OBSERVACOES_LAUDOS_SQL = "DELETE FROM observacoes_laudos WHERE id = ?;";
    private static final String UPDATE_OBSERVACOES_LAUDOS_SQL = "UPDATE observacoes_laudos SET descricao = ?, id_receitas_oculos = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM observacoes_laudos;";

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prepararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public void insertObservacaoLaudo(observacoes_laudos entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_OBSERVACOES_LAUDOS_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setInt(2, entidade.getId_receitas_oculos());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public observacoes_laudos selectObservacaoLaudo(int id) {
        observacoes_laudos entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_OBSERVACOES_LAUDOS_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                int id_receitas_oculos = rs.getInt("id_receitas_oculos");
                entidade = new observacoes_laudos(id, descricao, id_receitas_oculos);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<observacoes_laudos> selectAllobservacoes_laudo() {
        List<observacoes_laudos> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_OBSERVACOES_LAUDOS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                int id_receitas_oculos = rs.getInt("id_receitas_oculos");
                entidades.add(new observacoes_laudos(id, descricao, id_receitas_oculos));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteObservacaoLaudo(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_OBSERVACOES_LAUDOS_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateObservacaoLaudo(observacoes_laudos entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_OBSERVACOES_LAUDOS_SQL)) {
            statement.setString(1, entidade.getDescricao());
            statement.setInt(2, entidade.getId_receitas_oculos());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
