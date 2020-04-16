/*
	 * dp[0]-first red and then blue
	 * dp[1]-first blue and then red
	 * dp[2]-first blue and then green-
	 * dp[3]-first green and then blue-
	 * dp[4]-first green and then red-
	 * dp[5]-first red and then green-
	 * */
public static long dfs2(int current, int parent, long[] dp) {
    long[] dp2 = new long[6];
    long red = colors[0][current];
    long blue = colors[1][current];
    long green = colors[2][current];
    if (pointer == 1 || pointer == 0) {
        dp2[0] = dp[4] + blue;
        dp2[1] = dp[3] + red;
        dp2[2] = dp[0] + green;
        dp2[3] = dp[5] + blue;
        dp2[4] = dp[2] + red;
        dp2[5] = dp[1] + green;
    } else {
        // red - 2 and 3
        dp2[4] = dp[2] + red;
        dp2[1] = dp[3] + red;
        // blue - 4 and 5
        dp2[0] = dp[4] + blue;
        dp2[3] = dp[5] + blue;
        // green - 0 and 1
        dp2[2] = dp[0] + green;
        dp2[5] = dp[1] + green;
    }
    long min2 = Long.MAX_VALUE;
    arr[pointer++] = current;
    for (Integer x : adj[current]) {
        if (x != parent) {
            min2 = Long.min(min2, dfs2(x, current, dp2));
        }
    }
    // red - 1 and blue - 2 and green - 3
    if (adj[current].size() == 1 && adj[current].iterator().next() == parent) {
        long min = Long.MAX_VALUE;
        int pos = -1;
        for (int i = 0; i < 6; i++) {
            if (min > dp2[i]) {
                min = dp2[i];
                pos = i;
            }
        }
        if (pos == 0) {
            color[pointer - 1] = 2;
            color[pointer - 2] = 1;
        } else if (pos == 1) {
            color[pointer - 1] = 1;
            color[pointer - 2] = 2;
        } else if (pos == 2) {
            color[pointer - 1] = 3;
            color[pointer - 2] = 2;
        } else if (pos == 3) {
            color[pointer - 1] = 2;
            color[pointer - 2] = 3;
        } else if (pos == 4) {
            color[pointer - 1] = 1;
            color[pointer - 2] = 3;
        } else if (pos == 5) {
            color[pointer - 1] = 3;
            color[pointer - 2] = 1;
        }
        return min;
    }
    return min2;
}