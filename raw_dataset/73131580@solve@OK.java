void solve() {
    int N = ni();
    int M = ni();
    int[] a = na(N);
    int[] b = na(N);
    char[] ans = new char[N];
    char c = 'a' - 1;
    HashSet<Integer> s = new HashSet<Integer>();
    for (int i = 0; i < N; i++) {
        if (s.isEmpty() && c < 'z')
            c++;
        if (!s.add(a[i]))
            s.remove(a[i]);
        if (!s.add(b[i]))
            s.remove(b[i]);
        ans[a[i] - 1] = ans[b[i] - 1] = c;
    }
    if (c - 'a' + 1 >= M) {
        out.println(YES);
        out.println(new String(ans));
    } else
        out.println(NO);
}