package ma.devoir.projet.rest;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.devoir.projet.entity.Auteur;
import ma.devoir.projet.entity.Livre;
import ma.devoir.projet.service.AuteurService;

@RestController
@RequestMapping("api/auteurs")
public class AuteurController {

	@Autowired
	AuteurService auteurService;

	@PostMapping("/save")
	public Auteur save(@RequestBody Auteur o) {
		return auteurService.save(o);
	}

	@GetMapping("/all")
	public List<Auteur> findAll() {
		return auteurService.findAll();
	}

	@GetMapping("/id/{id}")
	public Auteur findById(@PathVariable int id) {
		return auteurService.findById(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody Auteur o) {
		auteurService.update(o);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody Auteur o) {
		auteurService.delete(o);
	}

	@GetMapping("/auteur/cin/{cin}")
	public Auteur findByCin(@PathVariable String cin) {
		return auteurService.findByCin(cin);
	}

	@GetMapping("/livres/cin/{cin}")
	public List<Livre> findLivreByCin(@PathVariable String cin) {
		return auteurService.findLivreByCin(cin);
	}

	@PutMapping("/auteur/{cin}")
	public void affecter(@PathVariable String cin,@RequestBody Livre livre) {
		auteurService.affecter(cin, livre);
	}


	@GetMapping("/date/{dtNaissance}")
	public List<Auteur> findBydateNaissance(@PathVariable String dtNaissance) throws ParseException {
		return auteurService.findBydateNaissance(dtNaissance);
	}
	
	
	
	
	
	
	
	
}
