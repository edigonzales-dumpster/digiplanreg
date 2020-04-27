package ch.so.agi.digiplanreg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Dokument {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
//    @Column(name = "geschaeft_id")
//    private Long geschaeftId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Geschaeft geschaeft;

    @NotNull
    private String titel;

    private String beschreibung;
    
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Geschaeft getGeschaeft() {
        return geschaeft;
    }

    public void setGeschaeft(Geschaeft geschaeft) {
        this.geschaeft = geschaeft;
    }
}
