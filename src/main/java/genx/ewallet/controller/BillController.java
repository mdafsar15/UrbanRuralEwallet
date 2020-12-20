package genx.ewallet.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import genx.ewallet.exception.RuralUrbanException;
import genx.ewallet.model.UPPCLHierarchy;
import genx.ewallet.response.BillResponse;
import genx.ewallet.response.DistrictResponse;
import genx.ewallet.response.ErrorResponse;
import genx.ewallet.response.Response;
import genx.ewallet.service.BillService;

@RestController
public class BillController {

	private static final Logger log = LoggerFactory.getLogger(BillController.class);

	@Autowired
	private BillService billService;

	@GetMapping("/getAllDistrict")
	public ResponseEntity<DistrictResponse> getHierarchy() {
		List<String> bill = billService.findId();
		log.info("get District name for response : " + bill);
		if (!bill.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(new DistrictResponse(200, bill));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DistrictResponse(400));
	}

	
	@GetMapping("/getUrbanRural")
	public BillResponse getBillUrban(@RequestParam("area") String area,
			@RequestParam("code") String code) throws RuralUrbanException{
		List<Object[]> bill = billService.findBillRuralUrban(area, code);
		log.info("get rural and urban for response : " + bill);
		BillResponse billResponse = null;
		if (bill.isEmpty()) {
//			return billResponse = BillResponse.builder().message("File Not Found").status("404").build();
			throw new  RuralUrbanException("File Not Found", 404);

			}
		
		Object[] userDetails = bill.get(0);
		  
	    String discomName = String.valueOf(userDetails[0]);
	    String zoneName = String.valueOf(userDetails[1]);	
	    String circleName = String.valueOf(userDetails[2]);
	    String districtName = String.valueOf(userDetails[3]);
	    String divisionName = String.valueOf(userDetails[4]);
	    String divisionCode = String.valueOf(userDetails[5]);
	    
		billResponse = BillResponse.builder().discomName(discomName).zoneName(zoneName).circleName(circleName).
				districtName(districtName).divisionName(divisionName).divisionCode(divisionCode).status("200").build();
		return billResponse;
	}

}