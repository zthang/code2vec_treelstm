public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] weights = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++) {
        weights[i] = in.nextInt();
        sum += weights[i];
    }
    if (m < n || n == 2) {
        out.println(-1);
    } else {
        out.println(sum * 2);
        for (int i = 1; i < n; i++) {
            out.println((i) + " " + (i + 1));
        }
        out.println(n + " " + 1);
    }
}