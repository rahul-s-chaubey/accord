package com.idbiintech.smartcontract.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idbiintech.smartcontract.Entity.CustomerMaster;

public interface CustomerMasterRepo extends JpaRepository<CustomerMaster, Integer> {

}
