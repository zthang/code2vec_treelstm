public void go() throws IOException {
    ntok();
    int n = ipar();
    int k = ipar();
    UnionFind uf = new UnionFind(n);
    int count = 0;
    for (int i = 0; i < k; i++) {
        ntok();
        int x = ipar() - 1;
        int y = ipar() - 1;
        if (uf.find(x) != uf.find(y)) {
            uf.union(x, y);
            count++;
        }
    }
    out.println(k - count);
    out.flush();
    in.close();
}