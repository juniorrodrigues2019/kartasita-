package com.kartasista.kartasista.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kartasista.kartasista.entity.Categoria;
import com.kartasista.kartasista.repository.CategoriaRepository;

@Controller
public class ControllerCategoria {
	@Autowired
	CategoriaRepository categoriaRepository;

	@GetMapping("/admin/cadastrarcategoria")
	public ModelAndView form(Categoria categoria) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/admincategoria/categoriaForm");
		return modelAndView;
	}

	
	@GetMapping("/admin/categoria")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/admincategoria/listaCategoria");
		List<Categoria> categoria = categoriaRepository.findAll();
		modelAndView.addObject("sacolacategoria", categoria);
		return modelAndView;
	}

	
	@PostMapping("/admin/categoriacreate")
	public ModelAndView create(Categoria categoria, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/admincategoria/categoriaAtualizar");
		categoriaRepository.save(categoria);
		redirectAttributes.addFlashAttribute("sucesso", "Pessoa salva com sucesso");
		return modelAndView;
	}

	

	@GetMapping("/admin/categoriaeditar/{id}")
	public ModelAndView editar(@PathVariable("id") Integer id, Categoria categoria,
			RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/admincategoria/categoriaAtualizar");
		categoria = categoriaRepository.getById(id);
		modelAndView.addObject("categoriaView", categoria);
		return modelAndView;
	}

	@PostMapping("/admin/editarcategoria")
	public ModelAndView update(Categoria categoria, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/");

		Categoria categoria1 = categoriaRepository.getById(categoria.getId());
		categoria1.setDescricao(categoria.getDescricao());
		//categoria1.setAtivo(categoria.getAtivo());
		categoriaRepository.save(categoria);

		redirectAttributes.addFlashAttribute("mensagem", "Pessoa apagada com sucesso");
		return modelAndView;
	}

	@GetMapping("/admin/excluircategoria/{id}")
	public ModelAndView excluir(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		Categoria categoria = categoriaRepository.findById(id).get();
		categoria.setAtivo(false);
		//categoriaRepository.delete(categoria);
		redirectAttributes.addFlashAttribute("mensagem", "pessoa deletada com sucesso");
		return modelAndView;
	}

}
