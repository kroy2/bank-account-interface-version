package application;

public class ApplicationOutput<obj> { // creation of generic object variable obj to be implemented in following code

	private obj info;
	private String error;
	
	private ApplicationOutput(obj info) {
		this.info = info;
	}
	private ApplicationOutput(String error) {
		this.error = error;
	}
	
	public obj getInfo() {
		return info;
	}
	
	public String getError() {
		return error;
	}
	
	public boolean successfulInfo() { // method that assumes a successful operation given that info is present
		return info != null;
	}
	
	//factory method that passes
	public static <altObj>ApplicationOutput<altObj> success(altObj info){ // static factory method that actually creates the intended result/output of action/
		return new ApplicationOutput<altObj>(info);
	}
	// factory method that fails
	// if successFulInfo does not assume a successful operation given that there is an absence of/inadequate info, then error message is presented
	public static <altObj>ApplicationOutput<altObj> fail(String error){
		return new ApplicationOutput<altObj>(error);
	}
}
