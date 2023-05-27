package pl.deren.trainer.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.deren.trainer.model.Training;
import pl.deren.trainer.model.User;
import pl.deren.trainer.repository.TrainingRepository;
import pl.deren.trainer.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrainingService {

    private static final int PAGE_SIZE = 10;
    private final TrainingRepository trainingRepository;
    private final UserRepository userRepository;

    public List<Training> getTrainings(int page, Sort.Direction sort){
        return trainingRepository.findAllTrainings(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
    }

    public Training getSingleTraining(long id_training){
        return trainingRepository.findById(id_training).orElseThrow();
    }

    public List<Training> getTrainingsWithParticipants(int page, Sort.Direction sort) {
        List<Training> allTrainings = trainingRepository.findAllTrainings(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
        List<Long> ids = allTrainings.stream()
                .map(Training::getId)
                .collect(Collectors.toList());
        List<User> users = userRepository.findAllByIdIn(ids);
        allTrainings.forEach(training -> training.setUsers(extractUsers(users, training.getId())));
        return allTrainings;
    }

    private List<User> extractUsers(List<User> users, long idTraining) {
        return users.stream()
                .filter(user -> user.getId() == idTraining)
                .collect(Collectors.toList());
    }

    public Training addTraining(Training training) {
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
