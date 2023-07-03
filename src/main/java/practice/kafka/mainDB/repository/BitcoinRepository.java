package practice.kafka.mainDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.kafka.mainDB.model.Bitcoin;

@Repository
public interface BitcoinRepository extends JpaRepository<Bitcoin, Long> {

}
