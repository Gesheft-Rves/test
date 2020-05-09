package com.rves.test.service;

import com.rves.test.entity.TemporaryResult;

public interface ExecutorTaskMapWrapperService {

    TemporaryResult startTask(int id);
    TemporaryResult getInfo(int genreId);
    void stop(int genreId);
}
