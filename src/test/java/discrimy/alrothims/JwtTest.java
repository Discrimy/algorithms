package discrimy.alrothims;

import discrimy.concepts.jwt.JwtService;
import org.junit.jupiter.api.Test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class JwtTest {
    public static final String JWT = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiYWRtaW4ifQ==.LZbgNB9SN+cM3Mj+WhEwrV4GCT60Z3xfm9G4LEnzP8s=";
    public static final String SECRET = "secret";
    public static final String ALG = "HmacSHA256";

    @Test
    void create() throws InvalidKeyException, NoSuchAlgorithmException {
        JwtService jwtService = new JwtService(SECRET.getBytes(), ALG);
        assertEquals(
                JWT,
                jwtService.toJwt(Map.of("name", "admin")));
    }

    @Test
    void verify() throws InvalidKeyException, NoSuchAlgorithmException {
        JwtService jwtService = new JwtService("secret".getBytes(), "HmacSHA256");
        assertTrue(jwtService.verify(JWT));
        assertFalse(jwtService.verify("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiYWRtaW5hYSJ9.vqhTvmLAZTN8J-jYfW4uHmEIMCTLAfpSxc1C6oJqanQ"));
        assertFalse(jwtService.verify("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9eyJuYW1lIjoiYWRtaW5hYSJ9.vqhTvmLAZTN8J-jYfW4uHmEIMCTLAfpSxc1C6oJqanQ"));
    }
}
