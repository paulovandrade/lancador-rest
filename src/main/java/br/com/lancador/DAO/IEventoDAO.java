package br.com.lancador.DAO;

import br.com.lancador.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by paulo on 14/07/16.
 */
@Repository
public interface IEventoDAO extends JpaRepository<Evento, Long> {

}
