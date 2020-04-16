private int mod_add(int a, int b) {
    int v = a + b;
    if (v >= MOD)
        v -= MOD;
    return v;
}