package com.idbiintech.smartcontract.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbiintech.smartcontract.DTO.CarloanDTO;
import com.idbiintech.smartcontract.DTO.ResponseDTO;
import com.idbiintech.smartcontract.Entity.CustomerDetail;
import com.idbiintech.smartcontract.Entity.CustomerMaster;
import com.idbiintech.smartcontract.Entity.LoanDetails;
import com.idbiintech.smartcontract.Repository.CustomerDetailRepository;
import com.idbiintech.smartcontract.Repository.CustomerMasterRepo;
import com.idbiintech.smartcontract.Repository.LoanDetailRepository;
import com.idbiintech.smartcontract.ServiceImpl.CarloanServiceImpl;

@Service
public class CarloanServices implements CarloanServiceImpl {

	@Autowired
	CustomerMasterRepo CustomerMasterRepo;

	@Autowired
	CustomerDetailRepository CustomerDetailRepository;
	
	@Autowired
	LoanDetailRepository LoanDetailRepository;


	@Override
	public ResponseDTO insertintotable(CarloanDTO carloandto) {

		ResponseDTO responseDTO = null;
		
		  try {
			CustomerMaster customermaster = new CustomerMaster();
			  customermaster.setFirstName(carloandto.getLenderfirstname());
			  customermaster.setLastName(carloandto.getLenderlastname());
			  customermaster.setMiddleName(carloandto.getLendermiddlename());
			  customermaster.setCity(carloandto.getCity());
			  customermaster.setState(carloandto.getState());
			  customermaster.setAddress(carloandto.getAddress());
			  
			  CustomerMasterRepo.save(customermaster);
			 

			  CustomerDetail customerdetail = new CustomerDetail();
//		  customerdetail.setAccountNo(carloandto.getAccountno());
			  customerdetail.setBank(carloandto.getBankname());
			  customerdetail.setCustomerId(customermaster.getCustomerId());
			  
			  CustomerDetailRepository.save(customerdetail);
			  
			  
			  LoanDetails loandetails = new LoanDetails();
			  loandetails.setCustomerId(customermaster.getCustomerId());
			  loandetails.setLoanCategory(carloandto.getLoancategory());
//			  loandetails.setLoanInterest(carloandto.getLoaninterest());
			  loandetails.setLoanPurpose(carloandto.getLoanproposaldate());
			  loandetails.setLoanPurpose(carloandto.getLoanpurpose());
//			  loandetails.setLoanAmount(carloandto.getLoanamount());
//			  loandetails.setLoanDuration(carloandto.getLoanduration());
			  
			  
			  
			  LoanDetailRepository.save(loandetails);
			  
			  	responseDTO = new ResponseDTO();
				responseDTO.setMessage("Data saved sucessfully");
			  
				responseDTO.setData("ok");
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			responseDTO = new ResponseDTO();
			responseDTO.setMessage("Data not saved");
			responseDTO.setData("failure");
		}
		  
		  
		return responseDTO;
	}

}
