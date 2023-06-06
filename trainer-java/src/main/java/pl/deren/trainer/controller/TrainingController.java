package pl.deren.trainer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import pl.deren.trainer.model.Training;
import pl.deren.trainer.service.TrainingService;

import java.util.List;

@RestController
@RequestMapping("/api/trainings")
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;

    @GetMapping
    public List<Training> getTrainings(@RequestParam(required = false) Integer page, Sort.Direction sort){
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return trainingService.getTrainings(pageNumber, sortDirection);
    }

    @GetMapping("/{id_training}")
    public Training getSingleTraining(@PathVariable long id_training){
        return trainingService.getSingleTraining(id_training);
    }

    @GetMapping("/participants")
    public List<Training> getTrainingsWithParticipants(@RequestParam(required = false) Integer page, Sort.Direction sort){
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return trainingService.getTrainingsWithParticipants(pageNumber, sortDirection);
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
