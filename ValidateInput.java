public class ValidateInput {
	
	private View theView;
	
	public ValidateInput(View theView) {
		this.theView = theView;
	}
	
	public boolean validateInput(String fName, String lName, String address, String postalCod, String phoneNum) {
		if (validatePostalCode(postalCod)) {
			if (validateNameLength(fName, lName)) {
				if (validateAddressLength(address)) {
					if (validatePhoneNum(phoneNum)) {
						return true;
					} else
						theView.phoneErrorMessage();
				} else
					theView.addressErrorMessage();
			} else
				theView.nameErrorMessage();
		} else
			theView.postalCodErrorMessage();
		return false;
	}
	
	public boolean validatePostalCode(String posCode) {

		if (posCode.length() != 7)
			return false;
		if (posCode.length() == 7) {
			char a = posCode.charAt(0);
			char b = posCode.charAt(1);
			char c = posCode.charAt(2);
			char d = posCode.charAt(3);
			char e = posCode.charAt(4);
			char f = posCode.charAt(5);
			char g = posCode.charAt(6);

			if (!(Character.isLetter(a) && Character.isUpperCase(a) && Character.isLetter(c) && Character.isUpperCase(c)
					&& Character.isLetter(f) && Character.isUpperCase(f)))
				return false;
			if (!(Character.isDigit(b) && Character.isDigit(e) && Character.isDigit(g)))
				return false;
			if (!Character.isWhitespace(d))
				return false;
		}
		return true;
	}

	/**
	 * Validates that the user input for the phone number follows the correct format
	 * 
	 * @param phoneNum phone number
	 * @return true if format is correct and false otherwise
	 */
	public boolean validatePhoneNum(String phoneNum) {
		if (phoneNum.length() != 12)
			return false;
		if (phoneNum.length() == 12) {
			if (phoneNum.matches("\\d{3}[-]\\d{3}[-]\\d{4}"))
				return true;
		}
		return false;
	}

	/**
	 * Validates that the user input for names are less than the specified number of
	 * characters
	 * 
	 * @param fName first name
	 * @param lName last name
	 * @return true if less than max length and false otherwise
	 */
	public boolean validateNameLength(String fName, String lName) {
		if (fName.length() > 20 || lName.length() > 20) {
			return false;
		}
		return true;
	}

	/**
	 * Validates that the user input for address is less than the maximum number of
	 * characters
	 * 
	 * @param address address
	 * @return true if less than max length and false otherwise
	 */
	public boolean validateAddressLength(String address) {
		if (address.length() > 50) {
			return false;
		}
		return true;
	}

}
