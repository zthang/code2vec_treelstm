public void run() {
    InputReader sc = new InputReader(System.in);
    PrintWriter w = new PrintWriter(System.out);
    int n = sc.nextInt();
    int m = sc.nextInt();
    adj = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new ArrayList();
    }
    for (int i = 0; i < m; i++) {
        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;
        adj[a].add(b);
        adj[b].add(a);
    }
    for (int i = 0; i < n; i++) {
        TreeSet<Integer> tset = new TreeSet();
        tset.add(1);
        tset.add(2);
        tset.add(3);
        Iterator<Integer> it = adj[i].iterator();
        while (it.hasNext()) {
            int x = it.next();
            if (one.contains(x)) {
                tset.remove(1);
            }
            if (two.contains(x)) {
                tset.remove(2);
            }
            if (three.contains(x)) {
                tset.remove(3);
            }
        }
        if (tset.isEmpty()) {
            w.print("-1");
            w.close();
            System.exit(0);
        } else {
            if (tset.first() == 1) {
                one.add(i);
            } else if (tset.first() == 2) {
                two.add(i);
            } else {
                three.add(i);
            }
        }
    }
    if (one.size() > 0 && two.size() > 0 && three.size() > 0 && one.size() * two.size() + two.size() * three.size() + three.size() * one.size() == m) {
        for (int i = 0; i < n; i++) {
            if (one.contains(i)) {
                w.print(1 + " ");
            }
            if (two.contains(i)) {
                w.print(2 + " ");
            }
            if (three.contains(i)) {
                w.print(3 + " ");
                ;
            }
        }
    } else {
        w.println("-1");
    }
    w.close();
}