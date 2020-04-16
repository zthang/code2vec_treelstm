void solve() {
    DJSet ds = new DJSet(26);
    boolean[] ved = new boolean[26];
    int n = ni();
    for (int i = 0; i < n; i++) {
        char[] s = ns().toCharArray();
        char prev = ' ';
        for (int j = 0; j < s.length; j++) {
            ved[s[j] - 'a'] = true;
            if (j != 0)
                ds.union(prev - 'a', s[j] - 'a');
            prev = s[j];
        }
    }
    int ct = 0;
    for (int j = 0; j < ds.upper.length; j++) {
        if (ds.upper[j] < 0 && ved[j])
            ct++;
    }
    out.println(ct);
}