public void solve(int testNumber, InputReader in, PrintWriter out) {
    int N = in.nextInt();
    DisjointSet al = new DisjointSet(26);
    boolean[] seen = new boolean[26];
    for (int i = 0; i < N; i++) {
        char[] s = in.next().toCharArray();
        for (int j = 0; j < s.length; j++) {
            seen[s[j] - 'a'] = true;
            if (j > 0) {
                al.merge(s[j - 1] - 'a', s[j] - 'a');
            }
        }
    }
    boolean[] done = new boolean[26];
    long res = 0;
    for (int i = 0; i < 26; i++) {
        if (!done[al.find(i)] && seen[al.find(i)]) {
            res++;
            done[al.find(i)] = true;
        }
    }
    out.println(res);
}