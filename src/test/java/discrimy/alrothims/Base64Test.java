package discrimy.alrothims;

import discrimy.concepts.base64.Base64;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Base64Test {
    @Test
    void name() {
//        From https://stackoverflow.com/questions/12069598/is-there-a-dataset-available-to-fully-test-a-base64-encode-decoder
        assertEquals("", Base64.encode("".getBytes()));
        assertEquals("Zg==", Base64.encode("f".getBytes()));
        assertEquals("Zm8=", Base64.encode("fo".getBytes()));
        assertEquals("Zm9v", Base64.encode("foo".getBytes()));
        assertEquals("Zm9vYg==", Base64.encode("foob".getBytes()));
        assertEquals("Zm9vYmE=", Base64.encode("fooba".getBytes()));
        assertEquals("Zm9vYmFy", Base64.encode("foobar".getBytes()));
    }
}
