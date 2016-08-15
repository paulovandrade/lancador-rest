package br.com.lancador.controllers;

import br.com.lancador.DAO.IPermissaoDAO;
import br.com.lancador.models.Permissao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulo on 14/07/16.
 */

@RestController
@RequestMapping(value = "/permissao")
public class PermissaoController {

    @Autowired private IPermissaoDAO permissaoDAO;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Permissao>> findAllPermissoes(){
        return new ResponseEntity<List<Permissao>>(permissaoDAO.findAll(),HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Permissao> findPermissaoById(@PathVariable("id") Long id){
        Permissao permissao = new Permissao();
        try {
            permissao = permissaoDAO.findOne(id);
            if (permissao != null){
                return new ResponseEntity<Permissao>(permissao, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Permissao>> findPermissoesByUsuario(@PathVariable("id") Long id){
        List<Permissao> permissoes = new ArrayList<>();
        try {
            permissoes = permissaoDAO.findByUsuario(id);
            if (permissoes != null && permissoes.size() > 0){
                return new ResponseEntity<List<Permissao>>(permissoes, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/usuariopermite/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Permissao>> findPermissoesByUsuarioAndPermiteSim(@PathVariable("id") Long id){
        List<Permissao> permissoes = new ArrayList<>();
        try {
            permissoes = permissaoDAO.findByUsuarioAndPermiteSim(id);
            if (permissoes != null && permissoes.size() > 0){
                return new ResponseEntity<List<Permissao>>(permissoes, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/evento/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Permissao>> findPermissoesByEvento(@PathVariable("id") Long id){
        List<Permissao> permissoes = new ArrayList<>();
        try {
            permissoes = permissaoDAO.findByEvento(id);
            if (permissoes != null && permissoes.size() > 0){
                return new ResponseEntity<List<Permissao>>(permissoes, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/usuarioevento/{idu}/{ide}", method = RequestMethod.GET)
    public ResponseEntity<List<Permissao>> findPermissoesByUsuarioAndEvento(@PathVariable("idu") Long idusuario, @PathVariable("ide") Long idevento){
        List<Permissao> permissoes = new ArrayList<>();
        try {
            permissoes = permissaoDAO.findByUsuarioAndEvento(idusuario, idevento);
            if (permissoes != null && permissoes.size() > 0){
                return new ResponseEntity<List<Permissao>>(permissoes, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Permissao> savePermissao(@RequestBody Permissao permissao){
        try {
            if (permissao != null){
                permissaoDAO.save(permissao);
                return new ResponseEntity<Permissao>(permissao, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePermissao(@RequestBody Long id){
        Permissao permissao = new Permissao();
        try {
            permissao = permissaoDAO.findOne(id);
            if (permissao != null){
                permissaoDAO.delete(permissao);
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
