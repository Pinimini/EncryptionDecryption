package encryptdecrypt;

public class EncryptionContext {
    EncryptionStrategy strategy;

    public void setStrategy(EncryptionStrategy strategy) {
        this.strategy = strategy;
    }

    public String doSomethingEnc(char[] arraySymbols, int key) {
        return strategy.encryptionMethod(arraySymbols, key);
    }

    public StringBuilder doSomethingDec(char[] arraySymbols, int key) {
        return strategy.decryptionMethod(arraySymbols, key);
    }
}
