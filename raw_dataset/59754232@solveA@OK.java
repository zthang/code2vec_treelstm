private void solveA() throws IOException {
    int n = in.nextInt(), k = 0;
    for (int i = 0; i < n; i++) if ((in.nextInt() & 1) == 0)
        k++;
    out.println(min(k, n - k));
}