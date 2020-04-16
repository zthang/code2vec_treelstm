public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
    int t = 1;
    while (t-- > 0) {
        dsu = new int[26];
        boolean[] used = new boolean[26];
        Arrays.fill(dsu, -1);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            char[] a = in.nextLine().toCharArray();
            int l = a.length;
            for (int j = 0; j < l; j++) {
                int x = a[j] - 'a';
                // System.out.println("x:"+x);
                used[x] = true;
                if (j > 0) {
                    int y = a[0] - 'a';
                    join(x, y);
                }
            }
        }
        int ans = 0;
        for (int a = 0; a < 26; a++) if (used[a] && dsu[a] < 0)
            ans++;
        out.println(ans);
    }
}