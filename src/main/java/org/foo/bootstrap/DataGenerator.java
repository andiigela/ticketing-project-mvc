package org.foo.bootstrap;
import org.foo.dto.ProjectDTO;
import org.foo.dto.RoleDTO;
import org.foo.dto.TaskDTO;
import org.foo.dto.UserDTO;
import org.foo.enums.Gender;
import org.foo.enums.Status;
import org.foo.service.ProjectService;
import org.foo.service.RoleService;
import org.foo.service.TaskService;
import org.foo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    RoleService roleService;
    UserService userService;
    ProjectService projectService;
    TaskService taskService;
    @Autowired
    public DataGenerator(RoleService roleService, UserService userService,
                         ProjectService projectService, TaskService taskService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) throws Exception {
        RoleDTO adminRole = new RoleDTO(1L,"Admin");
        RoleDTO managerRole = new RoleDTO(2L,"Manager");
        RoleDTO employeeRole = new RoleDTO(3L,"Employee");

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);
        UserDTO user1 = new UserDTO("John", "Kesy", "john@cydeo.com", "Abc1",
                true, "7459684532", managerRole, Gender.MALE);

        UserDTO user5 = new UserDTO("Mike", "Smith","mike@cydeo.com", "Abc2",
                true, "7459684532",adminRole, Gender.MALE);

        UserDTO user2 = new UserDTO("Delisa", "Norre", "delisa@cydeo.com", "123",
                true, "8567412358",managerRole, Gender.FEMALE);

        UserDTO user3 = new UserDTO("Craig", "Jark","craig@cydeo.com", "Abc3",
                true, "7777775566",employeeRole, Gender.MALE);

        UserDTO user4 = new UserDTO("Shaun", "Hayns","shaun@cydeo.com", "Abc4",
                true, "3256987412",managerRole, Gender.MALE);

        UserDTO user6 = new UserDTO( "Elizabeth", "Loren", "elizebeth@cydeo.com", "AbC4",
                true, "5306987412", employeeRole, Gender.FEMALE);

        UserDTO user7 = new UserDTO("Maria", "Ada","maria@cydeo.com", "Abc4",
                true, "9996987412",employeeRole, Gender.FEMALE);

        UserDTO user8 = new UserDTO("Bill", "Matt","bill@cydeo.com", "Abc4",
                true, "8881239846",employeeRole, Gender.MALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);

        ProjectDTO project1 = new ProjectDTO("Spring MVC", "PR001", user1, LocalDate.now(), LocalDate.now().plusDays(25), "Creating Spring MVC Project", Status.OPEN);
        ProjectDTO project2 = new ProjectDTO("Spring ORM", "PR002", user2, LocalDate.now(), LocalDate.now().plusDays(10), "Creating Spring ORM Project", Status.IN_PROGRESS);
        ProjectDTO project3 = new ProjectDTO("Spring Container", "PR003", user1, LocalDate.now(), LocalDate.now().plusDays(32), "Creating Spring Container Project", Status.COMPLETE);

        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);


        TaskDTO task1 = new TaskDTO(1L, project1, user1, "Advanced Programming", "This is more high tech",Status.IN_PROGRESS, LocalDate.now().plusDays(15));
        TaskDTO task2 = new TaskDTO(2L, project2, user2, "Event Driven Programming", "Advanced High level Tech",Status.OPEN, LocalDate.now().plusDays(31));
        TaskDTO task3 = new TaskDTO(3L, project3, user3, "Game Programming", "Beginners Technology",Status.COMPLETE, LocalDate.now().plusDays(20));

        taskService.save(task1);
        taskService.save(task2);
        taskService.save(task3);
    }
}
