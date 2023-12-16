package com.aula09;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Usar apenas para alterar o caminho do recurso;
@RequestMapping("aula09")
public class hello {
	@GetMapping("/ola")
	public String ola() {
		return "Olá Mundo";
	}
}
