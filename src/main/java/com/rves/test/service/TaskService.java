package com.rves.test.service;

import com.rves.test.entity.TemporaryResult;

public interface TaskService {
    TemporaryResult calculation (int genreId) throws InterruptedException;
}
