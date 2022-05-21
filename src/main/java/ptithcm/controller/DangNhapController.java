package ptithcm.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

@Controller
public class DangNhapController {
    @RequestMapping("login")
    String login(){
        return "user/signin-page";
    }
    @RequestMapping("/403")
    String CanhBao(){
        return "user/page403";
    }
    @RequestMapping("/dangki")
    String  dangki(){
        return "user/signup-page";
    }

}
