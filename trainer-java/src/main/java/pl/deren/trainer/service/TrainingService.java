package pl.deren.trainer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
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

    public List<Training> getTrainings(int page){
        return trainingRepository.findAllTrainings(PageRequest.of(page, PAGE_SIZE));
    }

    public Training getSingleTraining(long id_training){
        return trainingRepository.findById(id_training).orElseThrow();
    }

    public List<Training> getTrainingsWithParticipants(int page) {
        List<Training> allTrainings = trainingRepository.findAllTrainings(PageRequest.of(page, PAGE_SIZE));
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
}
