package pl.deren.trainer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.deren.trainer.model.Training;
import pl.deren.trainer.service.TrainingService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;

    @GetMapping("/trainings")
    public List<Training> getTrainings(){
        return trainingService.getTrainings(0);
    }

    @GetMapping("/trainings/{id_training}")
    public Training getSingleTraining(@PathVariable long id_training){
        return trainingService.getSingleTraining(id_training);
    }

    @GetMapping("/trainings/participants")
    public List<Training> getTrainingsWithParticipants(int page){
        int pageNumber = page >= 0 ? page : 0;
        return trainingService.getTrainingsWithParticipants(pageNumber);
    }
}
