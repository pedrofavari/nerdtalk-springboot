package com.netshoes.nerdtalkspringboot.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class Task {

    @Id
    private String uuid;

    private String tittle;

    private String area;

    private String description;

    private Urgency urgency;

    private LocalDateTime dateInsertion;
}
