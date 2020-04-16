public static void solve(int idx) {
    if (idx == r.length - 2)
        return;
    int min = (int) 1e9;
    int rep = 0;
    for (int x : adjList[r[idx]]) {
        if (dist[x] < min) {
            min = dist[x];
            rep = 1;
        } else if (dist[x] == min) {
            rep++;
        }
    }
    if (dist[r[idx + 1]] > min) {
        max++;
        mini++;
    } else if (dist[r[idx + 1]] == min) {
        if (rep > 1) {
            max++;
        }
    }
    solve(idx + 1);
}