package com.netshoes.nerdtalkspringboot.http.controllers;

import com.netshoes.nerdtalkspringboot.entities.Task;
import com.netshoes.nerdtalkspringboot.http.converters.TaskConverter;
import com.netshoes.nerdtalkspringboot.http.data.TaskDataContract;
import com.netshoes.nerdtalkspringboot.usecases.TaskManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private final TaskConverter taskConverter;

    private final TaskManager taskManager;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Task createTask(@Valid @RequestBody TaskDataContract dataContract){

        return taskManager.createTask(taskConverter.convert(dataContract));
    }
}
