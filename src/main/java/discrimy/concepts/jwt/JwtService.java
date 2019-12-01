package discrimy.concepts.jwt;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;
import java.util.stream.Collectors;


public class JwtService {
    /**
     * Implementation of JWT generate and verify functionality
     * Created based on jwt.io specs
     */
    private Mac hashAlgorithm;
    private SecretKeySpec secretKeySpec;

    /**
     * @param secret    array of bytes, representing server secret
     * @param algorithm name of MAC algorithm (HmacSHA256 for example)
     * @throws NoSuchAlgorithmException throws if given algorithm do not supported
     * @throws InvalidKeyException      throws if secret is invalid
     */
    public JwtService(byte[] secret, String algorithm) throws NoSuchAlgorithmException, InvalidKeyException {
        hashAlgorithm = Mac.getInstance(algorithm);
        secretKeySpec = new SecretKeySpec(secret, algorithm);
        hashAlgorithm.init(secretKeySpec);
    }

    /**
     * Creates JWT from given payload
     * @param payload map representing JSON object (no nested elements)
     * @return string representing JWT
     */
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

    /**
     * @param jwt string representing JWT
     * @return is JWT valid (checks with service's secret)
     */
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
