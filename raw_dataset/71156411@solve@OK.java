public void solve(int testNumber, FastReader s, PrintWriter w) {
    int n = s.nextInt();
    char[] c = s.next().toCharArray();
    int[] mn = new int[n], mx = new int[n];
    int cur = 1;
    for (int i = 0; i < n - 1; i++) if (c[i] == '<')
        mx[i] = cur++;
    cur = n;
    for (int i = 0; i < n - 1; i++) if (c[i] == '>')
        mx[i] = cur--;
    mx[n - 1] = cur;
    cur = n;
    int prev = -1;
    for (int i = 0; i < n - 1; i++) if (c[i] == '>')
        mn[i] = cur--;
    for (int i = 0; i < n - 1; i++) {
        if (c[i] == '>') {
            int j = i - 1;
            while (j >= 0 && c[j] == '<') mn[j--] = cur--;
        }
    }
    int j = n - 2;
    mn[n - 1] = cur--;
    while (j >= 0 && c[j] == '<') mn[j--] = cur--;
    for (int i : mn) w.print(i + " ");
    w.println();
    for (int i : mx) w.print(i + " ");
    w.println();
}