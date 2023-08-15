package ra.demospringmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.demospringmvc.model.Todo;
import ra.demospringmvc.service.TodoService;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/TodoController")
public class TodoController {
 @Autowired
    private TodoService todoService;
  @GetMapping()
    public ModelAndView list(){
      List<Todo> todoList=todoService.findAll();
      ModelAndView modelAndView=new ModelAndView("/todo/list","todolist",todoList);
      return modelAndView;
  }
  @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
      todoService.delete(id);
      return "redirect:/TodoController";
  }
@GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id" ) int id){
    Todo todo=todoService.findById(id);
    ModelAndView modelAndView=new ModelAndView("/todo/edit","todo",todo);
      return modelAndView;
}
@PostMapping("/edit")
    public String Update(@ModelAttribute("todo") Todo todo){
      todoService.save(todo);
    return "redirect:/TodoController";

}
@GetMapping("/add")
    public ModelAndView add(){
      Todo todo=new Todo(0,"",false);
      ModelAndView modelAndView=new ModelAndView("/todo/add","todo",todo);
      return modelAndView;
}
@PostMapping("/add")
    public String add(@ModelAttribute("todo") Todo todo ){
      todoService.save(todo);
return "redirect:/TodoController";
}
    @GetMapping("/search")
    public ModelAndView search(@RequestParam("tk") String tk) {
        List<Todo> list = todoService.findAll();
        List<Todo> list1 = new ArrayList<>();

        for (Todo t : list) {
            if (t.getContent().contains(tk)) {
                list1.add(t);
            }
        }

        ModelAndView modelAndView = new ModelAndView("todo/list","todolist",list1);

        return modelAndView;
    }

}