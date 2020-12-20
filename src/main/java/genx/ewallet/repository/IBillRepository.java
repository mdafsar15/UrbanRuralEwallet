package genx.ewallet.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import genx.ewallet.model.UPPCLHierarchy;
import genx.ewallet.model.districtLookup;

@Repository
public interface IBillRepository extends JpaRepository<UPPCLHierarchy, Long> {

	@Query("select Name from genx.ewallet.model.districtLookup")
	public List<String> getAllDistrict();

	@Query("select id,discomName,zoneName,circleName,districtName,divisionName from genx.ewallet.model.UPPCLHierarchy u where u.ruralDivisionCode = ?1")
	public List<UPPCLHierarchy> fndBill(String code);

	@Query("select discomName,zoneName,circleName,districtName,divisionName,ruralDivisionCode from UPPCLHierarchy u where u.ruralDivisionCode = :ruralDivisionCode ")
	public List<Object[]> fndBillHierarchy(String ruralDivisionCode);
	
	@Query("select discomName,zoneName,circleName,districtName,divisionName,urbanDivisionCode from UPPCLHierarchy u where u.urbanDivisionCode = :urbanDivisionCode ")
	public List<Object[]> fndBillHierarchy1(String urbanDivisionCode);

}
