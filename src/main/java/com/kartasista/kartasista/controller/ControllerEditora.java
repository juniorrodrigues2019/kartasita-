package com.kartasista.kartasista.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kartasista.kartasista.entity.Categoria;
import com.kartasista.kartasista.entity.Editora;
import com.kartasista.kartasista.repository.EditoraRepository;

public class ControllerEditora {
	@Autowired
	EditoraRepository editoraRepository;
	@GetMapping("/admin/cadastrareditora")
	public ModelAndView form(Editora editora) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/admineditora/editoraForm");
		return modelAndView;
	}
	@GetMapping("/admin/editora")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/admineditora/listaEditora");
		List<Editora> editora = editoraRepository.findAll();
		modelAndView.addObject("sacolaeditora", editora);
		return modelAndView;
	}
	
	@PostMapping("/admin/editoracreate")
	public ModelAndView create(Editora editora, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/admineditora/editoraAtualizar");
		editoraRepository.save(editora);
		redirectAttributes.addFlashAttribute("sucesso", "editora salva com sucesso");
		return modelAndView;
	}
	
	@GetMapping("/admin/editoraeditar/{id}")
	public ModelAndView editar(@PathVariable("id") Integer id, Editora editora,
			RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/admincategoria/editoraAtualizar");
		editora = editoraRepository.getById(id);
		modelAndView.addObject("editoraView", editora);
		return modelAndView;
	}
	
	@PostMapping("/admin/editareditora")
	public ModelAndView update(Editora editora, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/");

		Editora editora1 = editoraRepository.getById(editora.getId());
		editora1.setDescricao(editora.getDescricao());
		editoraRepository.save(editora);

		redirectAttributes.addFlashAttribute("mensagem", "Pessoa apagada com sucesso");
		return modelAndView;
	}
	
	
	@GetMapping("/admin/excluireditora/{id}")
	public ModelAndView excluir(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		Editora editora = editoraRepository.findById(id).get();
		editora.setAtivo(false);
		//editoraRepository.delete(editora);
		redirectAttributes.addFlashAttribute("mensagem", "pessoa deletada com sucesso");
		return modelAndView;
	}
	
}
