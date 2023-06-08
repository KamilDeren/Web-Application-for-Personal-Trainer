package pl.deren.trainer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.deren.trainer.DTO.TrainingDTO;
import pl.deren.trainer.model.Training;
import pl.deren.trainer.service.TrainingService;

import java.util.List;

@RestController
@RequestMapping("/api/trainings")
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;

    @GetMapping
    public List<TrainingDTO> getTrainings(){
        return trainingService.getTrainings();
    }

    @GetMapping("/{id_training}")
    public TrainingDTO getSingleTraining(@PathVariable long id_training){
        return trainingService.getSingleTraining(id_training);
    }
    @GetMapping("/{id_training}/participants")
    public List<TrainingDTO> getSingleTrainingWithParticipants(@PathVariable long id_training){
        return trainingService.getSingleTrainingWithParticipants(id_training);
    }

    @PostMapping
    public Training addTraining(@RequestBody Training training){
        return trainingService.addTraining(training);
    }

    @PutMapping
    public Training editTraining(@RequestBody Training training){
        return trainingService.editTraining(training);
    }

    @DeleteMapping("/{id}")
    public void deleteTraining(@PathVariable long id){
        trainingService.deleteTraining(id);
    }
}
