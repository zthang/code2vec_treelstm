public static void dfs(int x, int color1, int color2, long sum) {
    if (du[x] == 1 && x != root) {
        int aa = Integer.MAX_VALUE;
        for (int i = 1; i <= 3; i++) {
            if (i != color1 && i != color2) {
                if (cost[i][x] < aa) {
                    aa = cost[i][x];
                    temp[x] = i;
                }
            }
        }
        if (sum + aa < ans) {
            ans = sum + aa;
            list = temp.clone();
        // System.out.println(x+" "+temp[x]+" "+ans);
        }
    } else {
        for (int i = 1; i <= 3; i++) {
            if (i != color1 && i != color2 && sum + cost[i][x] < ans) {
                for (int j = 0; j < E[x].size(); j++) {
                    int next = E[x].get(j);
                    if (!vis[next]) {
                        // System.out.println(x+" "+i+" "+(sum+cost[i][x]));
                        temp[x] = i;
                        vis[next] = true;
                        dfs(next, color2, i, sum + cost[i][x]);
                        vis[next] = false;
                    }
                }
            }
        }
    }
}