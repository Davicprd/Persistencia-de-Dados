package com.projeto.DAO;

import com.projeto.model.estruturas_lentes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class estruturas_lentesDAO extends ConexaoDB {

    private static final String INSERT_ESTRUTURA_LENTES_SQL = "INSERT INTO estrutura_lentes (tipo_correcao, distancia_pupilar, id_receitas_oculos) VALUES (?, ?, ?);";
    private static final String SELECT_ESTRUTURA_LENTES_BY_ID = "SELECT id, tipo_correcao, distancia_pupilar, id_receitas_oculos FROM estrutura_lentes WHERE id = ?";
    private static final String SELECT_ALL_ESTRUTURA_LENTES = "SELECT * FROM estrutura_lentes;";
    private static final String DELETE_ESTRUTURA_LENTES_SQL = "DELETE FROM estrutura_lentes WHERE id = ?;";
    private static final String UPDATE_ESTRUTURA_LENTES_SQL = "UPDATE estrutura_lentes SET tipo_correcao = ?, distancia_pupilar = ?, id_receitas_oculos = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM estrutura_lentes;";

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

    public void insertestruturas_lentes(estruturas_lentes entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_ESTRUTURA_LENTES_SQL)) {
            preparedStatement.setString(1, entidade.getTipo_correcao());
            preparedStatement.setInt(2, entidade.getDistancia_pupilar());
            preparedStatement.setInt(3, entidade.getId_receitas_oculos());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public estruturas_lentes selectestruturas_lentes(int id) {
        estruturas_lentes entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ESTRUTURA_LENTES_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String tipo_correcao = rs.getString("tipo_correcao");
                int distancia_pupilar = rs.getInt("distancia_pupilar");
                int id_receitas_oculos = rs.getInt("id_receitas_oculos");
                entidade = new estruturas_lentes(id, tipo_correcao, distancia_pupilar, id_receitas_oculos);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<estruturas_lentes> selectAllestruturas_lentes() {
        List<estruturas_lentes> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_ESTRUTURA_LENTES)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String tipo_correcao = rs.getString("tipo_correcao");
                int distancia_pupilar = rs.getInt("distancia_pupilar");
                int id_receitas_oculos = rs.getInt("id_receitas_oculos");
                entidades.add(new estruturas_lentes(id, tipo_correcao, distancia_pupilar, id_receitas_oculos));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteestruturas_lentes(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_ESTRUTURA_LENTES_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateestruturas_lentes(estruturas_lentes entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_ESTRUTURA_LENTES_SQL)) {
            statement.setString(1, entidade.getTipo_correcao());
            statement.setInt(2, entidade.getDistancia_pupilar());
            statement.setInt(3, entidade.getId_receitas_oculos());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
