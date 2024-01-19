package com.idbiintech.smartcontract.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idbiintech.smartcontract.Entity.CustomerDetail;

public interface CustomerDetailRepository extends JpaRepository<CustomerDetail, Integer> {

}
