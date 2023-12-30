package  com.projeto.util;

import  com.projeto.DAO.especialidadesDAO;
import  com.projeto.model.especialidades;

import java.sql.SQLException;
import java.util.List;

public class Teste {
    static especialidadesDAO especialidadesDAO = new especialidadesDAO();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println("Contador de Especialidades: " + especialidadesDAO.count());

        //Delete
        especialidadesDAO.deleteEspecialidade(31);

        //salvar
        especialidades especialidade = new especialidades(1,"Radiologista","CRTR");
        especialidadesDAO.insertEspecialidade(especialidade);

        //Select all
        List<especialidades> especialidades = especialidadesDAO.selectAllEspecialidades();
        System.out.println("Lista de todas as Especialidades: ");
        especialidades.forEach(System.out::println);

        //Update
        especialidade = especialidadesDAO.selectEspecialidade(45);
        System.out.println("Registro a ser alterado: " + especialidade.getConselho());
        especialidade.setConselho("CBD");
        especialidadesDAO.updateEspecialidade(especialidade);
        especialidade = especialidadesDAO.selectEspecialidade(45);
        System.out.println("Registro alterado com sucesso: " + especialidade.getConselho());

    }
}
