package main;

public class CeaserCipher {

	public static final String LowALPHABET = "abcdefghijklmnopqrstuvwxyz";
	public static final String HiALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String encrypt(String plainText, int shiftKey) {

		String cipherText = "";
		for (int ii = 0; ii < plainText.length(); ii++) {
			if (Character.isUpperCase(plainText.charAt(ii))) {
				int charPosition = HiALPHABET.indexOf(plainText.charAt(ii));
				int keyVal = (shiftKey + charPosition) % 26;
				char replaceVal = HiALPHABET.charAt(keyVal);
				cipherText += replaceVal;
			} else {
				int charPosition = LowALPHABET.indexOf(plainText.charAt(ii));
				int keyVal = (shiftKey + charPosition) % 26;
				char replaceVal = LowALPHABET.charAt(keyVal);
				cipherText += replaceVal;
			}
		}
		return cipherText;
	}

	public static String decrypt(String cipherText, int shiftKey) {

		String cipherText1 = "";
		for (int ii = 0; ii < cipherText.length(); ii++) {
			if (Character.isUpperCase(cipherText.charAt(ii))) {
				int charPosition = HiALPHABET.indexOf(cipherText.charAt(ii));
				int keyVal = (charPosition - shiftKey) % 26;
				if (keyVal < 0) {
					keyVal = HiALPHABET.length() + keyVal;
				}
				char replaceVal = HiALPHABET.charAt(keyVal);
				cipherText1 += replaceVal;
			} else {
				int charPosition = LowALPHABET.indexOf(cipherText.charAt(ii));
				int keyVal = (charPosition - shiftKey) % 26;
				if (keyVal < 0) {
					keyVal = LowALPHABET.length() + keyVal;
				}
				char replaceVal = LowALPHABET.charAt(keyVal);
				cipherText1 += replaceVal;
			}
		}
		return cipherText1;
	}

	public static void main(String[] args) {
		String message1 = "ABCDEFGHIJKLMOPQRSTUVWXYZ";
		System.out.println(encrypt(message1, 3));
		System.out.println(decrypt(encrypt(message1, 3), 3));
		System.out.println(encrypt(message1.toLowerCase(), 5));
		System.out.println(decrypt(encrypt(message1.toLowerCase(), 5), 5));
	}

}
