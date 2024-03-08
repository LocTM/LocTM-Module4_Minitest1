package com.codegym.controller;

import com.codegym.model.Task;
import com.codegym.model.Category;
import com.codegym.service.ITaskService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/categorys")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ITaskService taskService;

    @GetMapping
    public ModelAndView listCategory() {
        ModelAndView modelAndView = new ModelAndView("/category/list");
        Iterable<Category> category = categoryService.findAll();
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("category") Category category,
                         RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Create new category successfully");
        return "redirect:/categorys";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/category/update");
            modelAndView.addObject("category", category.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("province") Category category,
                         RedirectAttributes redirect) {
        categoryService.save(category);
        redirect.addFlashAttribute("message", "Update category successfully");
        return "redirect:/categorys";
    }

    @GetMapping("/view-province/{id}")
    public ModelAndView viewCategory(@PathVariable("id") Long id){
        Optional<Category> categoryOptional = categoryService.findById(id);
        if(!categoryOptional.isPresent()){
            return new ModelAndView("/error_404");
        }

        Iterable<Task> tasks = taskService.findAllByCategory(categoryOptional.get());

        ModelAndView modelAndView = new ModelAndView("/task/list");
        modelAndView.addObject("tasks", tasks);
        return modelAndView;
    }
}