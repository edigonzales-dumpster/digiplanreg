package ch.so.agi.digiplanreg;

import java.time.LocalDate;
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
        g1.setNummer("1");
        g1.setTitel("Anpassung Gestaltungsplan 'Familiensiedlung Brunnmatten'");
//        g1.setBeschreibung("");

        Dokument d1_1 = new Dokument();
        d1_1.setTitel("Anpassung Gestaltungsplan 'Familiensiedlung Brunnmatten' mit Sonderbauvorschriften");
        d1_1.setUrl("https://geo.so.ch/docs/ch.so.arp.zonenplaene/Zonenplaene_pdf/1-Solothurn/Entscheide/1-312_313-E.pdf");
        d1_1.setBeschreibung("fubar");
        d1_1.setArt("RRB");
        d1_1.setNummer("2019/1581");
        d1_1.setDatum(LocalDate.of(2019, 10, 19));

        Dokument d1_2 = new Dokument();
        d1_2.setTitel("Gestaltungsplan 'Familiensiedlung Brunnmatten' (angepasster Gestaltungsplan)");
        d1_2.setUrl("https://geo.so.ch/docs/ch.so.arp.zonenplaene/Zonenplaene_pdf/1-Solothurn/Plaene/1-312-P.pdf");
        d1_2.setBeschreibung("fubar");
        d1_2.setArt("Plan");

        Dokument d1_3 = new Dokument();
        d1_3.setTitel("Gestaltungsplan 'Familiensiedlung Brunnmatten' (rechtsgültiger Gestaltungsplan)");
        d1_3.setUrl("https://geo.so.ch/docs/ch.so.arp.zonenplaene/Zonenplaene_pdf/1-Solothurn/Plaene/1-313-P.pdf");
        d1_3.setBeschreibung("fubar");
        d1_3.setArt("Plan");

        g1.addDokument(d1_1);
        g1.addDokument(d1_2);
        g1.addDokument(d1_3);
        
        geschaeftRepository.save(g1);
        
        Geschaeft g2 = new Geschaeft();
        g2.setNummer("223-2");
        g2.setTitel("Ich bin auch ein Titel");
        g2.setBeschreibung("Lorem Ipsum");
        geschaeftRepository.save(g2);


        Dokument d1_4 = new Dokument();
        d1_4.setTitel("Dokumententitel d1_4");
        d1_4.setUrl("https://geoweb.so.ch/zonenplaene/Zonenplaene_pdf/1-Solothurn/Entscheide/1-312_313-E.pdf");
        d1_4.setBeschreibung("fubar");
        d1_4.setArt("SBV");
        d1_4.setGeschaeft(g2);
        dokumentRepository.save(d1_4);

        

    }
}
