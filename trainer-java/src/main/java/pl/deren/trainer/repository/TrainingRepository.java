package pl.deren.trainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.deren.trainer.model.Training;

@Repository
public interface TrainingRepository extends JpaRepository <Training, Long>{
}
