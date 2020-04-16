public int lower(int a, int b) {
    return dep[a] > dep[b] ? a : b;
}