public void solve(int testNumber, Scanner in, PrintWriter out) {
    int queries = in.nextInt();
    for (int i = 0; i < queries; i++) {
        int n = in.nextInt();
        int m = in.nextInt();
        long sum = 0;
        List<Integer> weights = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            int x = in.nextInt();
            weights.add(x);
            sum = sum + x;
        }
        if (m < n || m == 2) {
            out.println(-1);
            continue;
        }
        Collections.sort(weights);
        long result = (2 * sum) + ((m - n) * (weights.get(0) + weights.get(1)));
        out.println(result);
        int j;
        for (j = 0; j < n - 1; j++) {
            out.println((j + 1) + " " + (j + 2));
        }
        out.println(1 + " " + n);
    }
}