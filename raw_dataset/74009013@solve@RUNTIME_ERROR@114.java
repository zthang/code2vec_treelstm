    void solve() {
        int t = ni();
        A: while(t-- > 0) {
        int n = ni(), m = ni();
        int X = ni() - 1, Y = ni() - 1;
        a = new HashSet[n];
        pt = new int[n];
        sz = new HashMap<>();
        for(int i = 0; i < n; i++) {
            a[i] = new HashSet<>();
            pt[i] = i;
            if(i == X || i == Y)    continue;
            sz.put(i, 1);
        }
        for(int i = 0; i < m; i++) {
            int u = ni() - 1;
            int v = ni() - 1;
            a[u].add(v);    a[v].add(u);
            if(u != X && u != Y && v != X && v != Y)    union(u, v);
        }
        if(sz.size() <= 1) {
            out.println(0);
        } else if(sz.size() == 2) {
            HashSet <Integer> xn = new HashSet<>();
            for(int x : a[X])   xn.add(root(x));
            if(xn.size() == 1) {
                out.println(0);     continue A;
            }
            HashSet <Integer> yn = new HashSet<>();
            for(int y : a[Y])   yn.add(root(y));
            if(yn.size() == 1) {
                out.println(0);     continue A;
            }
            
            xn.clear();
            for(int x : a[X]) {
                if(x == Y)  continue;
                xn.add(root(x));
            }
            if(xn.size() == 2) {
                out.println(0);     continue A;
            }
            
            int r1 = -1, r2 = -1;
            for(int x : a[X]) {
                if(x == Y)  continue;
                r1 = root(x);   break;
            }
            for(int y : a[Y]) {
                if(y == X)  continue;
                r2 = root(y);   break;
            }
            
            for(int i = 0; i < n; i++) {
                if(i == X || i == Y)    continue;
                if(root(i) == r1) {
                    if(a[i].contains(Y)) {
                        out.println(0); continue A;
                    }
                } else {
                    if(a[i].contains(X)) {
                        out.println(0); continue A;
                    }
                }
            }
            
            long ans = 1;
            for(int k : sz.keySet())    ans *= sz.get(k);
            out.println(ans);
        } else if(sz.size() == 3) {
            int x1 = -1, x2 = -1;
            for(int x : a[X]) {
                int r = root(x);
                if(x1 == -1)    x1 = r;
                else if(x1 != r) {
                    x2 = r; break;
                }
            }
            
            int y1 = -1, y2 = -1;
            for(int y : a[Y]) {
                int r = root(y);
                if(y1 == -1)    y1 = r;
                else if(y1 != r) {
                    y2 = r; break;
                }
            }
            
            int r1, r2, mid;
            
            if(x1 == y1) {
                r1 = x2; r2 = y2; mid = x1;
            } else if(x1 == y2) {
                r1 = x2; r2 = y1; mid = x1;
            } else if(x2 == y1) {
                r1 = x1; r2 = y2; mid = x2;
            } else {
                r1 = x1; r2 = y1; mid = x2;
            }
            
            for(int i = 0; i < n; i++) {
                if(i == X || i == Y)    continue;
                int r = root(i);
                if(r == r1) {
                    if(a[i].contains(Y)) {
                        out.println(0); continue A;
                    }
                } else if(r == r2) {
                    if(a[i].contains(X)) {
                        out.println(0); continue A;
                    }
                }
            }
            out.println(1L * sz.get(r1) * sz.get(r2));
        } else {
            assert(sz.size() <= 3);
        }
        }
    }