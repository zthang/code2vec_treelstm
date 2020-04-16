    static long dij(int n,int k){
        long[][][]dis = new long[k+1][n][keys.size()];
        PriorityQueue<Edge>pq = new PriorityQueue<>((x,y)->Long.compare(x.cost,y.cost));
        for (long[][]x:dis)for (long[]z:x)Arrays.fill(z,(long)1e15);
        pq.add(new Edge(0,0,0));
        dis[0][0][0]=0;
        long min =(long)1e15;
        while (!pq.isEmpty()){
            Edge z = pq.poll();
            ArrayList<Integer>o= new ArrayList<>();
            if (z.dis==k) {
                if (z.node==0) {
//                    System.err.println(z.route);
                    return z.cost;
                }
                continue;
            }
            ArrayList<Integer>nxt = new ArrayList<>();
            HashSet<Integer>inv = new HashSet<>();
            for (int []x:z.route) {
                if (x[0]==z.node){
                    continue;
                }
                if ((x[1] % 2) == 0){
                    o.add(x[0]);
                    inv.add(x[0]);
                }
                else{
                    nxt.add(x[0]);
                }
            }
            Collections.sort(o);
            Collections.sort(nxt);
            obj cur = new obj();
            obj nxx = new obj();
            cur.arr=o;
            nxx.arr=nxt;
            int idx = keys.get(cur);
//            System.err.println(nxt);
            int nxtidx=keys.get(nxx);
            if (dis[z.dis][z.node][idx]<z.cost)
                continue;

            for (int i =0;i<n;i++){
                if (i==z.node||inv.contains(i))continue;
                if (dis[z.dis+1][i][nxtidx]>z.cost+adj[z.node][i]){
                        Edge e = new Edge(i,dis[z.dis+1][i][nxtidx]=z.cost+adj[z.node][i],z.dis+1);
                        int[]here= new int[2];
                        here[0]=z.node;
                        here[1]=1;
                        e.route.add(here);
                        for (int[]x:z.route){
                            int[] y = x.clone();
                            y[1]++;
                            y[1]%=2;
                            if (y[0]==z.node)continue;
                            e.route.add(y);
                        }
                        pq.add(e);
                }
            }
        }
        return min;
    }