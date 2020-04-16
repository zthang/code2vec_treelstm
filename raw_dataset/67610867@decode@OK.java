static void decode(long x) {
    Y = (int) (x % (n + 1));
    X = (int) (x / (n + 1));
}