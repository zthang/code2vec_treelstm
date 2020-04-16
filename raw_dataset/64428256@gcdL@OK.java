/**
 * * LIBRARIES ***
 */
public static long gcdL(long a, long b) {
    while (b != 0) {
        long tmp = b;
        b = (a % b);
        a = tmp;
    }
    return a;
}