static void solve() {
    int n = in.nextInt();
    char[] s = in.next().toCharArray();
    int cnt = n;
    int[] ans1 = new int[n];
    for (int i = 0; i < n; i++) {
        ans1[i] = cnt--;
    }
    for (int i = 0; i < n - 1; i++) {
        if (s[i] == '<') {
            int j = i;
            while (j < n - 1 && s[j] == '<') j++;
            reverse(ans1, i, j);
            i = j;
        }
    }
    cnt = 1;
    int[] ans2 = new int[n];
    for (int i = 0; i < n - 1; i++) {
        if (s[i] == '<') {
            ans2[i] = cnt++;
        }
    }
    ans2[n - 1] = cnt++;
    for (int i = n - 2; i >= 0; i--) {
        if (s[i] == '>') {
            ans2[i] = cnt++;
        }
    }
    for (int a : ans1) {
        out.print(a + " ");
    }
    out.println();
    for (int a : ans2) {
        out.print(a + " ");
    }
    out.println();
}