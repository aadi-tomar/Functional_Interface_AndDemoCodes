

import java.security.*;
import java.util.Base64;

public class CreateSignatureUtil {

    private KeyPairGenerator keyPairGenerator;
    private KeyPair keyPair;
    private PublicKey publicKey;
    private PrivateKey privateKey;
    private Signature signature;

    public CreateSignatureUtil() throws NoSuchAlgorithmException {
        this.keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        this.keyPairGenerator.initialize(2048);
        this.keyPair = keyPairGenerator.generateKeyPair();

        this.signature = Signature.getInstance("SHA256withDSA");
    }

    public PrivateKey getPrivateKey(){
        return keyPair.getPrivate();
    }

    public PublicKey getPublicKey(){
        return keyPair.getPublic();
    }

    public byte[] generateSignature(String message) throws SignatureException, InvalidKeyException {
        signature.initSign(getPrivateKey());
        signature.update(message.getBytes());
        return signature.sign();
    }

    public String encodeSignature(byte[] signature){
        return Base64.getEncoder().encodeToString(signature);
    }

    public String encodePublicKey(PublicKey publicKey){
        return Base64.getEncoder().encodeToString(getPublicKey().getEncoded());
    }


}
