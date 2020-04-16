// void go(int i,int c,int cl[]){
// cl[i] = c;
// for(int j=h[i];j!=-1;j=ne[j]){
// int v = to[j];
// if(cl[v]==0){
// go(v,-c,cl);
// }
// }
// 
// }
int go(int rt, int[] h, int[] ne, int[] to, int pa) {
    int all = 3010;
    for (int i = h[rt]; i != -1; i = ne[i]) {
        int v = to[i];
        if (v == pa)
            continue;
        int ma = 0;
        for (int j = h[rt]; j != -1; j = ne[j]) {
            int u = to[j];
            if (u == pa)
                continue;
            if (u != v) {
                int r = 1 + go(u, h, ne, to, rt);
                ma = Math.max(ma, r);
            }
        }
        all = Math.min(all, ma);
    }
    if (all == 3010 || all == 0)
        return 1;
    return all;
}