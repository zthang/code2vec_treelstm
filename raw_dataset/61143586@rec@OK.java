void rec(int node, int n, int nDots) {
    if (node == n) {
        boolean[][] dominos = new boolean[7][7];
        int curAns = 0;
        for (int i = 0; i < edges.length; i++) {
            int a = dots[edges[i][0]];
            int b = dots[edges[i][1]];
            if (a == -1 || b == -1)
                continue;
            if (dominos[a][b] == false)
                curAns++;
            dominos[a][b] = true;
            dominos[b][a] = true;
        }
        best = Math.max(best, curAns);
        return;
    }
    rec(node + 1, n, nDots);
    // return;
    for (int dot = 0; dot < nDots; dot++) {
        // used[dot] = true;
        dots[node] = dot;
        rec(node + 1, n, nDots);
        dots[node] = -1;
    // used[dot] = false;
    }
}