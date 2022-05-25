package ptithcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ptithcm.dao.NguoiDungDao;
import ptithcm.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DangNhapController {
    @Autowired
    JavaMailSender mailSender;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @RequestMapping("login")
    String login(){
        return "user/signin-page";
    }
    @RequestMapping("/403")
    String CanhBao(){
        return "user/page403";
    }
    @RequestMapping("/dangki")
    String  dangki() {
        return "user/signup-page";
    }
        @RequestMapping(value="/forgotpass",method=RequestMethod.GET)
        public String forgot(ModelMap model){
            return "user/forgotpass";
    }
    @RequestMapping(value="/forgotpass",method= RequestMethod.POST)
    @ResponseBody
    public Integer forgot(HttpServletRequest req){
        String email = req.getParameter("email");
        UserService  userService =new UserService();
        String link = req.getRequestURL().toString().replace(req.getServletPath(), "")+ "/reset_password?token=";
        return userService.SaveToken_SendMail(email,mailSender,link);
    }
    @RequestMapping(value="/reset_password",method= RequestMethod.GET)
    public String  resetPass(){
        return "user/resetpass";
    }
    @RequestMapping(value="/reset_password",method= RequestMethod.POST)
    @ResponseBody
    public Integer resetPass(HttpServletRequest req){
        String pass= req.getParameter("pass");
        String token = req.getParameter("token");
        UserService userService =new UserService();
        return userService.resetPass(token,pass,passwordEncoder);
    }
}

