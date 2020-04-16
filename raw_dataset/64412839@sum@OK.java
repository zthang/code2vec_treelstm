public static int sum(int... vals) {
    int result = 0;
    for (int v : vals) {
        result += v;
    }
    return result;
}