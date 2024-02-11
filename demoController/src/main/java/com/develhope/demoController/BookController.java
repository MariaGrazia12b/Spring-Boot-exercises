package com.develhope.demoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // espone l'url (api) che fai richiamare dall'esterno
@RequestMapping("/v1") // indica la root (parte iniziale) di tutte le api di questo controller
public class BookController {

    @Autowired // stai applicando l'injection ovvero è come se avessi scritto:
    DbFinto db; // DbFinto db = new DbFinto();

    //path = percorso concatenato a v1; method = il tipo di metodo che ho scelto in questo caso il get
    //il get in generale si usa per recuperare informazioni
    @RequestMapping(path = "/book/{id}", method = RequestMethod.GET)
    public String getBook(@PathVariable int id) {
        for (Libro x : db.getBooks()) {
            if (x.getId() == id) {
                return "il libro è " + x;
            }
        }
        return "Il libro non esiste";
    }

    //put = espone api che inserisce info. ha un body della request che è un posto dove inserisci le ifo
    // che devi usare.
    @PutMapping(path = "/book/{id}")
    public Libro updateBook(@PathVariable int id, @RequestBody BookRequest bookRequest) {
        Libro updated = null;
        for (Libro x : db.getBooks()) {
            if (x.getId() == id) {
                x.setAutore(bookRequest.getAutore());
                x.setTitolo(bookRequest.getTitolo());
                x.setEditore(bookRequest.getEditore());
                x.setPubblcazione(bookRequest.getPubblcazione());
                updated = x;
            }
        }
        return updated;
    }
}
