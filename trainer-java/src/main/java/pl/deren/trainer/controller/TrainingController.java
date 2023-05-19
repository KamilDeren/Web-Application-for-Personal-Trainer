package pl.deren.trainer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
        return trainingService.getTrainings();
    }
}
