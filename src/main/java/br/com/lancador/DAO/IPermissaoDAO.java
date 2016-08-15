package br.com.lancador.DAO;

import br.com.lancador.models.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by paulo on 14/07/16.
 */
@Repository
public interface IPermissaoDAO extends JpaRepository<Permissao, Long> {

    @Query("select p from Permissao p where p.usuario.id = :id")
    List<Permissao> findByUsuario(@Param("id") Long id);

    @Query("select p from Permissao p where p.usuario.id = :id and p.permite = 'S'")
    List<Permissao> findByUsuarioAndPermiteSim(@Param("id") Long id);

    @Query("select p from Permissao p where p.evento.id = :id")
    List<Permissao> findByEvento(@Param("id") Long id);

    @Query("select p from Permissao p where p.usuario.id = :idUsuario and p.evento.id = :idEvento")
    List<Permissao> findByUsuarioAndEvento(@Param("idUsuario") Long idUsuario, @Param("idEvento") Long idEvento);

}
