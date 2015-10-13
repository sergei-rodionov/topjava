package ru.javawebinar.topjava.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * User: gkislin
 * Date: 26.08.2014
 */

@Repository
public class JdbcUserMealRepositoryImpl implements UserMealRepository {

    private static final RowMapper<UserMeal> ROW_MAPPER =
            (rs, rowNum) ->
                    new UserMeal(rs.getInt("id"), rs.getTimestamp("date_time").toLocalDateTime(),
                            rs.getString("description"), rs.getInt("calories"));

    private static final RowMapper<UserMeal> ROW_MAPPER_FULL = new RowMapper<UserMeal>() {
        @Override
        public UserMeal mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(rs.getInt("users_id"), rs.getString("users_name"), rs.getString("users_email"),
                    rs.getString("users_password"), rs.getInt("users_calories_per_day"),
                    rs.getBoolean("users_enabled"),
                    new HashSet<Role>(Arrays.asList(Role.valueOf(rs.getString("user_roles_role"))))
            );
            UserMeal userMeal = new UserMeal(rs.getInt("meals_id"), rs.getTimestamp("meals_date_time").toLocalDateTime(),
                    rs.getString("meals_description"), rs.getInt("meals_calories"));
            userMeal.setUser(user);

            return userMeal;
        }
    };

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertUserMeal;

    @Autowired
    public JdbcUserMealRepositoryImpl(DataSource dataSource) {
        this.insertUserMeal = new SimpleJdbcInsert(dataSource)
                .withTableName("meals")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public UserMeal save(UserMeal userMeal, int userId) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", userMeal.getId())
                .addValue("description", userMeal.getDescription())
                .addValue("calories", userMeal.getCalories())
                .addValue("date_time", Timestamp.valueOf(userMeal.getDateTime()))
                .addValue("user_id", userId);

        if (userMeal.isNew()) {
            Number newId = insertUserMeal.executeAndReturnKey(map);
            userMeal.setId(newId.intValue());
        } else {
            if (namedParameterJdbcTemplate.update(
                    "UPDATE meals SET description=:description, calories=:calories, date_time=:date_time " +
                            " WHERE id=:id AND user_id=:user_id", map) == 0) {
                return null;
            }
        }
        return userMeal;
    }

    @Override
    public boolean delete(int id, int userId) {
        return jdbcTemplate.update("DELETE FROM meals WHERE id=? AND user_id=?", id, userId) != 0;
    }

    @Override
    public UserMeal get(int id, int userId) {
        List<UserMeal> userMeals = jdbcTemplate.query(
                "SELECT * FROM meals WHERE id = ? AND user_id = ?", ROW_MAPPER, id, userId);
        return DataAccessUtils.singleResult(userMeals);
    }

    @Override
    public UserMeal getFull(int id, int userId) {
        List<UserMeal> userMeals = jdbcTemplate.query(
                "SELECT meals.id AS meals_id," +
                        "meals.date_time AS meals_date_time," +
                        "meals.description AS meals_description ," +
                        "meals.calories AS meals_calories," +
                        "users.id AS users_id," +
                        "users.name AS users_name," +
                        "users.email AS users_email," +
                        "users.password AS users_password," +
                        "user_roles.role AS user_roles_role," +
                        "users.enabled AS users_enabled," +
                        "users.calories_per_day AS users_calories_per_day FROM meals LEFT JOIN users ON users.id = meals.user_id " +
                        "LEFT JOIN user_roles ON users.id = user_roles.user_id " +
                        "WHERE meals.id = ? AND meals.user_id = ?", ROW_MAPPER_FULL, id, userId);
        return DataAccessUtils.singleResult(userMeals);
    }

    public List<UserMeal> getAll(int userId) {
        return jdbcTemplate.query(
                "SELECT * FROM meals WHERE user_id=? ORDER BY date_time DESC", ROW_MAPPER, userId);
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return jdbcTemplate.query(
                "SELECT * FROM meals WHERE user_id=?  AND date_time BETWEEN  ? AND ? ORDER BY date_time DESC",
                ROW_MAPPER, userId, Timestamp.valueOf(startDate), Timestamp.valueOf(endDate));
    }
}