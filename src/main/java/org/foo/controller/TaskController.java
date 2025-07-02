package org.foo.controller;

import org.foo.dto.ProjectDTO;
import org.foo.dto.TaskDTO;
import org.foo.service.ProjectService;
import org.foo.service.TaskService;
import org.foo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {
    TaskService taskService;
    ProjectService projectService;
    UserService userService;
    public TaskController(TaskService taskService,
                          ProjectService projectService,
                          UserService userService) {
        this.taskService=taskService;
        this.projectService=projectService;
        this.userService=userService;
    }

    @GetMapping("/create")
    public String createTask(Model model){
        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("tasks", taskService.findAll());
        return "/task/create";
    }
    @PostMapping("/create")
    public String saveTask(TaskDTO taskDTO){
        taskService.save(taskDTO);
        return "redirect:/task/create";
    }
    @GetMapping("/delete/{taskId}")
    public String deleteTask(@PathVariable("taskId") Long taskId){
        taskService.deleteById(taskId);
        return "redirect:/task/create";
    }
    @GetMapping("/update/{taskId}")
    public String editProject(@PathVariable("taskId") Long taskId, Model model){
        model.addAttribute("task", taskService.findById(taskId));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("tasks", taskService.findAll());
        return "/task/update";
    }
    @PostMapping("/update")
    public String updateProject(TaskDTO taskDTO){
        taskService.update(taskDTO);
        return "redirect:/task/create";
    }


}
