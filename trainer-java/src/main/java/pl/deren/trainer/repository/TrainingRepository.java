package pl.deren.trainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.deren.trainer.model.Training;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository <Training, Long>{
    @Query("SELECT t FROM Training t LEFT JOIN t.users u")
    List<Training> findAllTrainings();
}
