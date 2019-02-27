package br.edu.ifrs.restinga.prog3.bruno.fontoura.Exemplo01;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControleExemplo1 {
	
	private int contID;
	private ArrayList<Pessoa> ps;
	
	public ControleExemplo1() {
		this.contID = 1;
		this.ps = new ArrayList<>();
	}
	
	@RequestMapping("/recuperaPessoa")
	@ResponseBody
	public Pessoa recuperaPessoa() {

		Pessoa p = new Pessoa();

		p.setNome("Maria");
		p.setIdade(25);
		p.setEmail("sadas");
		p.setTelefone(new String[] { "56531", "51321" });

		return p;

	}

	@RequestMapping("/inserirPessoa")
	@ResponseBody
	public String inserirPessoa(@RequestBody Pessoa p) {

		p.setId(contID++);
		
		this.ps.add(p);
		
		return "nome: " + p.getNome() + "\n" + 
				"idade: " + p.getIdade() + "\n" + 
				"email: " + p.getEmail() + "\n" + 
				"telefone: " + String.join(",",p.getTelefone());
	}

	@RequestMapping("/mostraPessoa")
	@ResponseBody
	public ArrayList<Pessoa> mostraPessoa() {

		
		return ps;
	}
	
}
