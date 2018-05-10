package pl.coderslab.pieczarki.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @NotNull
    private Date date;

    @NotNull
    private BigDecimal duration;

    @NotNull
    private BigDecimal salary;

    private BigDecimal cost;

    @NotNull
    @ManyToMany
    private List<Employee> employees;

    @ManyToOne//(fetch=FetchType.EAGER)
    @JoinColumn(name="mushroomHallId")
    private MushroomHall mushroomHall;

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public MushroomHall getMushroomHall() {
        return mushroomHall;
    }

    public void setMushroomHall(MushroomHall mushroomHall) {
        this.mushroomHall = mushroomHall;
    }
}
