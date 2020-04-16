static long moduloInverse(long number, long mod) {
    return modPower(number, mod - 2, mod);
}