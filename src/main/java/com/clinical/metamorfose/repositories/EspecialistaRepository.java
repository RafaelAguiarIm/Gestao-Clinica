package com.clinical.metamorfose.repositories;

import com.clinical.metamorfose.models.Especialista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialistaRepository extends JpaRepository<Especialista, Long> {
}
