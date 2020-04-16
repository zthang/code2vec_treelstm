        void dfs(pair<Integer, Integer> cur) {
            vis[cur.x][cur.y] = true;
            if (cur.x + 1 < n && !vis[cur.x + 1][cur.y] && p[cur.x + 1][cur.y].equals(par)) {
                ans[cur.x + 1][cur.y] = 'U';
                dfs(new pair<>(cur.x + 1, cur.y));
            }
            if (cur.x - 1 >= 0 && !vis[cur.x - 1][cur.y] && p[cur.x - 1][cur.y].equals(par)) {
                ans[cur.x - 1][cur.y] = 'D';
                dfs(new pair<>(cur.x - 1, cur.y));
            }
            if (cur.y + 1 < n && !vis[cur.x][cur.y + 1] && p[cur.x][cur.y + 1].equals(par)) {
                ans[cur.x][cur.y + 1] = 'L';
                dfs(new pair<>(cur.x, cur.y + 1));
            }
            if (cur.y - 1 >= 0 && !vis[cur.x][cur.y - 1] && p[cur.x][cur.y - 1].equals(par)) {
                ans[cur.x][cur.y - 1] = 'R';
                dfs(new pair<>(cur.x, cur.y - 1));
            }
        }