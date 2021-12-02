package doadores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import doadores.entities.Doadores;

public interface DoadoresRepository extends JpaRepository<Doadores, Long>{

}
