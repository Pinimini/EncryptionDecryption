package encryptdecrypt;

public interface EncryptionStrategy {
    String encryptionMethod(char[] arraySymbols, int key);

    StringBuilder decryptionMethod(char[] arraySymbols, int key);
}
