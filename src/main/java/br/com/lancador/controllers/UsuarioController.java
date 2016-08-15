package br.com.lancador.controllers;

import br.com.lancador.DAO.IUsuarioDAO;
import br.com.lancador.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by paulo on 14/07/16.
 */

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired private IUsuarioDAO usuarioDAO;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> findAllUsuarios(){
        return new ResponseEntity<List<Usuario>>(usuarioDAO.findAll(),HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> findUsuarioById(@PathVariable("id") Long id){
        Usuario usuario = new Usuario();
        try {
            usuario = usuarioDAO.findOne(id);
            if (usuario != null){
                return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{login}/{senha}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> findUsuarioByLoginESenha(@PathVariable("login") String login, @PathVariable("senha") String senha){
        Usuario usuario = new Usuario();
        try {
            usuario = usuarioDAO.findByLoginAndSenha(login, senha);
            if (usuario != null){
                return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> findUsuarioByLogin(@PathVariable("login") String login){
        Usuario usuario = new Usuario();
        try {
            usuario = usuarioDAO.findByLogin(login);
            if (usuario != null){
                return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario){
        try {
            if (usuario != null){
                usuarioDAO.save(usuario);
                return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUsuario(@RequestBody Long id){
        Usuario usuario = new Usuario();
        try {
            usuario = usuarioDAO.findOne(id);
            if (usuario != null){
                usuarioDAO.delete(usuario);
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
