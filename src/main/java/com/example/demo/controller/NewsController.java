package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.NewDTO;
import com.example.demo.entities.CatergoriaNews;
import com.example.demo.entities.NewsEntity;
import com.example.demo.repository.CategoriaNewsRepository;
import com.example.demo.repository.NewsRepository;

@Controller
@RequestMapping("/news")
public class NewsController {
    
    // importamos el repository 
    @Autowired
    NewsRepository nR;

    @Autowired
    CategoriaNewsRepository cr;

    //mapeo para listar todas las noticias 
    @GetMapping
    public String listar(Model model){
        List<NewsEntity> news = nR.findAll();
        model.addAttribute("lista", news); 
        return "index";
    }

    //metodo para poder añadir una noticia
    @GetMapping("/addNews")
    public String add(Model model){
        List<CatergoriaNews> categorias = cr.findAll();
        model.addAttribute("categorias", categorias);
        model.addAttribute("noticia", new NewDTO());
        return "news";
    }

    //metodo para añadir la noticia 
    @PostMapping("/add")
    public String addNew(@ModelAttribute("noticia") NewDTO noticiaDTO){
        nR.save(new NewsEntity(noticiaDTO.getTitulo(), 
                               noticiaDTO.getDesarrollo(), 
                               noticiaDTO.getResumen(), 
                               cr.findById(noticiaDTO.getCategoriaId()).get(),
                               new Date() ));
        return "redirect:/news";
    }

    //método para eliminar la noticia 
    @GetMapping("/delete/{id}")
    public String deleteNew(@PathVariable String id){
        this.nR.deleteById(Integer.parseInt(id));
        return "redirect:/news";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id ,Model model){
        NewsEntity noticia = this.nR.findById(Integer.parseInt(id)).get();
        NewDTO dto = new NewDTO( noticia.getId(),
                                 noticia.getTitulo(), 
                                 noticia.getDesarrollo(),
                                 noticia.getResumen(),
                                 cr.findById(noticia.getCategoria().getId()).get().getId());
        model.addAttribute("noticia", dto);
        model.addAttribute("categorias", cr.findAll());
        return "news";
    }

    @PostMapping("/editNew")
    public String editNew(@ModelAttribute("noticia") NewDTO noticiaDTO){
        nR.save(new NewsEntity(noticiaDTO.getId(),
                               noticiaDTO.getTitulo(), 
                               noticiaDTO.getDesarrollo(), 
                               noticiaDTO.getResumen(), 
                               cr.findById(noticiaDTO.getCategoriaId()).get(),
                               new Date() ));
        return "redirect:/news";
    }

    

}
