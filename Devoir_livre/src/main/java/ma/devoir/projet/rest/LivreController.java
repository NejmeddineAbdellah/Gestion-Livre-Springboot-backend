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

import ma.devoir.projet.entity.Livre;
import ma.devoir.projet.service.LivreService;

@RestController
@RequestMapping("api/livres")
public class LivreController {
	
	@Autowired
	LivreService livreService;

	@PostMapping("/save")
	public Livre save(@RequestBody Livre o) {
		return livreService.save(o);
	}

	@GetMapping("/all")
	public List<Livre> findAll() {
		return livreService.findAll();
	}

	@GetMapping("/id/{id}")
	public Livre findById(@PathVariable int id) {
		return livreService.findById(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody Livre o) {
		livreService.update(o);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody Livre o) {
		livreService.delete(o);
	}

	@GetMapping("/livre/date/{to}/{from}")
	public List<Livre> findBydateEditionDateBetween(@PathVariable String to,@PathVariable String from) throws ParseException {
		return livreService.findBydateEditionDateBetween(to, from);
	}

	@GetMapping("/livre/isbn/{isbn}")
	public Livre findByIsbn(@PathVariable String isbn) {
		return livreService.findByIsbn(isbn);
	}

	
	
}
