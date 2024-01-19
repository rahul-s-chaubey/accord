package com.idbiintech.smartcontract.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idbiintech.smartcontract.Entity.LoanDetails;

public interface LoanDetailRepository extends JpaRepository<LoanDetails, Integer> {

}
