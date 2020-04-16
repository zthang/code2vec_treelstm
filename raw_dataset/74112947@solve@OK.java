public void solve(int testNumber, InputReader in, PrintWriter out) {
    int T = in.nextInt();
    while (T-- > 0) {
        int N = in.nextInt();
        int[] p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = in.nextInt() - 1;
        }
        ArrayList<ArrayList<Integer>> cycles = apply(p);
        int[] col = new int[N];
        for (int i = 0; i < N; i++) {
            col[i] = in.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for (ArrayList<Integer> cycle : cycles) {
            min = Math.min(min, min(cycle, col));
        }
        out.println(min);
    }
}