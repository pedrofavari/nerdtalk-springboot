package com.netshoes.nerdtalkspringboot.http.controllers;

import com.netshoes.nerdtalkspringboot.entities.Task;
import com.netshoes.nerdtalkspringboot.http.converters.TaskConverter;
import com.netshoes.nerdtalkspringboot.http.data.TaskDataContract;
import com.netshoes.nerdtalkspringboot.usecases.TaskManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private final TaskConverter taskConverter;

    private final TaskManager taskManager;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskDataContract dataContract) throws URISyntaxException {
        Task task = taskManager.createTask(taskConverter.convert(dataContract));

        final URI uri =
                MvcUriComponentsBuilder.fromController(getClass())
                        .path("/{uuid}")
                        .buildAndExpand(task.getUuid())
                        .toUri();

        return ResponseEntity.created(uri).body(task);
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

    @DeleteMapping(value = "/{uuid}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity deleteOne(@PathVariable String uuid) {
        return taskManager.deleteOne(uuid) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/{uuid}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> updateOne(@PathVariable String uuid, @Valid @RequestBody TaskDataContract dataContract) {
        Task task = taskConverter.convert(dataContract);

        Task taskUpdated = taskManager.updateTask(uuid, task);

        return taskUpdated != null ? ResponseEntity.ok().body(taskUpdated) : ResponseEntity.notFound().build();
    }
}
