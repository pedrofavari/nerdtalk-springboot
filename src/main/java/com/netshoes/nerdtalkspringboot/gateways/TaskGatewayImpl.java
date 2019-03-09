package com.netshoes.nerdtalkspringboot.gateways;

import com.netshoes.nerdtalkspringboot.entities.Task;
import com.netshoes.nerdtalkspringboot.gateways.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskGatewayImpl implements TaskGateway {

    private final TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
}
