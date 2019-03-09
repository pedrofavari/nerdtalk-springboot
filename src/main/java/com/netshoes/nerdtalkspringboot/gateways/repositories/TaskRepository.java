package com.netshoes.nerdtalkspringboot.gateways.repositories;

import com.netshoes.nerdtalkspringboot.entities.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
}
