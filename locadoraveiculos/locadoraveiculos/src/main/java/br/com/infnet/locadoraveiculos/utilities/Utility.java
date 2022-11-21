package br.com.infnet.locadoraveiculos.utilities;

public class Utility {
	
	public static String getFirstName(String stg) {
		Character firstLetter = stg.trim().toUpperCase().charAt(0);
		stg = stg.trim().substring(1).split(" ")[0];
		return firstLetter+stg;
	}

}
