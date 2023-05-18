package controller;

/*
 *
 * @author Laisa
 */
import java.util.List;
import model.Task;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ConnectionFactory;

public class TaskController {

    public void save(Task task) throws SQLException {
        System.out.println("caiu aqui");
        String sql = "INSERT INTO tasks (idProjects, name, description, completed,"
                + "notes,"
                + "deadLine,"
                + "createdAt,"
                + "updatedAt)VALUES(?,?,?,?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProjects());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadLine().getTime()));
          
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            System.out.println(statement);
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar a tarefa"
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);

        }
    }

    public void update(Task task)throws SQLException{
System.out.println("caiu aqui2");
        String sql = "UPDATE tasks SET "
                + "idProjects = ?, name = ? ,description = ?, completed = ?, notes =?,"
                + "deadLine = ?, createdAt = ?, updatedAt =? WHERE Id = ? ";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //Estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            
            //Preparando a query
            statement = connection.prepareCall(sql);
            
            //Setando os valores no statement
            statement.setInt(1, task.getIdProjects());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadLine().getTime()));
            
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            System.out.println(statement);
            //Executando a query
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar a tarefa"
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void removeById(int taskId)  {
        String sql = "DELETE FROM tasks WHERE id=? ";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //Criação da conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            
            //Preparando query
            statement = connection.prepareStatement(sql);
            
            //Setando os valores  no statement
            statement.setInt(1, taskId);
            
            //Executando a query
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar a tarefa"
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public List<Task> getAll(int idProjects)throws SQLException {

        String sql = "SELECT * FROM tasks WHERE idProjects =?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        // Lista de tarefas que será devolvida quando a chamada do método acontecer
        List<Task> tasks = new ArrayList<Task>();

        try {
            // Criando conexão com banco de dados
            connection = ConnectionFactory.getConnection();
            // Preparando a query
            statement = connection.prepareStatement(sql);
            //Setando o valor que corresponde ao filtro de busca
            statement.setInt(1, idProjects);
            //Valor retornado pela execuçõ da query
            resultSet = statement.executeQuery();
            
            //Enquanto os houver valores a serem percorridos no meu resultSet

            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProjects(resultSet.getInt("idProjects"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadLine(resultSet.getDate("deadLine"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                tasks.add(task);

            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao incluir a tarefa"
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        //Lista de tarefas que foi criada e carregada do banco de dados
        return tasks;

    }}

