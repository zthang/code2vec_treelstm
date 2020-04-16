public void solve(int testNumber, InputReader in, PrintWriter out) {
    ArrayList<Integer> primes = new ArrayList<>();
    MathUtils.getPrimes(primes, 5000);
    Arrays.fill(max, -1);
    for (int i = 2; i <= 5000; i++) {
        int cur = i;
        for (int j = 0; j < primes.size() && i >= primes.get(j); j++) {
            cntPrime[i][j] = cntPrime[i - 1][j];
            while (cur % primes.get(j) == 0) {
                cntPrime[i][j]++;
                cur /= primes.get(j);
            }
            if (cntPrime[i][j] > 0) {
                max[i] = j;
            }
            dist[i] += cntPrime[i][j];
        }
        max[i] = Math.max(max[i], max[i - 1]);
    }
    N = in.nextInt();
    for (int i = 0; i < N; i++) {
        int a = in.nextInt();
        cnt[a]++;
        res += dist[a];
    }
    ArrayList<Integer> arr = new ArrayList<>();
    for (int i = 1; i <= 5000; i++) {
        arr.add(i);
    }
    dfs(699, arr);
    out.println(res);
}