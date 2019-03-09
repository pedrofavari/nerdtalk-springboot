package com.netshoes.nerdtalkspringboot.gateways;

import com.netshoes.nerdtalkspringboot.entities.Task;

public interface TaskGateway {

    Task createTask(Task task);
}
