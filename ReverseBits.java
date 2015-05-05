/**
 * Created by yhf on 15/5/5.
 */

/*
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer
*/

public class ReverseBits {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            n = swapBits(n, i);
        }
        return n;
    }

    public static int swapBits(int n, int i) {
        int x = (n >> i) & 1;
        int y = (n >> (31 - i)) & 1;
        if (x != y) {
            n ^= (1 << (31 - i)) | (1 << i);
        }
        return n;
    }

    public static void main(String[] args) {
        int n = 43261596;
        n = reverseBits(n);
    }
}
