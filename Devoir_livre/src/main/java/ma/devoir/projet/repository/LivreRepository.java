package ma.devoir.projet.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ma.devoir.projet.entity.Livre;

public interface LivreRepository extends JpaRepository<Livre, Integer> {

	Livre findByIsbn(String isbn);

	List<Livre> findByDateEditionBetween(Date to, Date from);

}
