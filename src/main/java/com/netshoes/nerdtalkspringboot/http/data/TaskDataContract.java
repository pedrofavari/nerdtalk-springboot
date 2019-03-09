package com.netshoes.nerdtalkspringboot.http.data;

import com.netshoes.nerdtalkspringboot.entities.Urgency;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class TaskDataContract {

    @NotNull
    @NotEmpty
    private String tittle;

    private String area;

    private String description;

    private Urgency urgency;
}
