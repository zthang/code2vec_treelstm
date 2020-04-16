public int dfsU(boolean[] visited, int s) {
    visited[s] = true;
    Iterator<Integer> ir = ar[s].iterator();
    ct = 0;
    while (ir.hasNext()) {
        int x = ir.next();
        if (!visited[x]) {
            ct += dfsU(visited, x);
        }
    }
    if (color[s] == 1)
        ct++;
    else
        ct--;
    if (ct >= 0)
        val[s] = ct;
    else {
        val[s] = -1;
        ct = 0;
    }
    return ct;
}