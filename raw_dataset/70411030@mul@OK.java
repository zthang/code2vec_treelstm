// int[] h,ne,to,wt;
// int ct = 0;
// int n;
// void graph(int n,int m){
// h = new int[n];
// Arrays.fill(h,-1);
// //        sccno = new int[n];
// //        dfn = new int[n];
// //        low = new int[n];
// //        iscut = new boolean[n];
// ne = new int[2*m];
// to = new int[2*m];
// wt = new int[2*m];
// ct = 0;
// }
// void add(int u,int v,int w){
// to[ct] = v;
// ne[ct] = h[u];
// wt[ct] = w;
// h[u] = ct++;
// }
// 
// int color[],dfn[],low[],stack[] = new int[1000000],cnt[];
// int sccno[];
// boolean iscut[];
// int time = 0,top = 0;
// int scc_cnt = 0;
// 
// // 有向图的强连通分量
// void tarjan(int u) {
// low[u] = dfn[u]= ++time;
// stack[top++] = u;
// for(int i=h[u];i!=-1;i=ne[i]) {
// int v = to[i];
// if(dfn[v]==0) {
// tarjan(v);
// low[u]=Math.min(low[u],low[v]);
// } else if(sccno[v]==0) {
// // dfn>0 but sccno==0, means it's in current stack
// low[u]=Math.min(low[u],low[v]);
// }
// }
// 
// if(dfn[u]==low[u]) {
// sccno[u] = ++scc_cnt;
// while(stack[top-1]!=u) {
// sccno[stack[top-1]] = scc_cnt;
// --top;
// }
// --top;
// }
// }
// 
// //缩点, topology sort
// int[] h1,to1,ne1;
// int ct1 = 0;
// void point(){
// for(int i=0;i<n;i++) {
// if(dfn[i]==0) tarjan(i);//有可能图不连通，所以要循环判断。
// }
// // 入度
// int du[] = new int[scc_cnt+1];
// h1 = new int[scc_cnt+1];
// Arrays.fill(h1, -1);
// to1 = new int[scc_cnt*scc_cnt];
// ne1 = new int[scc_cnt*scc_cnt];
// // scc_cnt 个点
// 
// for(int i=1;i<=n;i++) {
// for(int j=h[i]; j!=-1; j=ne[j]) {
// int y = to[j];
// if(sccno[i] != sccno[y]) {
// // add(sccno[i],sccno[y]);  // 建新图
// to1[ct1] = sccno[y];
// ne1[ct1] = h[sccno[i]];
// h[sccno[i]] = ct1++;
// du[sccno[y]]++; //存入度
// }
// }
// }
// 
// int q[] = new int[100000];
// int end = 0;
// int st = 0;
// for(int i=1;i<=scc_cnt;++i){
// if(du[i]==0){
// q[end++] = i;
// }
// }
// 
// int dp[] = new int[scc_cnt+1];
// while(st<end){
// int cur = q[st++];
// for(int i=h1[cur];i!=-1;i=ne1[i]){
// int y = to[i];
// // dp[y] += dp[cur];
// if(--du[y]==0){
// q[end++] = y;
// }
// }
// }
// }
// 
// 
// 
// 
// int fa[];
// int faw[];
// 
// int dep = -1;
// int pt = 0;
// void go(int rt,int f,int dd){
// 
// int p = 0;
// stk[p] = rt;
// lk[p] = 0;
// fk[p] = f;p++;
// while(p>0) {
// int cur = stk[p - 1];
// int fp = fk[p - 1];
// int ll = lk[p - 1];
// p--;
// 
// 
// if (ll > dep) {
// dep = ll;
// pt = cur;
// }
// for (int i = h[cur]; i != -1; i = ne[i]) {
// int v = to[i];
// if (fp == v) continue;
// 
// stk[p] = v;
// lk[p] = ll + wt[i];
// fk[p] = cur;
// p++;
// }
// }
// }
// int pt1 = -1;
// void go1(int rt,int f,int dd){
// 
// int p = 0;
// stk[p] = rt;
// lk[p] = 0;
// fk[p] = f;p++;
// while(p>0) {
// int cur = stk[p - 1];
// int fp = fk[p - 1];
// int ll = lk[p - 1];
// p--;
// 
// 
// if (ll > dep) {
// dep = ll;
// pt1 = cur;
// }
// 
// fa[cur] = fp;
// for (int i = h[cur]; i != -1; i = ne[i]) {
// int v = to[i];
// if (v == fp) continue;
// faw[v] = wt[i];
// stk[p] = v;
// lk[p] = ll + wt[i];
// fk[p] = cur;
// p++;
// }
// }
// }
// 
// int r = 0;
// int stk[] = new int[301];
// int fk[] = new int[301];
// int lk[] = new int[301];
// void ddfs(int rt,int t1,int t2,int t3,int l){
// 
// 
// int p = 0;
// stk[p] = rt;
// lk[p] = 0;
// fk[p] = t3;p++;
// while(p>0){
// int cur = stk[p-1];
// int fp = fk[p-1];
// int ll = lk[p-1];
// p--;
// r = Math.max(r,ll);
// for(int i=h[cur];i!=-1;i=ne[i]){
// int v = to[i];
// if(v==t1||v==t2||v==fp) continue;
// stk[p] = v;
// lk[p] = ll+wt[i];
// fk[p] = cur;p++;
// }
// }
// 
// 
// 
// }
static long mul(long a, long b, long p) {
    long res = 0, base = a;
    while (b > 0) {
        if ((b & 1L) > 0)
            res = (res + base) % p;
        base = (base + base) % p;
        b >>= 1;
    }
    return res;
}