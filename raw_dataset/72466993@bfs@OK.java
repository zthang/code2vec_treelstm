void bfs(LinkedList<pair<Integer, Integer>> l) {
    while (!l.isEmpty()) {
        pair<Integer, Integer> cur = l.poll();
        if (cur.x + 1 < n && !vis[cur.x + 1][cur.y] && p[cur.x + 1][cur.y].equals(par)) {
            ans[cur.x + 1][cur.y] = 'U';
            vis[cur.x + 1][cur.y] = true;
            l.add(new pair<>(cur.x + 1, cur.y));
        }
        if (cur.x - 1 >= 0 && !vis[cur.x - 1][cur.y] && p[cur.x - 1][cur.y].equals(par)) {
            ans[cur.x - 1][cur.y] = 'D';
            vis[cur.x - 1][cur.y] = true;
            l.add(new pair<>(cur.x - 1, cur.y));
        }
        if (cur.y + 1 < n && !vis[cur.x][cur.y + 1] && p[cur.x][cur.y + 1].equals(par)) {
            ans[cur.x][cur.y + 1] = 'L';
            vis[cur.x][cur.y + 1] = true;
            l.add(new pair<>(cur.x, cur.y + 1));
        }
        if (cur.y - 1 >= 0 && !vis[cur.x][cur.y - 1] && p[cur.x][cur.y - 1].equals(par)) {
            ans[cur.x][cur.y - 1] = 'R';
            vis[cur.x][cur.y - 1] = true;
            l.add(new pair<>(cur.x, cur.y - 1));
        }
    }
}