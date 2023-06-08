package pl.deren.trainer.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.deren.trainer.DTO.TrainingDTO;
import pl.deren.trainer.model.Training;
import pl.deren.trainer.model.User;
import pl.deren.trainer.repository.TrainingRepository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrainingService {

    private final TrainingRepository trainingRepository;

    public List<TrainingDTO> getTrainings(){
        return trainingRepository.findAllTrainings();
    }

    public TrainingDTO getSingleTraining(long id_training){
        return trainingRepository.findSingleTraining(id_training);
    }

    public List<TrainingDTO> getSingleTrainingWithParticipants(long id_training){
        return trainingRepository.findSingleTrainingWithUsers(id_training);
    }

    private List<User> extractUsers(List<User> users, long idTraining) {
        return users.stream()
                .filter(user -> user.getId() == idTraining)
                .collect(Collectors.toList());
    }

    public Training addTraining(Training training) {
        training.setCreated_at(Timestamp.from(Instant.now()));
        return trainingRepository.save(training);
    }

    @Transactional
    public Training editTraining(Training training) {
        Training trainingEdited = trainingRepository.findById(training.getId()).orElseThrow();
        trainingEdited.setTitle(training.getTitle());
        trainingEdited.setLevel(trainingEdited.getLevel());
        trainingEdited.setDate(training.getDate());
        trainingEdited.setRoom(training.getRoom());
        trainingEdited.setRun_by(trainingEdited.getRun_by());
        trainingEdited.setUsers(trainingEdited.getUsers());
        return trainingEdited;
    }

    public void deleteTraining(long id) {
        trainingRepository.deleteById(id);
    }
}
