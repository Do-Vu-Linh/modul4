package com.cg.spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/home")
public class ExerciseController {
public static Map<String,String> list;
static {
    list = new HashMap<String,String>();
    list.put("one","một");
    list.put("two","hai");
    list.put("three","ba");
    list.put("four","bốn");
    list.put("five","năm");

}

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("dictionary");
    }

    @PostMapping("/bai1")
    public String bai1(@RequestParam("money") Double money,
                       @RequestParam("from") Double from,
                       @RequestParam("to") Double to,
                       Model model) {
        model.addAttribute("result", money * to / from);
        return "bai1";
    }
    @PostMapping("/bai2")
    public ModelAndView bai2 (@RequestParam("word") String word){
String result = list.get(word);
    ModelAndView model = new ModelAndView("/dictionary");
    model.addObject("word",result);
return  model;
    }
}
