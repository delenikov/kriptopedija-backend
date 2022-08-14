package com.kriptopedija.Repository;

import com.kriptopedija.Models.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<Test, Id> {
    Optional<Test> findByCourse_Id(Long id);
}
