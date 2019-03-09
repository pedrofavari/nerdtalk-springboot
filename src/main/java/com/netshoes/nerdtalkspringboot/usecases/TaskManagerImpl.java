package com.netshoes.nerdtalkspringboot.usecases;

import com.netshoes.nerdtalkspringboot.entities.Task;
import com.netshoes.nerdtalkspringboot.gateways.TaskGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TaskManagerImpl implements TaskManager {

    private final TaskGateway taskGateway;

    @Override
    public Task createTask(Task task) {
        task.setUuid(UUID.randomUUID().toString());
        task.setDateInsertion(LocalDateTime.now());

        return taskGateway.createTask(task);
    }

    @Override
    public List<Task> getAll() {
        return taskGateway.getAll();
    }

    @Override
    public Optional<Task> findOne(String uuid) {
        return taskGateway.findOne(uuid);
    }
}
