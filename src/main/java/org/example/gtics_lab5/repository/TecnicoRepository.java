package org.example.gtics_lab5.repository;

import org.example.gtics_lab5.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Technician, Integer> {
}
