private void inititalise(int n) {
    disjointArray = new int[n + 1];
    size = new int[n + 1];
    Arrays.fill(size, 1);
    for (int i = 0; i <= n; i++) disjointArray[i] = i;
}