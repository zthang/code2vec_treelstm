static int max(int... as) {
    int max = Integer.MIN_VALUE;
    for (int a : as) max = Math.max(a, max);
    return max;
}