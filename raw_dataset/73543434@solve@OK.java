public static void solve(InputReader sc, PrintWriter pw) {
    int i, j = 0;
    int t = 1;
    // int t=sc.nextInt();
    u: while (t-- > 0) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] sp = new int[n + 1];
        for (i = 0; i < k; i++) sp[sc.nextInt()] = 1;
        int[] vis = new int[n + 1];
        Queue<Integer> q = new LinkedList<Integer>();
        ArrayList<Integer>[] ar = new ArrayList[n + 1];
        for (i = 1; i <= n; i++) ar[i] = new ArrayList<Integer>();
        for (i = 0; i < m; i++) {
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            ar[p1].add(p2);
            ar[p2].add(p1);
        }
        q.add(1);
        q.add(-1);
        vis[1] = 1;
        int[] dsrc = new int[n + 1];
        int cu = 0;
        while (q.size() > 0) {
            int u = q.remove();
            if (u == -1) {
                if (q.size() == 0)
                    break;
                q.add(-1);
                cu++;
            } else {
                dsrc[u] = cu;
                for (int l : ar[u]) {
                    if (vis[l] == 0) {
                        q.add(l);
                        vis[l] = 1;
                    }
                }
            }
        // System.out.println(u+" "+((u!=-1)?dsrc[u]:0)+" " +q.size());
        }
        q = new LinkedList<Integer>();
        // ar=new ArrayList[n+1];
        vis = new int[n + 1];
        int[] ddest = new int[n + 1];
        q.add(n);
        q.add(-1);
        vis[n] = 1;
        cu = 0;
        while (q.size() > 0) {
            int u = q.remove();
            if (u == -1) {
                if (q.size() == 0)
                    break;
                q.add(-1);
                cu++;
            } else {
                ddest[u] = cu;
                for (int l : ar[u]) {
                    if (vis[l] == 0) {
                        q.add(l);
                        vis[l] = 1;
                    }
                }
            }
        }
        Pair[] v = new Pair[k];
        int g = 0;
        for (i = 0; i < n; i++) {
            if (sp[i + 1] == 1)
                v[g++] = new Pair(dsrc[i + 1] - ddest[i + 1], i + 1);
        }
        Arrays.sort(v);
        int till = dsrc[v[0].b];
        int max = 0;
        for (i = 1; i < k; i++) {
            max = Math.max(max, till + ddest[v[i].b] + 1);
            till = Math.max(till, dsrc[v[i].b]);
        }
        pw.println(Math.min(max, ddest[1]));
    }
}