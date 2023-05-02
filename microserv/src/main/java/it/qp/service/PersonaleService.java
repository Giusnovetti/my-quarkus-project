package it.qp.service;

import it.qp.entity.Personale;
import it.qp.record.PersonaleRecord;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class PersonaleService {

    public List<PersonaleRecord> getAll() {

        List<Personale> listaPersonale = Personale.findAll().list();

        return listaPersonale.stream().map(p -> {
            return new PersonaleRecord(p.id, p.nome, p.cognome, p.cf);
        }).collect(Collectors.toList());
    }

    public String add(Personale p) {

        p.persist();

        return "aggiunto con successo";
    }
}
