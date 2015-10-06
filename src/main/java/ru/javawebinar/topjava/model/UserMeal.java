package ru.javawebinar.topjava.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * GKislin
 * 11.01.2015.
 */

@NamedQueries({
        @NamedQuery(name = UserMeal.GET, query = "SELECT um FROM UserMeal um WHERE um.user.id=:user_id AND um.id=:id"),
        @NamedQuery(name = UserMeal.ALL_SORTED, query = "SELECT um FROM UserMeal um " +
                "WHERE um.user.id=:user_id ORDER BY um.dateTime DESC"),
        @NamedQuery(name = UserMeal.DELETE, query = "DELETE FROM UserMeal um WHERE um.user.id=:user_id AND um.id=:id"),
        @NamedQuery(name = UserMeal.BETWEEN, query = "SELECT um FROM UserMeal um " +
                "WHERE um.user.id=:user_id AND um.dateTime BETWEEN :startDate AND :endDate ORDER BY um.dateTime DESC"),
        @NamedQuery(name = UserMeal.UPDATE, query = "UPDATE UserMeal um SET um.dateTime=:dateTime, " +
                "um.description=:description, um.calories=:calories WHERE um.user.id=:user_id AND um.id=:id")
})

@Entity
@Table(name = "meals")
public class UserMeal extends BaseEntity {

    public static final String GET = "UserMeal_GET";
    public static final String ALL_SORTED = "UserMeal_ALL_SORTED";
    public static final String DELETE = "UserMeal_DELETE";
    public static final String BETWEEN = "UserMeal_BETWEEN";
    public static final String UPDATE = "UserMeal_UPDATE";


    // с зависимость hibernate-java8 можно не использовать кастомный конвертер
    // @Type(type = "org.hibernate.type.LocalDateTimeType")
    // кастомный конвертер для LocalDateTime
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    @Column(name = "date_time", nullable = false)
    protected LocalDateTime dateTime;

    @Column(name = "description", nullable = false)
    @NotBlank
    protected String description;

    @Column(name = "calories", nullable = false)
    @Digits(fraction = 0, integer = 4)
    @Min(value = 0)
    @NotNull
    protected int calories;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "user_id", updatable = false, nullable = false)
    private User user;

    public UserMeal() {
    }

    public UserMeal(LocalDateTime dateTime, String description, int calories) {
        this(null, dateTime, description, calories);
    }

    public UserMeal(Integer id, LocalDateTime dateTime, String description, int calories) {
        super(id);
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public Integer getId() {
        return id;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "UserMeal{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
    }
}