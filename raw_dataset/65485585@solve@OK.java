void solve() {
    int t = ni();
    for (int i = 0; i < t; ++i) {
        int n = ni();
        int m = ni();
        int s = 0;
        int[][] a = new int[n][2];
        for (int j = 0; j < n; ++j) {
            a[j][0] = ni();
            a[j][1] = j;
            s += a[j][0] << 1;
        }
        if (n == 2) {
            println(-1);
            continue;
        }
        if (m < n) {
            println(-1);
            continue;
        }
        Arrays.sort(a, (int[] x, int[] y) -> {
            return x[0] - y[0];
        });
        for (int j = 0; j < m - n; ++j) {
            s += a[j][0];
            s += a[j + 1][0];
        }
        println(s);
        for (int j = 0; j < n - 1; ++j) {
            println((a[j][1] + 1) + " " + (a[j + 1][1] + 1));
        }
        println((a[0][1] + 1) + " " + (a[n - 1][1] + 1));
        for (int j = 0; j < m - n; ++j) {
            println((a[0][1] + 1) + " " + (a[1][1] + 1));
        }
    }
// 
// for(int i=0;i<1000000;++i){
// r = mul(r,a,k);
// if(Arrays.equals(r,a)){
// println(i+1);return;
// }
// }
// println(-1);
// int n = ni();
// int p = ni();
// 
// int h[] = new int[n+1];
// Arrays.fill(h,-1);
// int to[] = new int[2*n+5];
// int ne[] = new int[2*n+5];
// int ct = 0;
// 
// for(int i=0;i<p;i++){
// int x = ni();
// int y = ni();
// to[ct] = x;
// ne[ct] = h[y];
// h[y] = ct++;
// 
// to[ct] = y;
// ne[ct] = h[x];
// h[x] = ct++;
// 
// }
// 
// println(go(1,h,ne,to,-1));
// int n= ni();
// //int m = ni();
// int  l = 2*n;
// 
// String s[] = new String[2*n+1];
// 
// long a[] = new long[2*n+1];
// for(int i=1;i<=n;++i){
// s[i] = ns();
// s[i+n] = s[i];
// a[i] = ni();
// a[i+n] = a[i];
// }
// 
// long dp[][] = new long[l+1][l+1];
// long dp1[][] = new long[l+1][l+1];
// 
// for(int i = l;i>=1;--i) {
// 
// Arrays.fill(dp[i],-1000000000);
// Arrays.fill(dp1[i],1000000000);
// }
// 
// for(int i = l;i>=1;--i) {
// dp[i][i] = a[i];
// dp1[i][i] = a[i];
// }
// 
// 
// 
// for(int i = l;i>=1;--i) {
// 
// for (int j = i+1; j <= l&&j-i+1<=n; ++j) {
// 
// 
// for(int e=i;e<j;++e){
// if(s[e+1].equals("t")){
// dp[i][j] = Math.max(dp[i][j], dp[i][e]+dp[e+1][j]);
// dp1[i][j] = Math.min(dp1[i][j], dp1[i][e]+dp1[e+1][j]);
// }else{
// 
// long f[] = {dp[i][e]*dp[e+1][j],dp1[i][e]*dp1[e+1][j],dp[i][e]*dp1[e+1][j],dp1[i][e]*dp[e+1][j]};
// 
// for(long u:f) {
// dp[i][j] = Math.max(dp[i][j], u);
// dp1[i][j] = Math.min(dp1[i][j], u);
// }
// }
// 
// 
// }
// 
// }
// }
// long ma = -100000000;
// List<Integer> li = new ArrayList<>();
// for (int j = 1; j <= n; ++j) {
// if(dp[j][j+n-1]==ma){
// li.add(j);
// }else if(dp[j][j+n-1]>ma){
// ma = dp[j][j+n-1];
// li.clear();
// li.add(j);
// }
// 
// }
// println(ma);
// for(int u:li){
// print(u+" ");
// }
// println();
// println(get(490));
// int num =1;
// while(true) {
// int n = ni();
// int m = ni();
// if(n==0&&m==0) break;
// int p[] = new int[n];
// int d[] = new int[n];
// for(int j=0;j<n;++j){
// p[j] = ni();
// d[j] = ni();
// }
// int dp[][] = new int[8001][22];
// int choose[][] = new int[8001][22];
// 
// for(int v=0;v<=8000;++v){
// for(int u=0;u<=21;++u) {
// dp[v][u] = -100000;
// choose[v][u] =-1;
// }
// }
// dp[4000][0] = 0;
// 
// for(int j=0;j<n;++j){
// for(int g = m-1 ;g>=0; --g){
// if(p[j] - d[j]>=0) {
// for (int v = 4000; v >= -4000; --v) {
// if (v + 4000 + p[j] - d[j] >= 0 && v + 4000 + p[j] - d[j] <= 8000 && dp[v + 4000][g] >= 0) {
// int ck1 = dp[v + 4000 + p[j] - d[j]][g + 1];
// if (ck1 < dp[v + 4000][g] + p[j] + d[j]) {
// dp[v + 4000 + p[j] - d[j]][g + 1] = dp[v + 4000][g] + p[j] + d[j];
// choose[v + 4000 + p[j] - d[j]][g + 1] = j;
// }
// }
// 
// }
// }else{
// for (int v = -4000; v <= 4000; ++v) {
// if (v + 4000 + p[j] - d[j] >= 0 && v + 4000 + p[j] - d[j] <= 8000 && dp[v + 4000][g] >= 0) {
// int ck1 = dp[v + 4000 + p[j] - d[j]][g + 1];
// if (ck1 < dp[v + 4000][g] + p[j] + d[j]) {
// dp[v + 4000 + p[j] - d[j]][g + 1] = dp[v + 4000][g] + p[j] + d[j];
// choose[v + 4000 + p[j] - d[j]][g + 1] = j;
// }
// }
// 
// }
// 
// 
// 
// 
// 
// }
// }
// }
// int big = 0;
// int st = 0;
// boolean ok = false;
// for(int v=0;v<=4000;++v){
// int v1 = -v;
// if(dp[v+4000][m]>0){
// big = dp[v+4000][m];
// st = v+4000;
// ok = true;
// }
// if(dp[v1+4000][m]>0&&dp[v1+4000][m]>big){
// big = dp[v1+4000][m];
// st = v1+4000;
// ok = true;
// }
// if(ok){
// break;
// }
// }
// int f = 0;
// int s = 0;
// List<Integer> res = new ArrayList<>();
// while(choose[st][m]!=-1){
// int j = choose[st][m];
// res.add(j+1);
// f += p[j];
// s += d[j];
// st -= p[j]-d[j];
// m--;
// }
// Collections.sort(res);
// println("Jury #"+num);
// println("Best jury has value " + f + " for prosecution and value " + s + " for defence:");
// for(int u=0;u<res.size();++u){
// print(" ");
// print(res.get(u));
// }
// println();
// println();
// num++;
// }
// int n = ni();
// int m = ni();
// 
// int dp[][] = new int[n][4];
// 
// for(int i=0;i<n;++i){
// for(int j=0;j<m;++j){
// for(int c = 0;c<4;++c){
// if(c==0){
// dp[i][j][] =
// }
// }
// }
// }
}