package genx.ewallet.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import genx.ewallet.model.UPPCLHierarchy;
import genx.ewallet.model.districtLookup;
import genx.ewallet.repository.IBillRepository;

@Service
public class BillService {

	private static final Logger log = LoggerFactory.getLogger(BillService.class);

	@Autowired
	IBillRepository iBillRepository;

	public List<String> findId() {
		log.info("return district name");
		return iBillRepository.getAllDistrict();
	}

	public List<UPPCLHierarchy> findBillRural(String code) {
		log.info("return all data");
		return iBillRepository.fndBill(code);

	}

	public List<Object[]> findBillRuralUrban(String area, String code) {
		if (area.equals("NON_RAPDRP")) {
			log.info("return rural area");
			return  iBillRepository.fndBillHierarchy(code);
		} else {
			log.info("return urban area");
			return iBillRepository.fndBillHierarchy1(code);
		}

	}

}
