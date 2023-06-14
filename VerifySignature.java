

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class VerifySignatureUtil {

    public static PublicKey decodePublicKey(String pubKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] bytes = Base64.getDecoder().decode(pubKey.getBytes());
        return KeyFactory.getInstance("DSA").generatePublic(new X509EncodedKeySpec(bytes));

    }

    public static byte[] decodeSignature(String sig){
        return Base64.getDecoder().decode(sig.getBytes());

    }

    public static boolean verifySignature(String message, byte[] signature, PublicKey publicKey) throws SignatureException, InvalidKeyException, NoSuchAlgorithmException {
        Signature signature1 = Signature.getInstance("SHA256withDSA");
        signature1.initVerify(publicKey);
        signature1.update(message.getBytes());
        return signature1.verify(signature);
    }
}
