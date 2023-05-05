package com.example.andreysshop.web;

import com.example.andreysshop.model.binding.ItemAddBindingModel;
import com.example.andreysshop.model.binding.UserLoginBindingModel;
import com.example.andreysshop.model.service.ItemAddServiceModel;
import com.example.andreysshop.service.ItemService;
import com.example.andreysshop.utl.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public ItemController(ItemService itemService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }



    @GetMapping("/add")
    public String add() {
        if(currentUser.getId() == null){
            return "redirect:/login";
        }
        return "add-item";
    }

    @ModelAttribute
    public ItemAddBindingModel itemAddBindingModel(){
        return new ItemAddBindingModel();
    }

    @PostMapping("/add")
    public String assConform(@Valid ItemAddBindingModel itemAddBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("itemAddBindingModel", itemAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.itemAddBindingModel", bindingResult);

            return "redirect:add";
        }

        itemService.addItem(modelMapper.map(itemAddBindingModel, ItemAddServiceModel.class));
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public ModelAndView getDetails(@PathVariable("id") Long id, ModelAndView modelAndView) {

        modelAndView.addObject("item", itemService.findById(id));
        modelAndView.setViewName("details-item");

        return modelAndView;
    }

    @GetMapping("/delete/{id}")
        public String delete(@PathVariable("id")Long id){
            itemService.delete(id);
            return "redirect:/";
    }

}
