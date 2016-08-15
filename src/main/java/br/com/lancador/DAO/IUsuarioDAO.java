package br.com.lancador.DAO;

import br.com.lancador.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by paulo on 14/07/16.
 */
@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {

    @Query("select u from Usuario u where lower(u.login) = lower(:login) and lower(u.senha) = lower(:senha)")
    Usuario findByLoginAndSenha(@Param("login") String login, @Param("senha") String senha);

    @Query("select u from Usuario u where lower(u.login) = lower(:login)")
    Usuario findByLogin(@Param("login") String login);

}
