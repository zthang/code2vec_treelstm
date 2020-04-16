void solve() {
    int n = ni();
    int k = ni();
    int[] rk = new int[n + 1];
    for (int i = 0; i < n; ++i) {
        rk[ni() - 1] = i;
    }
    int[] q = new int[n];
    for (int j = 0; j < n; ++j) {
        q[j] = ni() - 1;
    }
    init(n);
    int qma = -1;
    int lst = -1;
    int id = 1;
    int[] c = new int[n];
    int ct = 0;
    for (int j = 0; j < n; ++j) {
        qma = Math.max(qma, rk[q[j]]);
        if (qma == j) {
            for (int l = lst + 1; l <= j; ++l) {
                c[q[l]] = id;
            }
            id++;
            lst = j;
            ct++;
        }
    }
    if (ct >= k) {
        println("YES");
        for (int i = 0; i < n; ++i) {
            int v = Math.min(25, c[i] - 1);
            print((char) ('a' + v));
        }
    } else {
        println("NO");
    }
// N , M , K , a , b , c , d . 其中N , M是矩阵的行列数；K 是上锁的房间数目，(a, b)是起始位置，(c, d)是出口位置
// int n = ni();
// int m = ni();
// int k = ni();
// int a = ni();
// int b = ni();
// int c = ni();
// int d = ni();
// 
// 
// char cc[][] = nm(n,m);
// char keys[][] = new char[n][m];
// 
// char ky = 'a';
// for(int i=0;i<k;++i){
// int x = ni();
// int y = ni();
// keys[x][y] = ky;
// ky++;
// }
// int f1[] = {a,b,0};
// 
// int dd[][] = {{0,1},{0,-1},{1,0},{-1,0}};
// 
// Queue<int[]> q =  new LinkedList<>();
// q.offer(f1);
// int ts = 1;
// 
// boolean vis[][][] = new boolean[n][m][33];
// 
// while(q.size()>0){
// int sz = q.size();
// while(sz-->0) {
// int cur[] = q.poll();
// vis[cur[0]][cur[1]][cur[2]] = true;
// 
// int x = cur[0];
// int y = cur[1];
// 
// for (int u[] : dd) {
// int lx = x +  u[0];
// int ly = y +  u[1];
// if (lx >= 0 && ly >= 0 && lx < n && ly < m && (cc[lx][ly] != '#')&&!vis[lx][ly][cur[2]]){
// char ck =cc[lx][ly];
// if(ck=='.'){
// if(lx==c&&ly==d){
// println(ts); return;
// }
// if(keys[lx][ly]>='a'&&keys[lx][ly]<='z') {
// int cao = cur[2] | (1 << (keys[lx][ly] - 'a'));
// q.offer(new int[]{lx, ly, cao});
// vis[lx][ly][cao] = true;
// }else {
// 
// q.offer(new int[]{lx, ly, cur[2]});
// }
// 
// }else if(ck>='A'&&ck<='Z'){
// int g = 1<<(ck-'A');
// if((g&cur[2])>0){
// if(lx==c&&ly==d){
// println(ts); return;
// }
// if(keys[lx][ly]>='a'&&keys[lx][ly]<='z') {
// 
// int cao = cur[2] | (1 << (keys[lx][ly] - 'a'));
// q.offer(new int[]{lx, ly, cao});
// vis[lx][ly][cao] = true;;
// }else {
// 
// q.offer(new int[]{lx, ly, cur[2]});
// }
// }
// }
// }
// }
// 
// }
// ts++;
// }
// println(-1);
// int n = ni();
// 
// HashSet<String> st = new HashSet<>();
// HashMap<String,Integer> mp = new HashMap<>();
// 
// 
// for(int i=0;i<n;++i){
// String s  = ns();
// int id= 1;
// if(mp.containsKey(s)){
// int u = mp.get(s);
// id = u;
// 
// }
// 
// if(st.contains(s)) {
// 
// while (true) {
// String ts = s + id;
// if (!st.contains(ts)) {
// s = ts;
// break;
// }
// id++;
// }
// mp.put(s,id+1);
// }else{
// mp.put(s,1);
// }
// println(s);
// st.add(s);
// 
// }
// int t = ni();
// 
// for(int i=0;i<t;++i){
// int n = ni();
// long w[] = nal(n);
// 
// Map<Long,Long> mp = new HashMap<>();
// PriorityQueue<long[]> q =new PriorityQueue<>((xx,xy)->{return Long.compare(xx[0],xy[0]);});
// 
// for(int j=0;j<n;++j){
// q.offer(new long[]{w[j],0});
// mp.put(w[j],mp.getOrDefault(w[j],0L)+1L);
// }
// 
// while(q.size()>=2){
// long f[] = q.poll();
// long y1 = f[1];
// if(y1==0){
// y1 = mp.get(f[0]);
// if(y1==1){
// mp.remove(f[0]);
// }else{
// mp.put(f[0],y1-1);
// }
// }
// long g[] = q.poll();
// long y2 = g[1];
// if(y2==0){
// y2 = mp.get(g[0]);
// if(y2==1){
// mp.remove(g[0]);
// }else{
// mp.put(g[0],y2-1);
// }
// }
// q.offer(new long[]{f[0]+g[0],2L*y1*y2});
// 
// }
// long r[] = q.poll();
// println(r[1]);
// 
// 
// 
// 
// }
// int o= 9*8*7*6;
// println(o);
// int t = ni();
// for(int i=0;i<t;++i){
// long a = nl();
// int k  = ni();
// if(k==1){
// println(a);
// continue;
// }
// 
// int f = (int)(a%10L);
// int s = 1;
// int j = 0;
// for(;j<30;j+=2){
// int u = f-j;
// if(u<0){
// u = 10+u;
// }
// s = u*s;
// s = s%10;
// if(s==k){
// break;
// }
// }
// 
// if(s==k) {
// println(a - j - 2);
// }else{
// println(-1);
// }
// 
// 
// 
// 
// }
// int m = ni();
// h = new int[n];
// to = new int[2*(n-1)];
// ne = new int[2*(n-1)];
// wt = new int[2*(n-1)];
// 
// for(int i=0;i<n-1;++i){
// int u = ni()-1;
// int v = ni()-1;
// 
// }
// long a[] = nal(n);
// int n = ni();
// int k = ni();
// t1 = new long[200002];
// 
// int p[][] = new int[n][3];
// 
// for(int i=0;i<n;++i){
// p[i][0]  = ni();
// p[i][1]  = ni();
// p[i][2]  = i+1;
// }
// Arrays.sort(p, new Comparator<int[]>() {
// @Override
// public int compare(int[] x, int[] y) {
// if(x[1]!=y[1]){
// return Integer.compare(x[1],y[1]);
// }
// return Integer.compare(y[0], x[0]);
// }
// });
// 
// for(int i=0;i<n;++i){
// int ck = p[i][0];
// 
// }
}