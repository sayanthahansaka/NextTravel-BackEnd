package com.sayantha.payments.repo;


import com.sayantha.payments.entity.PaymentsDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailsRepo extends JpaRepository<PaymentsDetails, Integer> {

}
