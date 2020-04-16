private ArrayList<Integer> dfs(int node, boolean[] vis) {
    vis[node] = true;
    ArrayList<Integer> list = new ArrayList<>();
    for (int nn : graph[node]) {
        if (!vis[nn]) {
            ArrayList<Integer> l = dfs(nn, vis);
            if (!f)
                return null;
            for (int i = 0; i < l.size(); ) {
                if (list.size() == B[node]) {
                    list.add(node);
                } else {
                    list.add(l.get(i++));
                }
            }
        }
    }
    if (list.size() == B[node]) {
        list.add(node);
    } else if (list.size() < B[node]) {
        f = false;
        return null;
    }
    return list;
}