    int solve(int i) {
      if (memo[i] != -1) {
        return memo[i];
      }
      if (i + arr[i] < n && (arr[i] & 1) != ((arr[i + arr[i]]) & 1)) {
        return memo[i] = 1;
      } else if (i - arr[i] >= 0 && (arr[i] & 1) != ((arr[i - arr[i]]) & 1)) {
        return memo[i] = 1;
      } else if (i + arr[i] < n || i - arr[i] >= 0) {
        int answer = INF;
        if (i + arr[i] < n) {
          answer = Math.min(answer, 1 + solve(i + arr[i]));
        }
        if (i - arr[i] >= 0) {
          answer = Math.min(answer, 1 + solve(i - arr[i]));
        }
        return memo[i] = answer;
      } else {
        return memo[i] = INF;
      }
    }