package olek.gorecki.stocksapp.justtotestcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping("userpage")
    public String userpage() {
        return "user/userpage";
    }
}
