package pl.coderslab.pieczarki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.pieczarki.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
}
