package com.hcl.surabi.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.surabi.entities.MyOrderHistory;

@Repository
public interface OrderHistoryRepository extends JpaRepository<MyOrderHistory, Long> {
    
	// PARTICULAR USER'S ORDER HISTORY 
    public List<MyOrderHistory> findByUserName(String userName);
    // ORDER HISTORY BY DATE
    public List<MyOrderHistory> findByDate(LocalDate ld);
    
    
    // QUERY FOR MONTHLY BILLS
    @Query("From MyOrderHistory where date between '2022/11/01' AND '2022/11/30'")
    public List<MyOrderHistory> TotalMonthlyBills();
}