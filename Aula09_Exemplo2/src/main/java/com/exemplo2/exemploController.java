package com.exemplo2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Exemplo")
public class exemploController {
	@GetMapping("/hello")
	public String get (@RequestParam("nome") String nome) {
		return "Projeto Spring Criado por: " + nome;
	}
}
