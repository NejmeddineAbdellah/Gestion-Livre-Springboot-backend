package ma.devoir.projet.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ma.devoir.projet.entity.Auteur;

public interface AuteurRepository extends JpaRepository<Auteur, Integer>{

	Auteur findByCin(String cin);
	
	List<Auteur> findByDateNaissance(Date dtNaissance);
	
}