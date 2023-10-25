import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CipherTest {
    @Test
    public void testSBoxTransformation() {
        assertEquals(0x8A, Cipher.sBoxTransformation(0XCD));
        assertEquals(0xB9, Cipher.sBoxTransformation(0xFE));
    }

    @Test
    public void testPBoxTransformation() {
        assertEquals(0x6A, Cipher.pBoxTransformation(0xE1));
        assertEquals(0x18, Cipher.pBoxTransformation(0x9));
    }

    @Test
    public void testReverseSBoxTransformation() {
        assertEquals(0XCD, Cipher.reverseSBoxTransformation(0X8A));
        assertEquals(0xB4, Cipher.sBoxTransformation(0xF1));
    }

    @Test
    public void testReversePBoxTransformation() {
        assertEquals(0xE1, Cipher.reversePBoxTransformation(0x6A));
        assertEquals(0x7B, Cipher.reversePBoxTransformation(0xBB));
    }
    @Test
    public void testLengthError(){
        assertThrows(IllegalArgumentException.class,()->{Cipher.pBoxTransformation(0XABC);});
    }
    @Test
    public void testWorkFlow() {
        assertEquals(0x8A, Cipher.sBoxTransformation(0XCD));
        assertEquals(0X51,Cipher.pBoxTransformation(0X8A));
        assertEquals(0X8A,Cipher.reversePBoxTransformation(0X51));
        assertEquals(0XCD, Cipher.reverseSBoxTransformation(0X8A));

    }
}
