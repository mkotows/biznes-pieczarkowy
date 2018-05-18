package pl.coderslab.pieczarki.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.pieczarki.model.Task;
import pl.coderslab.pieczarki.repository.TaskRepository;

@Component
//@ConfigurationPropertiesBinding
public class TaskConverter implements Converter<String, Task> {

    @Autowired
    private TaskRepository taskRepository;

    public TaskConverter() {
    }

    @Override
    public Task convert(String source) {
        Task task = taskRepository.getOne(Long.parseLong(source));
        return task;
    }
}