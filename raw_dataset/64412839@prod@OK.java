public static int prod(int... vals) {
    int result = 1;
    for (int v : vals) {
        result *= v;
    }
    return result;
}