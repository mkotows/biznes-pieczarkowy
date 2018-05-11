package pl.coderslab.pieczarki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.pieczarki.model.Expense;
import pl.coderslab.pieczarki.model.MushroomHall;

import java.sql.Date;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {

//    @Query
//    List<Expense> findAllByMushroomHall(MushroomHall mushroomHall);

    @Query
    List<Expense> findAllByMushroomHallAndDateBetween(MushroomHall mushroomHall, Date start, Date end);

    @Query
    List<Expense> findAllByDateBetween(Date start, Date end);
}
