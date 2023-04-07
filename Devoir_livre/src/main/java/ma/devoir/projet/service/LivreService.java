package ma.devoir.projet.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.devoir.projet.dao.IDAo;
import ma.devoir.projet.entity.Livre;
import ma.devoir.projet.repository.LivreRepository;

@Service
public class LivreService implements IDAo<Livre>{
	
	@Autowired
	LivreRepository livreRepository;

	@Override
	public Livre save(Livre o) {
		return livreRepository.save(o);
	}

	@Override
	public List<Livre> findAll() {
		return livreRepository.findAll();
	}

	@Override
	public Livre findById(int id) {
		return livreRepository.findById(id).get();
	}

	@Override
	public void update(Livre o) {
		livreRepository.save(o);
	}

	@Override
	public void delete(Livre o) {
		livreRepository.delete(o);
	}

	public List<Livre> findBydateEditionDateBetween(String to, String from) throws ParseException {
		
		SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dtto = inputDateFormat.parse(to);
		Date dtfrom = inputDateFormat.parse(from);
		return livreRepository.findByDateEditionBetween(dtto, dtfrom);
	}

	public Livre findByIsbn(String isbn) {
		return livreRepository.findByIsbn(isbn);
	}
	
}
