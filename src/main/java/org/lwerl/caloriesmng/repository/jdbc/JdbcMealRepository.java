package org.lwerl.caloriesmng.repository.jdbc;

import org.lwerl.caloriesmng.model.UserMeal;
import org.lwerl.caloriesmng.repository.UserMealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class JdbcMealRepository implements UserMealRepository {
    private static final RowMapper<UserMeal> ROW_MAPPER = new RowMapper<UserMeal>() {
        @Override
        public UserMeal mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new UserMeal(rs.getInt("id"), rs.getString("description"), rs.getTimestamp("date").toLocalDateTime(), rs.getInt("calories"));
        }
    };

    @Resource
    private JdbcTemplate jdbcTemplate;
    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;

    @Autowired
    private JdbcMealRepository(DataSource dataSource) {
        this.jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("MEALS").usingGeneratedKeyColumns("id");
    }

    @Override
    public UserMeal save(UserMeal userMeal, int userId) {
        MapSqlParameterSource map = new MapSqlParameterSource().
                addValue("id", userMeal.getId()).
                addValue("description", userMeal.getDescription()).
                addValue("date", Timestamp.valueOf(userMeal.getDate())).
                addValue("calories", userMeal.getCalories()).
                addValue("user_id", userId);
        if (userMeal.isNew()) {
            Number key = jdbcInsert.executeAndReturnKey(map);
            userMeal.setId(key.intValue());
        } else {
            if (namedParameterJdbcTemplate.update("UPDATE meals SET description=:description, date=:date, calories=:calories WHERE id=:id AND user_id=:user_id", map) == 0)
                return null;
        }
        return userMeal;
    }

    @Override
    public boolean delete(int id, int userId) {
        return (jdbcTemplate.update("DELETE FROM meals WHERE id=? AND user_id=?", id, userId) != 0);
    }

    @Override
    public UserMeal get(int id, int userId) {
        List<UserMeal> meals = jdbcTemplate.query("SELECT * FROM meals WHERE id=? AND user_id=?", ROW_MAPPER, id, userId);
        return meals.isEmpty() ? null : meals.get(0);
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        List<UserMeal> meals = jdbcTemplate.query("SELECT * FROM meals WHERE user_id=?", ROW_MAPPER, userId);
        return meals.isEmpty() ? null : meals;
    }

    @Override
    public void deleteAll(int userId) {
        jdbcTemplate.update("DELETE FROM meals WHERE user_id=?", userId);
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        List<UserMeal> meals = jdbcTemplate.query("SELECT * FROM meals WHERE user_id=? AND date BETWEEN ? AND ? ORDER BY date DESC", ROW_MAPPER, userId, Timestamp.valueOf(startDate), Timestamp.valueOf(endDate));
        return meals.isEmpty() ? null : meals;
    }
}