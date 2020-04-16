public void dfsUF(boolean[] visited, int s) {
    visited[s] = true;
    Iterator<Integer> ir = ar[s].iterator();
    while (ir.hasNext()) {
        int x = ir.next();
        if (!visited[x]) {
            if (ans[s] <= val[x])
                ans[x] = val[x];
            else if (ans[s] > val[x] && val[x] >= 0)
                ans[x] = ans[s];
            else if (ans[s] > val[x] && val[x] < 0)
                ans[x] = ans[s] - 1;
            else if (ans[s] == -1 && val[x] == -1)
                ans[s] = -1;
            dfsUF(visited, x);
        }
    }
}