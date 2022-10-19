package com.kartasista.kartasista.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kartasista.kartasista.entity.Autor;
import com.kartasista.kartasista.repository.AutorRepository;
@Controller
public class ControllerAutor {
	@Autowired
	AutorRepository autorRepository;
	@GetMapping("/admin/cadastrarautor")
	public ModelAndView Form(Autor autor) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/adminautor/autorForm");
		return modelAndView;
	}
	@GetMapping("/admin/autor")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/adminautor/listaautor");
		List<Autor> autor = autorRepository.findAll();     
		modelAndView.addObject("sacolaautor", autor);
		return modelAndView;
	}
	@PostMapping("/admin/createautor")
	public ModelAndView create (Autor autor, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/adminautor/autorForm");
		autorRepository.save(autor);
		redirectAttributes.addFlashAttribute("sucesso", "Autor salvo com sucesso");
		return modelAndView;
	}
	
	@GetMapping("/admin/editarautor/{id}")
	public ModelAndView editar(@PathVariable("id") Integer id, Autor autor,
			RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/adminautor/autorAtualizar");
		autor = autorRepository.getById(id);
		modelAndView.addObject("autorView", autor);
		return modelAndView;
	}
	
	@PostMapping("/admin/editarautor")
	public ModelAndView update(Autor autor, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/");

		Autor autor1 = autorRepository.getById(autor.getId());
		autor1.setNome(autor.getNome());
		//autor1.setAtivo(autor.getAtivo());
		autorRepository.save(autor);

		redirectAttributes.addFlashAttribute("mensagem", "autor apagado com sucesso");
		return modelAndView;

	}
	@GetMapping("/admin/excluirautor/{id}")
	public ModelAndView excluir(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		Autor autor = autorRepository.findById(id).get();
		autor.setAtivo(false);
		//autorRepository.delete(autor);
		redirectAttributes.addFlashAttribute("mensagem", "pessoa deletada com sucesso");
		return modelAndView;
	}
}
