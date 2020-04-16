public void add(int x) {
    for (; x < sum.length; x = (x | (x + 1))) {
        sum[x]++;
    }
}