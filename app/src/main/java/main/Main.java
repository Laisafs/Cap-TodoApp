package main;

import controller.ProjectController;
import controller.TaskController;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.Project;
import model.Task;

/**
 *
 * @author Laisa
 */
public class Main {

    public static void main(String[] args) throws SQLException {

        /* ProjectController projectController = new ProjectController();

        Project project = new Project();
/*
        project.setName("Projeto Teste");
        project.setDescription("description");
        projectController.save(project);*/

 /* project.setId(10);
        project.setName("novo nome do projeto");
        project.setDescription("new description");
        projectController.update(project);
        
        List<Project> projects = projectController.getAll();
        System.out.println("Total de projetos: " + projects.size());
         */
        //projectController.removeById(1);
        TaskController taskController = new TaskController();
        Task task = new Task();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, 03, 30, 0, 0);

        task.setIdProjects(10);
        task.setName("nova tarefa");
        task.setDescription("description");
        task.setNotes("sem observações");
        task.setIsCompleted(false);
        task.setDeadLine(new Date(2023, 4, 30));
        task.setDeadLine(calendar.getTime());
        System.out.println(task.getDeadLine());
        taskController.save(task);

        /*task.setIdProjects(10);

        task.setName("novo nome tarefa");
        task.setDescription("dsnfkjsdjhfkj");
        task.setNotes("oi tudo bem?");
        task.setIsCompleted(false);
        calendar.set(2023, 3, 30, 0, 0, 0);
        task.setDeadLine(calendar.getTime());

        task.setId(19);
        taskController.update(task);

        List<Task> tasks = taskController.getAll(10);
        System.out.println("Total de tarefas: " + tasks.size());*/
        //taskController.removeById(19);
    }

}
