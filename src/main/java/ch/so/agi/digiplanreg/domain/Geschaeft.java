package ch.so.agi.digiplanreg.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "geschaeft")
public class Geschaeft {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @NotNull    
    private String nummer;
    
    @NotNull    
    private String titel;
    
    @NotNull
    private int gemeinde; // TODO: bag of..
    
    private String beschreibung;
    
    @OneToMany(mappedBy = "geschaeft", cascade = CascadeType.PERSIST, orphanRemoval = false)
//    @JoinColumn(name = "geschaeft_id") 
    private List<Dokument> dokumente = new ArrayList<Dokument>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getGemeinde() {
        return gemeinde;
    }

    public void setGemeinde(int gemeinde) {
        this.gemeinde = gemeinde;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public List<Dokument> getDokumente() {
        return dokumente;
    }

//    public void setDokumente(List<Dokument> dokumente) {
//        this.dokumente = dokumente;
//        for (Dokument dokument : dokumente) {
//            dokument.setGeschaeft(this);
//        }
//    }
    
    public void addDokument(Dokument dokument) {
        dokumente.add(dokument);
        dokument.setGeschaeft(this);
    }
    
    public void removeDokument(Dokument dokument) {
        dokumente.remove(dokument);
        dokument.setGeschaeft(null);
    }
}
