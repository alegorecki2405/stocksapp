package olek.gorecki.stocksapp.justtotestcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
    @GetMapping("adminpage")
    public String adminpage() {
        return "admin/adminpage";
    }
}
