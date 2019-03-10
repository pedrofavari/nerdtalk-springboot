package com.netshoes.nerdtalkspringboot.gateways;

import com.netshoes.nerdtalkspringboot.entities.Task;
import com.netshoes.nerdtalkspringboot.gateways.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TaskGatewayImpl implements TaskGateway {

    private final TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.insert(task);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findOne(String uuid) {
        return taskRepository.findById(uuid);
    }

    @Override
    public void deleteOne(String uuid) {
        taskRepository.deleteById(uuid);
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }
}
