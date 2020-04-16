// ランクの小さいほうにつなげる
boolean union(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y)
        return false;
    if (rank[x] < rank[y]) {
        int tmp = x;
        x = y;
        y = tmp;
    }
    // yのほうが重くなる(ポテンシャルが高くなる)
    if (rank[x] == rank[y])
        rank[x]++;
    group--;
    par[y] = x;
    size[x] += size[y];
    return true;
}