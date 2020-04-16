// ///////////------------------------------------/////////////
// ///////////------------------------------------/////////////
// //////////------------------MAIN-LOGIC---------/////////////
// //////////-------------------------------------/////////////
// /////////--------------------------------------/////////////
public void solve() {
    int n = sc.ni();
    visit = new int[n];
    int m = 0;
    adj = new ArrayList[n];
    ArrayList<Seg>[] seg = new ArrayList[2 * n + 1];
    for (int i = 1; i <= 2 * n; i++) seg[i] = new ArrayList();
    for (int i = 0; i < n; i++) adj[i] = new ArrayList();
    for (int i = 0; i < n; i++) {
        int x = sc.ni();
        int y = sc.ni();
        seg[x].add(new Seg(x, y, i));
    }
    for (int i = 1; i <= 2 * n; i++) Collections.sort(seg[i]);
    PriorityQueue<Seg> pq = new PriorityQueue();
    for (int i = 1; i <= 2 * n; i++) {
        if (m >= n)
            break;
        for (Seg s : seg[i]) {
            if (m >= n)
                break;
            // System.out.println(s.l+" "+s.r);
            ArrayList<Seg> list = new ArrayList();
            if (!pq.isEmpty()) {
                Seg tmp = pq.poll();
                while (tmp.r < s.r) {
                    if (tmp.r > s.l) {
                        m++;
                        adj[tmp.v].add(s.v);
                        adj[s.v].add(tmp.v);
                        list.add(tmp);
                        if (m >= n)
                            break;
                    }
                    if (!pq.isEmpty()) {
                        tmp = pq.poll();
                    } else
                        break;
                }
                if (tmp.r >= s.r)
                    list.add(tmp);
                for (Seg pp : list) pq.add(pp);
                if (m >= n)
                    break;
            }
        }
        for (Seg s : seg[i]) pq.add(s);
    }
    if (m == n - 1) {
        dfs(0);
        for (int i = 0; i < n; i++) {
            if (visit[i] == 0)
                m = n;
        }
    } else
        m = n;
    if (m == n)
        pw.println("NO");
    else
        pw.println("YES");
}