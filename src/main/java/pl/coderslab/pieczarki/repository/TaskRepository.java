package pl.coderslab.pieczarki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.pieczarki.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}