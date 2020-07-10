package challenge;

public class CriptografiaCesariana implements Criptografia {
	
	final static int SHIFT_HOUSES = 3;

	public char decryptLetter(char letter) {
		char newLetter = letter;
		if(letter >= 'a' && letter <= 'z') {
			
			if(letter-SHIFT_HOUSES >= 'a') {
				newLetter = (char) (letter-SHIFT_HOUSES);
			}else {
				newLetter = (char) ('z' - (SHIFT_HOUSES - (letter - 'a' + 1)));
			}
		}
		return newLetter;
	}
	
	public char encryptLetter(char letter) {
		char newLetter = letter;
		if(letter >= 'a' && letter <= 'z') {
			
			if(letter+SHIFT_HOUSES <= 'z') {
				newLetter = (char) (letter+SHIFT_HOUSES);
			}else {
				newLetter = (char) ('a' + (SHIFT_HOUSES - ('z' - letter + 1)));
			}
		}
		return newLetter;
	}
	
    @Override
    public String criptografar(String texto) {
    	if(texto.length() <= 0) throw new IllegalArgumentException();
    	texto = texto.toLowerCase();
		char encryptedTextCharArray[] = new char[texto.length()];; 
		for(int i = 0; i < texto.length(); i++) {
			encryptedTextCharArray[i] = encryptLetter(texto.charAt(i));
		}
		return String.copyValueOf(encryptedTextCharArray);
    }

    @Override
    public String descriptografar(String texto) {
    	if(texto.length() <= 0) throw new IllegalArgumentException();
    	texto = texto.toLowerCase();
		char decryptedTextCharArray[] = new char[texto.length()];; 
		for(int i = 0; i < texto.length(); i++) {
			decryptedTextCharArray[i] = decryptLetter(texto.charAt(i));
		}
		return String.copyValueOf(decryptedTextCharArray);
    }
}
