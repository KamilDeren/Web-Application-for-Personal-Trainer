package pl.deren.trainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.deren.trainer.DTO.TrainingDTO;
import pl.deren.trainer.model.Training;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository <Training, Long>{

    @Query("SELECT new pl.deren.trainer.DTO.TrainingDTO(t.id, t.title, t.level, t.date, t.room, concat(u.name, ' ' , u.surname), t.created_at) FROM Training t LEFT JOIN t.users u ON t.run_by = u.id")
    List<TrainingDTO> findAllTrainings();

    @Query("SELECT new pl.deren.trainer.DTO.TrainingDTO(t.id, t.title, t.level, t.date, t.room, concat(u.name, ' ' , u.surname), t.created_at) FROM Training t LEFT JOIN t.users u ON t.run_by = u.id WHERE t.id = :idTraining")
    TrainingDTO findSingleTraining(@Param("idTraining") long idTraining);

    @Query("SELECT DISTINCT new pl.deren.trainer.DTO.TrainingDTO(u.name, u.surname, ud.phoneNumber, ud.sex, c.cityName) " +
            "FROM Training t " +
            "LEFT JOIN t.users u " +
            "LEFT JOIN u.userDetail ud " +
            "LEFT JOIN ud.city c " +
            "WHERE t.id = :idTraining")
    List<TrainingDTO> findSingleTrainingWithUsers(@Param("idTraining") long idTraining);


}
