long getC(int n, int k) {
    resize(n);
    return mul(factorialCache.get(n), mul(factorialInverseCache.get(k), factorialInverseCache.get(n - k)));
}