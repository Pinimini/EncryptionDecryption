package encryptdecrypt;

public class EncryptionEncUnicode implements EncryptionStrategy {
    StringBuilder cipherText = new StringBuilder();

    @Override
    public String encryptionMethod(char[] arraySymbols, int key) {
        for (char symbol :
                arraySymbols) {
            symbol = (char) ((int) symbol + key);
            cipherText.append(symbol);
        }
        return cipherText.toString();
    }

    @Override
    public StringBuilder decryptionMethod(char[] arraySymbols, int key) {
        for (char symbol :
                arraySymbols) {
            symbol = (char) ((int) symbol - key);
            cipherText.append(symbol);
        }
        return cipherText;
    }
}
