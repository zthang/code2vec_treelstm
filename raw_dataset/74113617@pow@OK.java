public long pow(int x, int n) {
    if (n == 0 || n == 1)
        return n == 0 ? 1 : x;
    long res = powMOD(x, n / 2);
    return n % 2 == 0 ? res * res : x * res * res;
}