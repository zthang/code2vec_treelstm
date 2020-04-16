public void solve(int testNumber, FastReader s, PrintWriter out) {
    int n = s.nextInt();
    int m = s.nextInt();
    CAnadiAndDomino.Edge[] arr = new CAnadiAndDomino.Edge[m];
    for (int i = 0; i < m; i++) {
        int src = s.nextInt();
        int dest = s.nextInt();
        arr[i] = new CAnadiAndDomino.Edge(Math.min(src, dest), Math.max(src, dest));
    }
    CAnadiAndDomino.ans ans1 = new CAnadiAndDomino.ans(Integer.MIN_VALUE);
    func(1, new HashMap<Integer, Integer>(), n, arr, ans1);
    out.println(ans1.a);
}