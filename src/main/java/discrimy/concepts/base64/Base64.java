package discrimy.concepts.base64;

public class Base64 {
    /**
     * Base64 implementation
     */
    private static final String BASE64_CODES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    /**
     * Encode array of bytes to base64 string
     *
     * @param src source
     * @return base64 string
     */
    public static String encode(byte[] src) {
        StringBuilder builder = new StringBuilder();
        int iters = src.length % 3 == 0 ? src.length / 3 : src.length / 3 + 1;
        for (int i = 0; i < iters; i++) {
            byte[] buf = new byte[3];
            buf[0] = src[3 * i];
            buf[1] = 3 * i + 1 < src.length ? src[3 * i + 1] : 0;
            buf[2] = 3 * i + 2 < src.length ? src[3 * i + 2] : 0;

            builder.append(bufToChars(buf));
        }
        return builder.toString();
    }

    private static char[] bufToChars(byte[] buf) {
        char[] chars = new char[4];
//      11111100 00000000 00000000
        byte index0 = (byte) ((buf[0] & 0b11111100) >> 2);
//      00000011 11110000 00000000
        byte index1 = (byte) ((((buf[0] & 0b00000011) << 6) | ((buf[1] & 0b11110000) >> 2)) >> 2);
//      00000000 00001111 11000000
        byte index2 = (byte) ((((buf[1] & 0b00001111) << 4) | ((buf[2] & 0b11000000) >> 4)) >> 2);
//      00000000 00000000 00111111
        byte index3 = (byte) (buf[2] & 0b00111111);
        chars[0] = BASE64_CODES.charAt(index0);
        chars[1] = BASE64_CODES.charAt(index1);
        chars[2] = index2 != 0 ? BASE64_CODES.charAt(index2) : '=';
        chars[3] = index3 != 0 ? BASE64_CODES.charAt(index3) : '=';
        return chars;
    }
}
