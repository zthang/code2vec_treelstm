private void solveC() throws IOException {
    long n = in.nextLong(), m = in.nextLong();
    long[] sum = new long[10];
    for (int i = 0; i < 10; i++) sum[i] = ((i == 0 ? 0 : sum[i - 1]) + m) % 10;
    for (int i = 0; i < 10; i++) sum[i] += (i == 0 ? 0 : sum[i - 1]);
    out.println(sum[9] * (n / (m * 10)) + ((n % (m * 10)) / m > 0 ? sum[(int) ((n % (m * 10)) / m) - 1] : 0));
}