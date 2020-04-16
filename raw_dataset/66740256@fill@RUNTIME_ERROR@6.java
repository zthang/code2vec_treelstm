  static int fill(int idx, int p) {
    if (dp[idx][p] != 0) return dp[idx][p];
    if (idx + a[idx] < n && (a[idx + a[idx]] % 2 == p)) return 1;
    if (idx - a[idx] >= 0 && (a[idx - a[idx]] % 2 == p)) return 1;
    int left = INF, right = INF;
    if (idx + a[idx] < n && (a[idx + a[idx]] % 2 != p)) {right = 1 + fill(idx + a[idx], p);}
    if (idx - a[idx] >= 0 && (a[idx - a[idx]] % 2 != p)) {left = 1 + fill(idx - a[idx], p);}
    dp[idx][p] = Math.min(left, right);
    return dp[idx][p];

  }  