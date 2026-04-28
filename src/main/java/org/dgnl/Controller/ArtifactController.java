package org.dgnl.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.dgnl.Entity.Artifact;
import org.dgnl.Service.ArtifactService;

@Controller
public class ArtifactController {
    @Autowired
    private ArtifactService service;
    @GetMapping("/")
    public String list(Model model, @RequestParam(defaultValue = "0")int page){
        Page<Artifact> artifacts = service.getAll(PageRequest.of(page,5));
        model.addAttribute("artifacts", artifacts);
        return "list";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("artifact", new Artifact());
        return "form";
    }
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Artifact artifact, BindingResult result){
        if (result.hasErrors()){
            return "form";
        }
        service.save(artifact);
        return "redirect:/";
    }
   @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("artifact", service.findById(id));
        return "form";
   }
   @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
       return "redirect:/";
   }
}
