public void solve(int testNumber, FastReader sc, PrintWriter pw) {
    int n = sc.nextInt();
    tup[] x = new tup[n];
    for (int i = 0; i < n; i++) {
        x[i] = new tup(sc.nextInt() - 1, 0);
    }
    for (int j = 0; j < n; j++) {
        x[j].b = sc.nextInt();
    }
    int min = Integer.MAX_VALUE;
    boolean[] vis = new boolean[n];
    for (int k = 0; k < n; k++) {
        if (vis[k])
            continue;
        boolean[] tvis = new boolean[n];
        int ind = k;
        while (!tvis[ind]) {
            vis[ind] = true;
            tvis[ind] = true;
            ind = x[ind].a;
        }
        tup t = x[ind];
        ArrayList<tup> a = new ArrayList<tup>();
        a.add(t);
        while (t.a != ind) {
            t = x[t.a];
            a.add(t);
        }
        // pw.println(a);
        int ale = a.size();
        for (int i = 1; i <= Math.sqrt(ale); i++) {
            if (i >= min)
                continue;
            if (ale % i == 0) {
                boolean[] ttt = new boolean[i];
                for (int j = i; j < ale + i; j++) {
                    if (a.get(j % ale).b != a.get(j % i).b) {
                        ttt[j % i] = true;
                    }
                }
                for (boolean r : ttt) {
                    if (!r) {
                        min = Math.min(min, i);
                        break;
                    }
                }
                ttt = new boolean[ale / i];
                for (int j = ale / i; j < ale + ale / i; j++) {
                    if (a.get(j % ale).b != a.get(j % (ale / i)).b) {
                        ttt[j % (ale / i)] = true;
                    }
                }
                for (boolean r : ttt) {
                    if (!r) {
                        min = Math.min(min, ale / i);
                        break;
                    }
                }
            }
        }
    }
    pw.println(min);
}