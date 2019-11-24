package discrimy.concepts.jwt;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;
import java.util.stream.Collectors;

public class JwtService {
    private Mac hashAlgorithm;
    private SecretKeySpec secretKeySpec;

    public JwtService(byte[] secret, String algorithm) throws NoSuchAlgorithmException, InvalidKeyException {
        hashAlgorithm = Mac.getInstance(algorithm);
        secretKeySpec = new SecretKeySpec(secret, algorithm);
        hashAlgorithm.init(secretKeySpec);
    }

    public String toJwt(Map<String, String> payload) {
        String payloadBase64 = Base64.getEncoder().encodeToString(
                ("{" +
                        payload.entrySet().stream()
                                .sorted()
                                .map(entry -> String.format("\"%s\":\"%s\"", entry.getKey(), entry.getValue()))
                                .collect(Collectors.joining(","))
                        + "}").getBytes());
        String headerBase64 = Base64.getEncoder().encodeToString("{\"alg\":\"HS256\",\"typ\":\"JWT\"}".getBytes());
        byte[] verifySignature = hashAlgorithm.doFinal((headerBase64 + "." + payloadBase64).getBytes());
        String verifySignatureBase64 = Base64.getEncoder().encodeToString(verifySignature);

        return headerBase64 + "." + payloadBase64 + "." + verifySignatureBase64;
    }

    public boolean verify(String jwt) {
        try {
            String[] jwtParts = jwt.split("\\.");
            String headerBase64 = jwtParts[0];
            String payloadBase64 = jwtParts[1];

            byte[] verifySignature = hashAlgorithm.doFinal((headerBase64 + "." + payloadBase64).getBytes());
            String verifySignatureBase64 = Base64.getEncoder().encodeToString(verifySignature);
            return verifySignatureBase64.equals(jwtParts[2]);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
}
