package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String sourceText = "";
        String encryption_Method = "enc";
        EncryptionContext context = new EncryptionContext();
        context.setStrategy(new EncryptionEncShift());
        int key = 0;
        for (int i = 0; i < args.length; i++) {
            if ("-mode".equals(args[i])) {
                encryption_Method = args[i + 1];
            }
            if ("-alg".equals(args[i])) {
                switch (args[i + 1]) {
                    case ("shift"):
                        context.setStrategy(new EncryptionEncShift());
                        break;
                    case ("unicode"):
                        context.setStrategy(new EncryptionEncUnicode());
                        break;
                }
            }
            if ("-key".equals(args[i])) {
                key = Integer.parseInt(args[i + 1]);
            }
            if ("-data".equals(args[i])) {
                sourceText = args[i + 1];
            }
            if ("-in".equals(args[i])) {
                try {
                    sourceText = new String(Files.readAllBytes(Paths.get(args[i + 1])));
                } catch (IOException e) {
                    System.out.println("Error");
                }
            }
        }

        char[] arraySymbols = sourceText.toCharArray();
        StringBuilder cipherText = new StringBuilder();
        switch (encryption_Method) {
            case ("enc"):
                cipherText.append(context.doSomethingEnc(arraySymbols, key));
                break;
            case ("dec"):
                cipherText = context.doSomethingDec(arraySymbols, key);
                break;
        }

        boolean isExist = false;
        for (int i = 0; i < args.length; i++) {
            if ("-out".equals(args[i])) {
                File files2 = new File(args[i + 1]);
                try (FileWriter wr = new FileWriter(files2)) {
                    wr.append(cipherText);
                } catch (IOException e) {
                    System.out.println("Error");
                }
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println(cipherText);
        }
    }
}
