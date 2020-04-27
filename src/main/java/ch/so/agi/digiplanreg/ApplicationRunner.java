package ch.so.agi.digiplanreg;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ch.so.agi.digiplanreg.domain.Dokument;
import ch.so.agi.digiplanreg.domain.Geschaeft;
import ch.so.agi.digiplanreg.repository.DokumentRepository;
import ch.so.agi.digiplanreg.repository.GeschaeftRepository;

@Component
public class ApplicationRunner implements CommandLineRunner {
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @Autowired
    GeschaeftRepository geschaeftRepository;
    
    @Autowired
    DokumentRepository dokumentRepository;

    @Override
    public void run(String... args) throws Exception {
        geschaeftRepository.deleteAll();
        dokumentRepository.deleteAll();

        /*
         * Unidirektional
         */
//        List<Dokument> g1_dokumente = new ArrayList<Dokument>();
//        
//        Dokument d1_1 = new Dokument();
//        d1_1.setTitel("Dokumententitel");
//        d1_1.setUrl("https://geoweb.so.ch/zonenplaene/Zonenplaene_pdf/1-Solothurn/Entscheide/1-312_313-E.pdf");
//        d1_1.setBeschreibung("fubar");
//        g1_dokumente.add(d1_1);
//
//        Geschaeft g1 = new Geschaeft();
//        g1.setNummer("123-1");
//        g1.setTitel("Ich bin der Titel");
//        g1.setBeschreibung("Laaaaange Beschreibung");
//        g1.setDokumente(g1_dokumente);
//        geschaeftRepository.save(g1);
        
        /*
         * Bidirektional Variante 1
         */

        Geschaeft g1 = new Geschaeft();
        g1.setNummer("123-1");
        g1.setTitel("Ich bin der Titel");
        g1.setBeschreibung("Laaaaange Beschreibung");

        Dokument d1_1 = new Dokument();
        d1_1.setTitel("Dokumententitel d1_1");
        d1_1.setUrl("https://geoweb.so.ch/zonenplaene/Zonenplaene_pdf/1-Solothurn/Entscheide/1-312_313-E.pdf");
        d1_1.setBeschreibung("fubar");

        Dokument d1_2 = new Dokument();
        d1_2.setTitel("Dokumententitel d1_2");
        d1_2.setUrl("https://geoweb.so.ch/zonenplaene/Zonenplaene_pdf/1-Solothurn/Entscheide/1-312_313-E.pdf");
        d1_2.setBeschreibung("fubar");

        Dokument d1_3 = new Dokument();
        d1_3.setTitel("Dokumententitel d1_3");
        d1_3.setUrl("https://geoweb.so.ch/zonenplaene/Zonenplaene_pdf/1-Solothurn/Entscheide/1-312_313-E.pdf");
        d1_3.setBeschreibung("fubar");

        g1.addDokument(d1_1);
        g1.addDokument(d1_2);
        g1.addDokument(d1_3);
        
        geschaeftRepository.save(g1);

        Dokument d1_4 = new Dokument();
        d1_4.setTitel("Dokumententitel d1_1");
        d1_4.setUrl("https://geoweb.so.ch/zonenplaene/Zonenplaene_pdf/1-Solothurn/Entscheide/1-312_313-E.pdf");
        d1_4.setBeschreibung("fubar");
        d1_4.setGeschaeft(g1);
        dokumentRepository.save(d1_4);

        

    }
}
