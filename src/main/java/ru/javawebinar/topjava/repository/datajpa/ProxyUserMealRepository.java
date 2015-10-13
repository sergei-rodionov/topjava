package ru.javawebinar.topjava.repository.datajpa;


import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by SergeiRodionov.ru on 11.10.2015.
 */
@Transactional(readOnly = true)
public interface ProxyUserMealRepository extends JpaRepository<UserMeal, Integer> {

    @Transactional
//    @Modifying
//    @Query("DELETE FROM UserMeal m WHERE m.id=:id AND m.user.id=:userId")
//    int delete(@Param("id") Integer id, @Param("userId") Integer userId);
    int deleteByIdAndUserId(Integer id, Integer userId);

    // LAZY
    List<UserMeal> findAllByUserIdOrderByDateTimeDesc(Integer userId);

    UserMeal findByIdAndUserId(Integer id, Integer UserId);

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = "user")
    UserMeal findOneByIdAndUserId(Integer id, Integer UserId);

//    @Query("SELECT m from UserMeal m WHERE m.user.id=:userId " +
//            "AND m.dateTime BETWEEN :startDate AND :endDate ORDER BY m.dateTime DESC")
//    List<UserMeal> findAllByDatetimeBetween(@Param("startDate") LocalDateTime startDate,
//                                            @Param("endDate") LocalDateTime endDate,
//                                            @Param("userId") Integer userId);

    // EAGY
    // @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = "user")
    // LAZY
    List<UserMeal> findAllByUserIdAndDateTimeBetweenOrderByDateTimeDesc(
            Integer userId,
            LocalDateTime startDate,
            LocalDateTime endDate);

    @Transactional
    @Override
    UserMeal save(UserMeal userMeal);

}
