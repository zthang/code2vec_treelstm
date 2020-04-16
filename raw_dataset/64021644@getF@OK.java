long getF(int n) {
    resize(n);
    return factorialCache.get(n);
}