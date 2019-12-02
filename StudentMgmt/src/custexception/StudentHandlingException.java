package custexception;

//CUSTOM EXCEPTION HANDLING CLASS TO BE USED WHEN ONE OF THE VALIDATINO RULES FAIL
//SERIAL VERSION UID EXISTS BECAUSE EXCEPTION CLASS IS SERIALIZABLE
//SIMPLY DEFINING A PARAM CONSTRUCTOR AND PASSING THE MESSAGE TO AN EXCEPTION CTOR USING SUPER

public class StudentHandlingException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public StudentHandlingException(String message) {
		super(message);
	}

}
