package br.com.lancador.controllers;

import br.com.lancador.DAO.IEventoDAO;
import br.com.lancador.models.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by paulo on 14/07/16.
 */

@RestController
@RequestMapping(value = "/evento")
public class EventoController {

    @Autowired private IEventoDAO eventoDAO;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Evento>> findAllEventos(){
        return new ResponseEntity<List<Evento>>(eventoDAO.findAll(),HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Evento> findEventoById(@PathVariable("id") Long id){
        Evento evento = new Evento();
        try {
            evento = eventoDAO.findOne(id);
            if (evento != null){
                return new ResponseEntity<Evento>(evento, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Evento> saveEvento(@RequestBody Evento evento){
        try {
            if (evento != null){
                eventoDAO.save(evento);
                return new ResponseEntity<Evento>(evento, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteEvento(@RequestBody Long id){
        Evento evento = new Evento();
        try {
            evento = eventoDAO.findOne(id);
            if (evento != null){
                eventoDAO.delete(evento);
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
