package practice.kafka.subDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.kafka.subDB.model.Alert;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
}

