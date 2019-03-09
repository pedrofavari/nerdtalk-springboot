package com.netshoes.nerdtalkspringboot.http.controllers;

import com.netshoes.nerdtalkspringboot.entities.Task;
import com.netshoes.nerdtalkspringboot.http.converters.TaskConverter;
import com.netshoes.nerdtalkspringboot.http.data.TaskDataContract;
import com.netshoes.nerdtalkspringboot.usecases.TaskManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private final TaskConverter taskConverter;

    private final TaskManager taskManager;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Task createTask(@Valid @RequestBody TaskDataContract dataContract){
        return taskManager.createTask(taskConverter.convert(dataContract));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Task>> getAll() {
        return ResponseEntity.ok(taskManager.getAll());
    }

    @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> findOne(@PathVariable String uuid){

        return taskManager.findOne(uuid)
                .map(task -> ResponseEntity.ok(task))
                .orElse(ResponseEntity.notFound().build());
    }
}
