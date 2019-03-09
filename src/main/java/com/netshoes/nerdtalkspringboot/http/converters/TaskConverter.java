package com.netshoes.nerdtalkspringboot.http.converters;

import com.netshoes.nerdtalkspringboot.entities.Task;
import com.netshoes.nerdtalkspringboot.http.data.TaskDataContract;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TaskConverter implements Converter<TaskDataContract, Task> {

    @Override
    public Task convert(TaskDataContract dataContract) {

        Task task = new Task();
        BeanUtils.copyProperties(dataContract, task);

//        task.setTittle(dataContract.getTittle());
//        task.setDescription(dataContract.getDescription());
//        task.setArea(dataContract.getArea());
//        task.setUrgency(dataContract.getUrgency());

        return task;
    }
}
