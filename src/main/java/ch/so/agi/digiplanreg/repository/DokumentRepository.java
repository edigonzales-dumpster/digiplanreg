package ch.so.agi.digiplanreg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.so.agi.digiplanreg.domain.Dokument;

public interface DokumentRepository extends JpaRepository<Dokument, Long> {

}
