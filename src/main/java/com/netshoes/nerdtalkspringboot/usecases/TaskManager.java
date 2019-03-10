package com.netshoes.nerdtalkspringboot.usecases;

import com.netshoes.nerdtalkspringboot.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskManager {

    Task createTask(Task task);

    List<Task> getAll();

    Optional<Task> findOne(String uuid);

    boolean deleteOne(String uuid);

    Task updateTask(String uuid, Task task);
}
