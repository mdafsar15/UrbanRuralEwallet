package genx.ewallet.exception;

public class RuralUrbanException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private final int status;

	public RuralUrbanException(String message, int status) {
		super(message);
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

}
