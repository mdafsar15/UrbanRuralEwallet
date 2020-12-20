package genx.ewallet.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BillResponse {

	private String status;
	private String discomName;
	private String zoneName;
	private String circleName;
	private String districtName;
	private String divisionName;
	private String divisionCode;

}
