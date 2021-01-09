package encryptdecrypt;

public class EncryptionEncShift implements EncryptionStrategy {
    StringBuilder cipherText = new StringBuilder();

    @Override
    public String encryptionMethod(char[] arraySymbols, int key) {
        for (char symbol :
                arraySymbols) {
            if (symbol >= 'a' && symbol <= 'z' || symbol >= 'A' && symbol <= 'Z') {
                symbol = (char) ((int) symbol + key);
                while (symbol > 'Z' && symbol < 'a' || symbol > 'z') {
                    symbol = (char) ((int) symbol - 26);
                }
                cipherText.append(symbol);
            } else {
                cipherText.append(symbol);
            }
        }
        return cipherText.toString();
    }

    @Override
    public StringBuilder decryptionMethod(char[] arraySymbols, int key) {
        for (char symbol :
                arraySymbols) {
            if (!String.valueOf(symbol).matches("[ !?.]")) {
                symbol = (char) ((int) symbol - key);
                while (symbol > 'a' - key && symbol < 'a' || symbol < 'A') {
                    symbol = (char) ((int) symbol + 26);
                }

                cipherText.append(symbol);
            } else {
                cipherText.append(symbol);
            }
        }
        return cipherText;
    }
}