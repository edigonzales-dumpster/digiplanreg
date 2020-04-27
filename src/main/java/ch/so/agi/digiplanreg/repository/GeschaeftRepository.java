package ch.so.agi.digiplanreg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.so.agi.digiplanreg.domain.Geschaeft;

@Repository
public interface GeschaeftRepository extends JpaRepository<Geschaeft, Long> {

}
