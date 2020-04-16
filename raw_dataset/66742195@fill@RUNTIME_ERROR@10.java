  static long fill(int idx, int p) {
    // System.out.println(idx + " " + p);
    // if (idx < 0 || idx >= n) return INF;
    // if (vis[idx]) return INF;
    vis[idx] = true;
    if (dp[idx][p] != 0) return dp[idx][p];
    if (idx + a[idx] < n && (a[idx + a[idx]] % 2 == p)) return 1l;
    if (idx - a[idx] >= 0 && (a[idx - a[idx]] % 2 == p)) return 1l;
    long left = INF, right = INF;
    if (idx + a[idx] < n && (a[idx + a[idx]] % 2 != p)) {right = 1 + fill(idx + a[idx], p);}
    if (idx - a[idx] >= 0  && (a[idx - a[idx]] % 2 != p)) {left = 1 + fill(idx - a[idx], p);}
    dp[idx][p] = Math.min(left, right);
    vis[idx] = false;
    return dp[idx][p];

  }  