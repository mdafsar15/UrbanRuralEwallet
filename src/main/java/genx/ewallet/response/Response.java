package genx.ewallet.response;

import java.util.List;
import java.util.Map;

import genx.ewallet.model.UPPCLHierarchy;
import genx.ewallet.model.districtLookup;
import lombok.Data;

@Data
public class Response {
	private String message;

	private int statusCode;

	private List<UPPCLHierarchy> list;

	public Response(int statusCode, List<UPPCLHierarchy> list) {
		this.statusCode = statusCode;
		this.list = list;
	}

	public Response( int statusCode) {

		this.statusCode = statusCode;
	}

}