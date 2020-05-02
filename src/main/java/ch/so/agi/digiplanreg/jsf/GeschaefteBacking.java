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

import ch.so.agi.digiplanreg.domain.Geschaeft;
import ch.so.agi.digiplanreg.repository.GeschaeftRepository;

@Named
@ViewScoped
public class GeschaefteBacking implements Serializable {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private List<Geschaeft> geschaefte;

    private Geschaeft geschaeft = new Geschaeft();

    @Autowired
    GeschaeftRepository geschaeftRepository;
    
    @PostConstruct
    public void init() {
        this.geschaefte = geschaeftRepository.findAll();
    }

    public void delete(Geschaeft geschaeft) {
        geschaeftRepository.delete(geschaeft);
        geschaefte.remove(geschaeft);
    }

    public void add() {
        geschaeftRepository.save(geschaeft);
        this.geschaefte = geschaeftRepository.findAll();
        this.geschaeft = new Geschaeft();
    }

    public void update() {
        geschaeftRepository.saveAll(geschaefte);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update successful"));
    }

    public List<Geschaeft> getGeschaefte() {
        return geschaefte;
    }

    public void setGeschaefte(List<Geschaeft> geschaefte) {
        this.geschaefte = geschaefte;
    }

    public Geschaeft getGeschaeft() {
        return geschaeft;
    }

    public void setGeschaeft(Geschaeft geschaeft) {
        this.geschaeft = geschaeft;
    }
}
