static void solve() {
    int n = in.nextInt();
    char[] s = in.next().toCharArray();
    int[] ans1 = new int[n];
    int cnt = 1;
    // }
    for (int i = n - 2; i >= 0; i--) {
        if (s[i] == '>') {
            ans1[i + 1] = cnt++;
            int j = i + 1;
            while (j < n - 1 && s[j] == '<') {
                ans1[j + 1] = cnt++;
                j++;
            }
        }
    }
    ans1[0] = cnt++;
    for (int i = 0; i < n - 1 && s[i] == '<'; i++) {
        ans1[i + 1] = cnt++;
    }
    int[] ans2 = new int[n];
    cnt = 1;
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