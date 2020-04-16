public int countFactor(int n, int x) {
    return n <= 0 ? 0 : (n / x + countFactor(n / x, x));
}