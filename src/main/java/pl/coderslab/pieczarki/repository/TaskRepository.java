package pl.coderslab.pieczarki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.pieczarki.model.MushroomHall;
import pl.coderslab.pieczarki.model.Task;

import java.sql.Date;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query
    List<Task> findAllByMushroomHallAndDateBetween(MushroomHall mushroomHall, Date start, Date end);

    @Query
    List<Task> findAllByDateBetween(Date start, Date end);

}