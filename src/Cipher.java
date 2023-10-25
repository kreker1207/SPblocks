public class Cipher {
    private static final int[] S_BOX = {
            0x6, 0x4, 0xC, 0x5, 0x0, 0x7, 0x2, 0xE, 0x1, 0xF, 0x3, 0xD, 0x8, 0xA, 0x9, 0xB
    };
    private static final int[] P_BOX = {
            3,0,2,4,7,5,1,6
    };

    public static int sBoxTransformation(int input) {
        is8bit(input);
        int t1 = (input >> 4) & 0xF;
        int t2 = input & 0xF;
        int s1 = S_BOX[t1];
        int s2 = S_BOX[t2];
        return (s1 << 4) | s2;
    }

    public static int pBoxTransformation(int input) {
        is8bit(input);
        int output = 0;
        for (int i = 0; i < 8; i++) {
            int bit = (input >> i) & 0x1;
            output |= (bit << P_BOX[i]);
        }
        return output;
    }

    public static int reverseSBoxTransformation(int input) {
        is8bit(input);
        int t1 = (input >> 4) & 0xF;
        int t2 = input & 0xF;
        int s1 = reverseLookup(S_BOX, t1);
        int s2 = reverseLookup(S_BOX, t2);
        return (s1 << 4) | s2;
    }

    public static int reversePBoxTransformation(int input) {
        is8bit(input);
        int output = 0;
        for (int i = 0; i < 8; i++) {
            int bit = (input >> P_BOX[i]) & 0x1;
            output |= (bit << i);
        }
        return output;
    }

    static int reverseLookup(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }

        throw new IllegalArgumentException("Value not found in the array.");
    }
    private static void is8bit(int input){
        if (input < 0 || input > 255) {
            throw new IllegalArgumentException("Input must be an 8-bit value (between 0 and 255).");
        }
    }
}