package com.idbiintech.smartcontract.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbiintech.smartcontract.DTO.CarloanDTO;
import com.idbiintech.smartcontract.Entity.CustomerMaster;
import com.idbiintech.smartcontract.Repository.CustomerMasterRepo;
import com.idbiintech.smartcontract.ServiceImpl.CarloanServiceImpl;

@Service
public class CarloanServices implements CarloanServiceImpl {
	
	
	@Autowired
	CustomerMasterRepo CustomerMasterRepo;

	@Override
	public String insertintotable(CarloanDTO carloandto) {
	

		CustomerMaster customermaster = new CustomerMaster();
		customermaster.setFirstName(carloandto.getLenderfirstname());
		customermaster.setLastName(carloandto.getLenderlastname());
		
	
		CustomerMasterRepo.save(customermaster);
	
		
		return "sucess";
	}

}
