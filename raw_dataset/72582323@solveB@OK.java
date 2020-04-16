private void solveB() throws IOException {
    int n = in.nextInt();
    long[] b = in.nextLongArray(n);
    TreeMap<Long, Long> map = new TreeMap<>();
    for (int i = 0; i < n; i++) map.put(b[i] - i, map.getOrDefault(b[i] - i, 0L) + b[i]);
    out.println(max(map.values()));
}