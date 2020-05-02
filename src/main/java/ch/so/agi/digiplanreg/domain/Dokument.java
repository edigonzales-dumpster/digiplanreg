package ch.so.agi.digiplanreg.domain;

import java.time.LocalDate;

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
    
    private String nummer;
    
    private LocalDate datum;
    
    private String art; // TODO enum.

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

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Geschaeft getGeschaeft() {
        return geschaeft;
    }

    public void setGeschaeft(Geschaeft geschaeft) {
        this.geschaeft = geschaeft;
    }
    
    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Geschaeft )) return false;
        return id != null && id.equals(((Geschaeft) o).getId());
    }
 
    @Override
    public int hashCode() {
        return 31;
    }
}
