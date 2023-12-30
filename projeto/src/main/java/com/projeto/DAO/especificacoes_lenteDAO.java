package com.projeto.DAO;

import com.projeto.model.especificacoes_lente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class especificacoes_lenteDAO extends ConexaoDB {

    private static final String INSERT_ESPECIFICACOES_LENTE_SQL = "INSERT INTO especificacoes_lente (valor, id_estruturas_lente, id_atributos_estrutura_lente) VALUES (?, ?, ?);";
    private static final String SELECT_ESPECIFICACOES_LENTE_BY_ID = "SELECT id, valor, id_estruturas_lente, id_atributos_estrutura_lente FROM especificacoes_lente WHERE id = ?";
    private static final String SELECT_ALL_ESPECIFICACOES_LENTE = "SELECT * FROM especificacoes_lente;";
    private static final String DELETE_ESPECIFICACOES_LENTE_SQL = "DELETE FROM especificacoes_lente WHERE id = ?;";
    private static final String UPDATE_ESPECIFICACOES_LENTE_SQL = "UPDATE especificacoes_lente SET valor = ?, id_estruturas_lente = ?, id_atributos_estrutura_lente = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM especificacoes_lente;";

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

    public void insertespecificacoes_lente(especificacoes_lente entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_ESPECIFICACOES_LENTE_SQL)) {
            preparedStatement.setFloat(1, entidade.getValor());
            preparedStatement.setInt(2, entidade.getId_estruturas_lente());
            preparedStatement.setInt(3, entidade.getId_atributos_estrutura_lente());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public especificacoes_lente selectespecificacoes_lente(int id) {
        especificacoes_lente entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ESPECIFICACOES_LENTE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                float valor = rs.getFloat("valor");
                int id_estruturas_lente = rs.getInt("id_estruturas_lente");
                int id_atributos_estrutura_lente = rs.getInt("id_atributos_estrutura_lente");
                entidade = new especificacoes_lente(id, valor, id_estruturas_lente, id_atributos_estrutura_lente);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<especificacoes_lente> selectAllespecificacoes_lente() {
        List<especificacoes_lente> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_ESPECIFICACOES_LENTE)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                float valor = rs.getFloat("valor");
                int id_estruturas_lente = rs.getInt("id_estruturas_lente");
                int id_atributos_estrutura_lente = rs.getInt("id_atributos_estrutura_lente");
                entidades.add(new especificacoes_lente(id, valor, id_estruturas_lente, id_atributos_estrutura_lente));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteespecificacoes_lente(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_ESPECIFICACOES_LENTE_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateespecificacoes_lente(especificacoes_lente entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_ESPECIFICACOES_LENTE_SQL)) {
            statement.setFloat(1, entidade.getValor());
            statement.setInt(2, entidade.getId_estruturas_lente());
            statement.setInt(3, entidade.getId_atributos_estrutura_lente());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
