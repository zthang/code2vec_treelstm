public void add(int x, int d) {
    for (int i = x; i < sum.length; i = (i | (i + 1))) {
        sum[i] += d;
    }
}