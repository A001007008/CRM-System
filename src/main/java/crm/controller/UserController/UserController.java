package crm.controller.UserController;


import crm.pojo.User.User;
import crm.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    @RequestMapping("/login")
    public  String LoginController(String username, String password, Model model, HttpSession session){

        User user = userService.findByUsername(username);
        session.setAttribute("username",user.getUsername());
        if (user!=null&&user.getPassword().equals(password)){
            return "redirect:/customer/findByPage";
        }
        else {
            model.addAttribute("message","用户名密码错误啦");
            return "index";
        }
    }
}
