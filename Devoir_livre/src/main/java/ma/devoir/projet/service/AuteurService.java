package ma.devoir.projet.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.devoir.projet.dao.IDAo;
import ma.devoir.projet.entity.Auteur;
import ma.devoir.projet.entity.Livre;
import ma.devoir.projet.repository.AuteurRepository;

@Service
public class AuteurService implements IDAo<Auteur>{
	
	@Autowired
	AuteurRepository auteurRepository;

	@Override
	public Auteur save(Auteur o) {
		return auteurRepository.save(o);
	}

	@Override
	public List<Auteur> findAll() {
		return auteurRepository.findAll();
	}

	@Override
	public Auteur findById(int id) {
		return auteurRepository.findById(id).get();
	}

	@Override
	public void update(Auteur o) {
		auteurRepository.save(o);
	}

	@Override
	public void delete(Auteur o) {
		auteurRepository.delete(o);
	}

	public List<Livre> findLivreByCin(String cin){
		Auteur auteur = auteurRepository.findByCin(cin);
		return auteur.getLivres();
		
	}
	
	public void affecter(String cin,Livre livre) {
		Auteur auteur = auteurRepository.findByCin(cin);
		auteur.getLivres().add(livre);
		auteurRepository.save(auteur);
	}

	public Auteur findByCin(String cin) {
		return auteurRepository.findByCin(cin);
	}

	public List<Auteur> findBydateNaissance(String dtNaissance) throws ParseException {
		SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dtnaissance = inputDateFormat.parse(dtNaissance);
		return auteurRepository.findByDateNaissance(dtnaissance);
	}
	
	
	
	
}
