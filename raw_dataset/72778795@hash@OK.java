static long hash(TreeSet<Integer> set) {
    long h = 0;
    for (int i : set) {
        h = (h + pow(i + 1, 37)) % MOD;
    }
    return h;
}