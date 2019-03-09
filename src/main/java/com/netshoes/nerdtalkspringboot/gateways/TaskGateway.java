package com.netshoes.nerdtalkspringboot.gateways;

import com.netshoes.nerdtalkspringboot.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskGateway {

    Task createTask(Task task);

    List<Task> getAll();

    Optional<Task> findOne(String uuid);
}
