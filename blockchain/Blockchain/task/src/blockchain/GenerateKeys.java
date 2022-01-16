package blockchain;


import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class GenerateKeys {
    private static final GenerateKeys GENERATE_KEYS = create(2048);
    private final KeyPairGenerator keyGen;

    private GenerateKeys(int keylength) throws NoSuchAlgorithmException {
        this.keyGen = KeyPairGenerator.getInstance("RSA");
        this.keyGen.initialize(keylength);
    }

    public static GenerateKeys create(int keylength) {
        try {
            return new GenerateKeys(keylength);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    public static KeyPair generate() {
        return GENERATE_KEYS.createKeys();
    }

    public KeyPair createKeys() {
        return this.keyGen.generateKeyPair();
    }
}
