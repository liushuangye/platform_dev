package com.platform.dev.controller.user;

import com.platform.dev.entity.user.User;
import com.platform.dev.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/index")
    public ModelAndView userIndex(User user) {
        user.setName("default");
        ModelAndView mv=new ModelAndView();
        mv.setViewName("userIndex");
        mv.addObject("user", user);
        return mv;
    }

    @ResponseBody
    @GetMapping(value = "/find/{name}")
    public String findUserByName(@PathVariable(value = "name") String name) {
        User user = userService.findUserByName(name);
        return user.getName();
    }

    @PostMapping(value = "/add")
    public String addUser(@RequestParam Map<String, Object> userMap) {
        User user = new User();
        user.setName((String) userMap.get("name"));
        user.setPassword((String) userMap.get("password"));
        userService.addUser(user);
        return "add user success";
    }
    @PutMapping(value="/update")
    public String alterUser(@RequestParam Map<String, Object> userMap) {
        User user = new User();
        user.setName((String) userMap.get("name"));
        user.setPassword((String) userMap.get("password"));
        userService.alterUser(user);
        return "success";
    }
    @DeleteMapping(value = "/delete")
    public String removeUserByName(@RequestParam Map<String, Object> userMap) {
        String name = (String) userMap.get("name");
        userService.removeUserByName(name);
        return "success";
    }
}
