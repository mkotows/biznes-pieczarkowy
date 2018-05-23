package pl.coderslab.pieczarki.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "incomes")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String mushroom;

    @NotNull
    private Date date;

    @NotNull
    private BigDecimal pricePerKg;

    @NotNull
    private BigDecimal weight;

    private BigDecimal totalIncome;

    @ManyToOne
    private MushroomHall mushroomHall;

    private String description;

    public Income() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMushroom() {
        return mushroom;
    }

    public void setMushroom(String mushroom) {
        this.mushroom = mushroom;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(BigDecimal pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MushroomHall getMushroomHall() {
        return mushroomHall;
    }

    public void setMushroomHall(MushroomHall mushroomHall) {
        this.mushroomHall = mushroomHall;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
