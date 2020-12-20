package genx.ewallet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "UPPCLHierarchy")
@Table(name = "UPPCLHierarchy")
@Data
@Getter
@Setter
public class UPPCLHierarchy {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int id;

	@Column(nullable=false)
	private String discomName;
	
	@Column(nullable=false)
	private String zoneName;
	
	@Column(nullable=false)
	private String circleName;
	
	@Column(nullable=false)
	private String districtName;
	
	@Column(nullable=false)
	private String divisionName;

	
	@Column(name = "ruralDivisionCode", nullable=false)
	private String ruralDivisionCode;
	
	@Column(name = "urbanDivisionCode", nullable=false)
	private String urbanDivisionCode;

}
