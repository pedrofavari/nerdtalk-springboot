package com.netshoes.nerdtalkspringboot.usecases;

import com.netshoes.nerdtalkspringboot.entities.Task;

public interface TaskManager {

    Task createTask(Task task);
}
