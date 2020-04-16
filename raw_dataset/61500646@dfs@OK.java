void dfs(int a) {
    visited[a] = true;
    Iterator<Integer> it = adj[a].iterator();
    boolean flag = true;
    boolean leaf = true;
    while (it.hasNext()) {
        int x = it.next();
        if (!visited[x]) {
            leaf = false;
            dfs(x);
            if (!color[a]) {
                if (count[x] == 0) {
                    flag = false;
                }
            }
            count[a] += count[x];
        }
    }
    if (color[a]) {
        count[a]++;
    } else {
        if (flag) {
            if (total > count[a] && a != 0) {
                ans.add(a);
            } else if (total == count[a] && (a == 0)) {
                ans.add(a);
            } else if (count[a] == 0 && leaf) {
                ans.add(a);
            }
        }
    }
}