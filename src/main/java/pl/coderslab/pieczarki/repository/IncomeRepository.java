package pl.coderslab.pieczarki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.pieczarki.model.Income;
import pl.coderslab.pieczarki.model.MushroomHall;

import java.sql.Date;
import java.util.List;

public interface IncomeRepository extends JpaRepository<Income, Long> {

    @Query
    List<Income> findAllByMushroomHallAndDateBetween(MushroomHall mushroomHall, Date start, Date end);

    @Query
    List<Income> findAllByDateBetween(Date start, Date end);

}
