public static void preOrder(int node) {
    for (int child : old[node]) {
        if (!vis[child]) {
            vis[child] = true;
            map[child] = mapTo;
            mapTo++;
            preOrder(child);
        }
    }
}