void solve() {
    StringBuffer sb = new StringBuffer();
    int t = ni();
    while (t-- > 0) {
        int n = ni();
        int m = ni();
        int ans = 0;
        for (int i = 0; i < n; i++) ans += ni();
        if (n == 2 || n > m)
            sb.append(-1);
        else {
            sb.append(2 * ans).append(System.lineSeparator());
            for (int i = 0; i < n - 1; i++) sb.append(i + 1).append(' ').append(i + 2).append(System.lineSeparator());
            sb.append(1).append(' ').append(n);
        }
        sb.append(System.lineSeparator());
    }
    System.out.println(sb);
}