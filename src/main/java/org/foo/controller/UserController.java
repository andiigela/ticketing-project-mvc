package org.foo.controller;
import org.foo.dto.UserDTO;
import org.foo.service.RoleService;
import org.foo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    RoleService roleService;
    UserService userService;
    @Autowired
    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }
    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());
        return "/user/create";
    }
    @PostMapping("/create")
    public String saveUser(Model model, @ModelAttribute("user") UserDTO userDTO) {
        userService.save(userDTO);
        return "redirect:/user/create";
    }
    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model){

        model.addAttribute("user", userService.findById(username));
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());
        return "/user/update";
    }
    @PostMapping("/update")
    public String updateUser(UserDTO userDTO){ // no need for ModelAttribute in this java version
        userService.update(userDTO);
        return "redirect:/user/create";
    }
    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username){
        userService.deleteById(username);
        return "redirect:/user/create";
    }



}
