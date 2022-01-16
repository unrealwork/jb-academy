package blockchain;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public class SecuredMessage {
    private final byte[] data;
    private final Cipher cipher;

    private SecuredMessage(byte[] data, final PublicKey publicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        this.data = data.clone();
        this.cipher = Cipher.getInstance("RSA");
        this.cipher.init(Cipher.DECRYPT_MODE, publicKey);
    }

    public static SecuredMessage fromDataWithKey(byte[] data, final PublicKey publicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        return new SecuredMessage(data, publicKey);
    }

    public String decrypt() {
        try {
            return new String(cipher.doFinal(data), StandardCharsets.UTF_8);
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            throw new IllegalStateException(e);
        }
    }
}
