package com.rves.test.service.impl;

import com.rves.test.entity.TemporaryResult;
import com.rves.test.service.ExecutorTaskMapWrapperService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.*;

@Service
public class ExecutorTaskMapWrapperServiceImpl implements ExecutorTaskMapWrapperService
{
    final private ExecutorService executor = Executors.newFixedThreadPool(19);
    final private Map<Integer, FutureTaskWrapper> taskMap = new ConcurrentHashMap<>();

    public Map<Integer, FutureTaskWrapper> getTaskMap() {
        return taskMap;
    }

    @Override
    public TemporaryResult startTask(int genreId) {
        FutureTaskWrapper futureTaskWrapper = new FutureTaskWrapper(genreId);
        Future<String> future = executor.submit(futureTaskWrapper);
        futureTaskWrapper.setFuture(future);
        taskMap.put(genreId, futureTaskWrapper);
        return taskMap.get(genreId).getTask().getTemporaryResult();
    }

    @Override
    public TemporaryResult getInfo(int genreId) {
        if (taskMap.containsKey(genreId)) {
            return taskMap.get(genreId).getTask().getTemporaryResult();
        }
        return null;
    }

    @Override
    public void stop(int genreId){
        taskMap.get(genreId).getTask().setStop(true);
    }

}
