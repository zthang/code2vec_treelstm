// 経路圧縮しながらrootを求める
int find(int x) {
    if (par[x] == x) {
        return x;
    } else {
        int f = find(par[x]);
        return par[x] = f;
    }
}