package com.sus.app.systemUsabilityScale.repositories;

import com.sus.app.systemUsabilityScale.models.Scale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ScaleRepository extends JpaRepository<Scale, Long> {

    @Query("SELECT AVG(score) FROM Scale")
    float findAverageScore();

    @Query("SELECT MIN(score) FROM Scale")
    float findLowestScore();

    @Query("SELECT MAX(score) FROM Scale")
    float findHighestScore();

    @Query("SELECT COUNT(score) FROM Scale")
    int findScoreCount();

/*    @Query("SELECT a FROM Scale a WHERE a.sqlTimestamp <= : sqlTimestamp")
    List<Scale> findByTime(@Param("sqlTimestamp") Date sqlTimestamp);

    @Query(value = "SELECT * FROM Scale WHERE DATETIMESTAMP >= :dateFrom  AND DATETIMESTAMP < DATE_FORMAT(curdate(), '%d/%m/%Y')", nativeQuery = true)
    List<Scale> findByDate(@Param("sqlTimestamp") String sqlTimestamp);*/
/*    @Query(value = "SELECT * FROM Scales WHERE DATETIMESTAMP >= :dateFrom AND DATETIMESTAMP < DATE_FORMAT(curdate(), '%d/%m/%Y')", nativeQuery = true)
    List<Scale> findByDate(@Param("dateFrom") Date dateFrom);*/

/*    @Query("SELECT score FROM Scale WHERE create_date > DATEADD(hh, -2, GETDATE())")

    @Query("SELECT sql_Timestamp FROM Scales WHERE sql_Timestamp < CURRENT_TIMESTAMP(hh,-2, );")*/

    @Query(value = "SELECT AVG(score) FROM Scales WHERE sql_Timestamp > DATEADD(hh, -1, CURRENT_TIMESTAMP());", nativeQuery = true)
    float findHourlyScore();

    @Query(value = "SELECT AVG(score) FROM Scales WHERE sql_Timestamp > DATEADD(dd, -1, CURRENT_TIMESTAMP());", nativeQuery = true)
    float findDailyScore();

    @Query(value = "SELECT AVG(score) FROM Scales WHERE sql_Timestamp > DATEADD(dd, -7, CURRENT_TIMESTAMP());", nativeQuery = true)
    float findWeeklyScore();

    @Query(value = "SELECT AVG(score) FROM Scales WHERE sql_Timestamp > DATEADD(mm, -1, CURRENT_TIMESTAMP());", nativeQuery = true)
    float findMonthlyScore();

}
