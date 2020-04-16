void solve() {
    // int s = ni();
    // int n = ni();
    // 
    // long x[] = new long[n];
    // long y[] = new long[n];
    // for(int i=0;i<n;++i){
    // x[i] = nl();
    // y[i] = nl();
    // }
    // 
    // 
    // int m = n*(n-1)/2;
    // 
    // long egs[][] = new long[m][3];
    // int g = 0;
    // init(n);
    // for(int i=0;i<n;++i){
    // for(int j=i+1;j<n;++j){
    // egs[g][0] = (x[i]-x[j])*(x[i]-x[j])+ (y[i]-y[j])*(y[i]-y[j]);
    // egs[g][1] = i;
    // egs[g][2] = j;g++;
    // }
    // }
    // double r = 0;
    // 
    // Arrays.sort(egs, new Comparator<long[]>() {
    // @Override
    // public int compare(long[] xx, long[] yy) {
    // return Long.compare(xx[0],yy[0]);
    // }
    // });
    // for(int i=0;i<m;++i){
    // int u = (int)egs[i][1];
    // int v = (int)egs[i][2];
    // if(root(u)!=root(v)){
    // combine(u,v);
    // r = Math.sqrt(egs[i][0]);
    // if(groups==s){
    // break;
    // }
    // }
    // }
    // println(roundS(r,2));
    int n = ni();
    int m = ni();
    g = new TreeSet[n + 1];
    for (int i = 1; i <= n; ++i) {
        g[i] = new TreeSet();
        g[i].add(i);
    }
    for (int i = 0; i < m; ++i) {
        int a = ni();
        int b = ni();
        g[a].add(b);
        g[b].add(a);
    }
    vis = new TreeSet<>();
    for (int i = 1; i <= n; ++i) {
        vis.add(i);
    }
    int cp = 0;
    for (int i = 1; i <= n; ++i) {
        if (vis.contains(i)) {
            vis.remove(i);
            go(i);
            cp++;
        }
    }
    println(cp - 1);
}