public static int log(long x) {
    int c = 0;
    while (x > 0) {
        if (x % 2 != 0)
            return c;
        x /= 2;
        c++;
    }
    c--;
    return c;
}