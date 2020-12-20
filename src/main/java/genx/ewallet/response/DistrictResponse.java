package genx.ewallet.response;

import java.util.List;

import genx.ewallet.model.districtLookup;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DistrictResponse {

	private int statusCode;

	private List<String> list;

	public DistrictResponse(int statusCode, List<String> list) {
		this.statusCode = statusCode;
		this.list = list;
	}

	public DistrictResponse(int statusCode) {
		super();
		this.statusCode = statusCode;
	}

}
