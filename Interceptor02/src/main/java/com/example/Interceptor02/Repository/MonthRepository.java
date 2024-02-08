package com.example.Interceptor02.Repository;

import com.example.Interceptor02.entities.Month;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MonthRepository extends JpaRepository<Month,Long>
{
    @Query(value = "SELECT * FROM month WHERE month_number = :monthNumber", nativeQuery = true)
    Month findMonthByMonthNumber(@Param("monthNumber")int monthNumber);
}
