package ra.demospringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//localhost:8081/greeting
@Controller
@RequestMapping({"/","/home"})
public class HomeController {
@GetMapping("")
    public String home(Model model){
    String name="chào mùn tới todolist";
    model.addAttribute("name", name);
    return "home";
}
@GetMapping("/haihai")
    public String haiok(Model model){
    String name="hai đẳngr cấp";
    model.addAttribute("name",name);
    return "greeting";
}

}
