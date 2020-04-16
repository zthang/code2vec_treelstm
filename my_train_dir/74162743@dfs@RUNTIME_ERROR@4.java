    void dfs(int s) {
        if(ans[s][1 - (a[s] & 1)] != inf)   return;
        if(s + a[s] < n) {
            dfs(s + a[s]);
            if(ans[s + a[s]][1 - (a[s] & 1)] != -1) ans[s][1 - (a[s] & 1)] = ans[s + a[s]][1 - (a[s] & 1)] + 1;
        }
        if(s - a[s] >= 0) {
            dfs(s - a[s]);
            if(ans[s - a[s]][1 - (a[s] & 1)] != -1) 
                ans[s][1 - (a[s] & 1)] = Math.min(ans[s][1 - (a[s] & 1)], ans[s - a[s]][1 - (a[s] & 1)] + 1);
        }
        if(ans[s][1 - (a[s] & 1)] == inf) ans[s][1 - (a[s] & 1)] = -1;
    }