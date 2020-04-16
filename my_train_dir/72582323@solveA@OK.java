private void solveA() throws IOException {
    int n = in.nextInt();
    int[] r = in.nextIntArray(n), b = in.nextIntArray(n);
    int good = 0, bad = 0;
    for (int i = 0; i < n; i++) {
        if (r[i] > b[i])
            good++;
        else if (r[i] < b[i])
            bad++;
    }
    out.println(good == 0 ? -1 : bad / good + 1);
}