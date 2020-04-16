void sort(int[] x) {
    int sz = x.length;
    Random r = new Random();
    for (int i = 0; i < sz; i++) {
        int j = r.nextInt(sz);
        x[i] = x[i] + x[j] - (x[j] = x[i]);
    }
    Arrays.sort(x);
}