public static long modInverse(long A, long M) {
    return modularExponentiation(A, M - 2, M);
}