package com.projeto.DAO;

import com.projeto.model.especialidades;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class especialidadesDAO extends ConexaoDB {

    private static final String INSERT_ESPECIALIDADES_SQL = "INSERT INTO especialidades (descricao, conselho) VALUES (?, ?);";
    private static final String SELECT_ESPECIALIDADES_BY_ID = "SELECT id, descricao, conselho FROM especialidades WHERE id = ?";
    private static final String SELECT_ALL_ESPECIALIDADES = "SELECT * FROM especialidades;";
    private static final String DELETE_ESPECIALIDADES_SQL = "DELETE FROM especialidades WHERE id = ?;";
    private static final String UPDATE_ESPECIALIDADES_SQL = "UPDATE especialidades SET descricao = ?, conselho = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM especialidades;";

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

    public void insertEspecialidade(especialidades entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_ESPECIALIDADES_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setString(2, entidade.getConselho());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public especialidades selectEspecialidade(int id) {
        especialidades entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ESPECIALIDADES_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                String conselho = rs.getString("conselho");
                entidade = new especialidades(id, descricao, conselho);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<especialidades> selectAllEspecialidades() {
        List<especialidades> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_ESPECIALIDADES)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                String conselho = rs.getString("conselho");
                entidades.add(new especialidades(id, descricao, conselho));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteEspecialidade(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_ESPECIALIDADES_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateEspecialidade(especialidades entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_ESPECIALIDADES_SQL)) {
            statement.setString(1, entidade.getDescricao());
            statement.setString(2, entidade.getConselho());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
