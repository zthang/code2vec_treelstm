static int min(int... as) {
    int min = Integer.MAX_VALUE;
    for (int a : as) min = Math.min(a, min);
    return min;
}