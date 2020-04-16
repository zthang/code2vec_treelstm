long getP(int n, int r) {
    resize(n);
    return mul(factorialCache.get(n), factorialInverseCache.get(n - r));
}