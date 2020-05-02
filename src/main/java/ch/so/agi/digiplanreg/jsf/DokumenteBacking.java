package ch.so.agi.digiplanreg.jsf;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ch.so.agi.digiplanreg.domain.Dokument;
import ch.so.agi.digiplanreg.repository.DokumentRepository;

@Named
@ViewScoped
public class DokumenteBacking implements Serializable {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private List<Dokument> dokumente;

    private Dokument dokument = new Dokument();

    @Autowired
    DokumentRepository dokumentRepository;
    
    @PostConstruct
    public void init() {
        this.dokumente = dokumentRepository.findAll();
        log.info("*******" + this.dokumente.size());
    }


    public void delete(Dokument dokument) {
        dokumentRepository.delete(dokument);
        dokumente.remove(dokument);
    }

    public void add() {
        dokumentRepository.save(dokument);
        this.dokumente = dokumentRepository.findAll();
        this.dokument = new Dokument();
    }

    public void update() {
        dokumentRepository.saveAll(dokumente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update successful"));
    }

    public List<Dokument> getDokumente() {
        return dokumente;
    }

    public void setDokumente(List<Dokument> dokumente) {
        this.dokumente = dokumente;
    }

    public Dokument getDokument() {
        return dokument;
    }

    public void setDokument(Dokument dokument) {
        this.dokument = dokument;
    }

}
