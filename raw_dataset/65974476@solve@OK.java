public void solve(int testNumber, ScanReader in, PrintWriter out) {
    int n = in.scanInt();
    p[] ar = new p[n];
    for (int i = 0; i < n; i++) {
        int mask = 0;
        String s = in.scanString();
        for (char c : s.toCharArray()) {
            mask |= (1 << (c - 'a'));
        }
        ar[i] = new p(mask);
    }
    Random rd = new Random();
    for (int i = 0; i < n; i++) {
        int index = rd.nextInt(n);
        p temp = ar[index];
        ar[index] = ar[i];
        ar[i] = temp;
    }
    Arrays.sort(ar);
    done = new boolean[1 << 26];
    int ans = 0;
    for (int i = 0; i < n; i++) {
        if (!done[ar[i].mask]) {
            ans++;
            dfs(ar[i].mask);
        }
    }
    out.println(ans);
}