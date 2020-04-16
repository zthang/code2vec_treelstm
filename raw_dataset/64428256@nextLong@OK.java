/**
 * *********** FAST IO CODE FOLLOWS ****************
 */
public static long nextLong() throws Throwable {
    long i = System.in.read();
    boolean neg = false;
    while (i < 33) i = System.in.read();
    if (i == 45) {
        neg = true;
        i = 48;
    }
    i = i - 48;
    int j = System.in.read();
    while (j > 32) {
        i *= 10;
        i += j - 48;
        j = System.in.read();
    }
    return (neg) ? -i : i;
}