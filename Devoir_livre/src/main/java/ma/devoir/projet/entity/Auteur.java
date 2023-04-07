package ma.devoir.projet.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Auteur extends Personne {

	private String email;

	@ManyToMany
	@JoinTable(name = "livre_auteur", joinColumns = @JoinColumn(name = "auteur_id"), inverseJoinColumns = @JoinColumn(name = "livre_id"))
	List<Livre> livres;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

}
