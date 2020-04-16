public static long modularExponentiation(long x, long n, long M) {
    long result = 1;
    while (n > 0) {
        if (n % 2 == 1)
            result = (result % M * x % M) % M;
        x = (x % M * x % M) % M;
        n = n / 2;
    }
    return result;
}