private void solveD() throws IOException {
    testId++;
    int n = in.nextInt();
    char[][] s = new char[n][];
    int[][] cnt = new int[2][2];
    for (int i = 0; i < n; i++) {
        s[i] = in.next().toCharArray();
        cnt[s[i][0] - '0'][s[i][s[i].length - 1] - '0']++;
    }
    if (cnt[0][0] > 0 && cnt[1][1] > 0 && cnt[0][1] + cnt[1][0] == 0) {
        out.println(-1);
        return;
    }
    for (int i = 0; i < n; i++) {
        if (s[i][0] != s[i][s[i].length - 1] && cnt[s[i][s[i].length - 1] - '0'][s[i][0] - '0'] - cnt[s[i][0] - '0'][s[i][s[i].length - 1] - '0'] > 1) {
            borAdd(s[i]);
        }
    }
    ArrayList<Integer> ans = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        if (s[i][0] != s[i][s[i].length - 1] && cnt[s[i][0] - '0'][s[i][s[i].length - 1] - '0'] - cnt[s[i][s[i].length - 1] - '0'][s[i][0] - '0'] > 1) {
            if (!borFind(new StringBuilder(new String(s[i])).reverse().toString().toCharArray())) {
                cnt[s[i][0] - '0'][s[i][s[i].length - 1] - '0']--;
                cnt[s[i][s[i].length - 1] - '0'][s[i][0] - '0']++;
                ans.add(i);
            }
        }
    }
    if (abs(cnt[0][1] - cnt[1][0]) > 1) {
        out.println(-1);
        return;
    }
    out.println(ans.size());
    for (int i : ans) out.print(i + 1 + " ");
    out.println();
}