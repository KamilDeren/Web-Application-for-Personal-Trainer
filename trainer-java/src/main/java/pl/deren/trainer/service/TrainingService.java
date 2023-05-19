package pl.deren.trainer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.deren.trainer.model.Training;
import pl.deren.trainer.repository.TrainingRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingService {

    private final TrainingRepository trainingRepository;

    public List<Training> getTrainings(){
        return trainingRepository.findAll();
    }
}