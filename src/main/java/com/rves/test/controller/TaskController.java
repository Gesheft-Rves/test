package com.rves.test.controller;

import com.rves.test.entity.Genre;
import com.rves.test.entity.TemporaryResult;
import com.rves.test.entity.response.InfoResponse;
import com.rves.test.entity.response.StartResponse;
import com.rves.test.entity.response.StopResponse;
import com.rves.test.service.impl.ExecutorTaskMapWrapperServiceImpl;
import com.rves.test.service.impl.GenreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    private final ExecutorTaskMapWrapperServiceImpl executorTaskMapWrapperServiceImpl;
    private final GenreServiceImpl genreService;

    @Autowired
    public TaskController(ExecutorTaskMapWrapperServiceImpl executorTaskMapWrapperServiceImpl, GenreServiceImpl genreService) {
        this.executorTaskMapWrapperServiceImpl = executorTaskMapWrapperServiceImpl;
        this.genreService = genreService;
    }

    @RequestMapping(value = "/start")
    @ResponseBody
    public StartResponse start (@RequestParam(name  = "genreId") Integer genreId) {
        StartResponse badStartResponse = new StartResponse();
        if (executorTaskMapWrapperServiceImpl.getTaskMap().get(genreId) != null){
            if(!executorTaskMapWrapperServiceImpl.getTaskMap().get(genreId).getFuture().isDone()){
                badStartResponse.setMsg("A task with this id = " + genreId + " is already running");
              return badStartResponse;
            }
        }

        for (Genre genre : genreService.getAllGenres()) {
            if (genre.getId().equals(genreId)) {
                executorTaskMapWrapperServiceImpl.startTask(genreId);
                return new StartResponse("The task is started for a genre with an id = " + genreId);
            }
        }
        badStartResponse.setMsg("There is no such genre with id = " + genreId);
        return badStartResponse;
    }

    @RequestMapping(value = "/getInfo")
    @ResponseBody
    public InfoResponse getInfo (@RequestParam(name  = "genreId") Integer genreId) {
        TemporaryResult tempResult = executorTaskMapWrapperServiceImpl.getInfo(genreId);
        if (executorTaskMapWrapperServiceImpl.getInfo(genreId) == null){
            return new InfoResponse("Not started task for genre id = " + genreId);
        }
        return new InfoResponse(tempResult.getQuantityMoviesRead(),tempResult.getAverageRatingByGenre());
    }

    @RequestMapping(value = "/stop")
    @ResponseBody
    public StopResponse stop (@RequestParam(name  = "genreId") Integer genreId) {
        if (executorTaskMapWrapperServiceImpl.getTaskMap().get(genreId) == null){
            return new StopResponse("The task with this id = " + genreId + " is not running");
        }
        executorTaskMapWrapperServiceImpl.stop(genreId);
        TemporaryResult tempResult = executorTaskMapWrapperServiceImpl.getTaskMap().get(genreId).getTask().getTemporaryResult();
        return new StopResponse(tempResult.getQuantityMoviesRead(),tempResult.getAverageRatingByGenre());
    }

}
