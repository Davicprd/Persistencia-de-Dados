package com.projeto.DAO;

import com.projeto.model.consultas_medicas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class consultas_medicasDAO extends ConexaoDB {

    private static final String INSERT_CONSULTAS_MEDICAS_SQL = "INSERT INTO consultas_medicas (assinatura, dt_consulta, id_pacientes, id_medicos) VALUES (?, ?, ?, ?);";
    private static final String SELECT_CONSULTAS_MEDICAS_BY_ID = "SELECT id, assinatura, dt_consulta, id_pacientes, id_medicos FROM consultas_medicas WHERE id = ?";
    private static final String SELECT_ALL_CONSULTAS_MEDICAS = "SELECT * FROM consultas_medicas;";
    private static final String DELETE_CONSULTAS_MEDICAS_SQL = "DELETE FROM consultas_medicas WHERE id = ?;";
    private static final String UPDATE_CONSULTAS_MEDICAS_SQL = "UPDATE consultas_medicas SET assinatura = ?, dt_consulta = ?, id_pacientes = ?, id_medicos = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM consultas_medicas;";

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

    public void insertConsultaMedica(consultas_medicas entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_CONSULTAS_MEDICAS_SQL)) {
            preparedStatement.setString(1, entidade.getAssinatura());
            preparedStatement.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(entidade.getDt_consulta()));
            preparedStatement.setInt(3, entidade.getId_pacientes());
            preparedStatement.setInt(4, entidade.getId_medicos());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public consultas_medicas selectConsultaMedica(int id) {
        consultas_medicas entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_CONSULTAS_MEDICAS_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String assinatura = rs.getString("assinatura");
                java.util.Date dt_consulta = rs.getDate("dt_consulta");
                int id_pacientes = rs.getInt("id_pacientes");
                int id_medicos = rs.getInt("id_medicos");
                entidade = new consultas_medicas(id, assinatura, dt_consulta, id_pacientes, id_medicos);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<consultas_medicas> selectAllconsultas_medicas() {
        List<consultas_medicas> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_CONSULTAS_MEDICAS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String assinatura = rs.getString("assinatura");
                java.util.Date dt_consulta = rs.getDate("dt_consulta");
                int id_pacientes = rs.getInt("id_pacientes");
                int id_medicos = rs.getInt("id_medicos");
                entidades.add(new consultas_medicas(id, assinatura, dt_consulta, id_pacientes, id_medicos));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteConsultaMedica(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_CONSULTAS_MEDICAS_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateConsultaMedica(consultas_medicas entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_CONSULTAS_MEDICAS_SQL)) {
            statement.setString(1, entidade.getAssinatura());
            statement.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(entidade.getDt_consulta()));
            statement.setInt(3, entidade.getId_pacientes());
            statement.setInt(4, entidade.getId_medicos());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
