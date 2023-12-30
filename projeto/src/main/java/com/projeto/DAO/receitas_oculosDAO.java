package com.projeto.DAO;

import com.projeto.model.receitas_oculos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class receitas_oculosDAO extends ConexaoDB {

    private static final String INSERT_RECEITAS_OCULOS_SQL = "INSERT INTO receitas_oculos (detalhamento, dt_consulta, id_consulta_medica) VALUES (?, ?, ?);";
    private static final String SELECT_RECEITAS_OCULOS_BY_ID = "SELECT id, detalhamento, dt_consulta, id_consulta_medica FROM receitas_oculos WHERE id = ?";
    private static final String SELECT_ALL_RECEITAS_OCULOS = "SELECT * FROM receitas_oculos;";
    private static final String DELETE_RECEITAS_OCULOS_SQL = "DELETE FROM receitas_oculos WHERE id = ?;";
    private static final String UPDATE_RECEITAS_OCULOS_SQL = "UPDATE receitas_oculos SET detalhamento = ?, dt_consulta = ?, id_consulta_medica = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM receitas_oculos;";

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

    public void insertReceitaOculos(receitas_oculos entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_RECEITAS_OCULOS_SQL)) {
            preparedStatement.setString(1, entidade.getDetalhamento());
            preparedStatement.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(entidade.getDt_consulta()));
            preparedStatement.setInt(3, entidade.getId_consulta_medica());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public receitas_oculos selectReceitaOculos(int id) {
        receitas_oculos entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_RECEITAS_OCULOS_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String detalhamento = rs.getString("detalhamento");
                java.util.Date dt_consulta = rs.getDate("dt_consulta");
                int id_consulta_medica = rs.getInt("id_consulta_medica");
                entidade = new receitas_oculos(id, detalhamento, dt_consulta, id_consulta_medica);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<receitas_oculos> selectAllreceitas_oculos() {
        List<receitas_oculos> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_RECEITAS_OCULOS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String detalhamento = rs.getString("detalhamento");
                java.util.Date dt_consulta = rs.getDate("dt_consulta");
                int id_consulta_medica = rs.getInt("id_consulta_medica");
                entidades.add(new receitas_oculos(id, detalhamento, dt_consulta, id_consulta_medica));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteReceitaOculos(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_RECEITAS_OCULOS_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateReceitaOculos(receitas_oculos entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_RECEITAS_OCULOS_SQL)) {
            statement.setString(1, entidade.getDetalhamento());
            statement.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(entidade.getDt_consulta()));
            statement.setInt(3, entidade.getId_consulta_medica());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
