package com.rves.test.service.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class FutureTaskWrapper implements Callable<String> {

    private TaskServiceImpl task = new TaskServiceImpl();
    private Future<String> future;
    private int genreId;

    public FutureTaskWrapper(int genreId) {
        this.genreId = genreId;
    }

    @Override
    public String call(){
        task.calculation(genreId);
        return Thread.currentThread().getName();
    }

    public TaskServiceImpl getTask() {
        return task;
    }

    public Future<String> getFuture() {
        return future;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setTask(TaskServiceImpl task) {
        this.task = task;
    }

    public void setFuture(Future<String> future) {
        this.future = future;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }
}
