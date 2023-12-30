package com.projeto.DAO;

import com.projeto.model.especialidades_medicas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class especialidades_medicasDAO extends ConexaoDB {

    private static final String INSERT_ESPECIALIDADES_MEDICAS_SQL = "INSERT INTO especialidades_medicas (observacao, dt_conclusao, id_especialidade, id_medico) VALUES (?, ?, ?, ?);";
    private static final String SELECT_ESPECIALIDADES_MEDICAS_BY_ID = "SELECT id, observacao, dt_conclusao, id_especialidade, id_medico FROM especialidades_medicas WHERE id = ?";
    private static final String SELECT_ALL_ESPECIALIDADES_MEDICAS = "SELECT * FROM especialidades_medicas;";
    private static final String DELETE_ESPECIALIDADES_MEDICAS_SQL = "DELETE FROM especialidades_medicas WHERE id = ?;";
    private static final String UPDATE_ESPECIALIDADES_MEDICAS_SQL = "UPDATE especialidades_medicas SET observacao = ?, dt_conclusao = ?, id_especialidade = ?, id_medico = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM especialidades_medicas;";

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

    public void insertEspecialidadeMedica(especialidades_medicas entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_ESPECIALIDADES_MEDICAS_SQL)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(entidade.getDt_conclusao()));
            preparedStatement.setInt(3, entidade.getId_especialidade());
            preparedStatement.setInt(4, entidade.getId_medico());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public especialidades_medicas selectEspecialidadeMedica(int id) {
        especialidades_medicas entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ESPECIALIDADES_MEDICAS_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                java.util.Date dt_conclusao = rs.getDate("dt_conclusao");
                int id_especialidade = rs.getInt("id_especialidade");
                int id_medico = rs.getInt("id_medico");
                entidade = new especialidades_medicas(id, observacao, dt_conclusao, id_especialidade, id_medico);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<especialidades_medicas> selectAllespecialidades_medicas() {
        List<especialidades_medicas> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_ESPECIALIDADES_MEDICAS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                java.util.Date dt_conclusao = rs.getDate("dt_conclusao");
                int id_especialidade = rs.getInt("id_especialidade");
                int id_medico = rs.getInt("id_medico");
                entidades.add(new especialidades_medicas(id, observacao, dt_conclusao, id_especialidade, id_medico));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteEspecialidadeMedica(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_ESPECIALIDADES_MEDICAS_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateEspecialidadeMedica(especialidades_medicas entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_ESPECIALIDADES_MEDICAS_SQL)) {
            statement.setString(1, entidade.getObservacao());
            statement.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(entidade.getDt_conclusao()));
            statement.setInt(3, entidade.getId_especialidade());
            statement.setInt(4, entidade.getId_medico());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

