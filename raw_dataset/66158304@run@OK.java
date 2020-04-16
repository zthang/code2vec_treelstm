public void run() throws Exception {
    FastScanner f = new FastScanner();
    PrintWriter out = new PrintWriter(System.out);
    int n = f.nextInt(), m = f.nextInt();
    HashSet<Integer>[] adj = new HashSet[n];
    LinkedList<Integer> set = new LinkedList<>();
    for (int i = 0; i < n; i++) {
        adj[i] = new HashSet<>();
        set.add(i);
    }
    for (int i = 0; i < m; i++) {
        int a = f.nextInt() - 1, b = f.nextInt() - 1;
        adj[a].add(b);
        adj[b].add(a);
    }
    boolean[] skip = new boolean[n];
    LinkedList<Integer> q = new LinkedList<>();
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        if (skip[i])
            continue;
        q.add(i);
        ListIterator<Integer> it = set.listIterator();
        it.next();
        it.remove();
        while (!q.isEmpty()) {
            it = set.listIterator();
            int a = q.poll();
            while (it.hasNext()) {
                int j = it.next();
                if (adj[a].contains(j))
                    continue;
                it.remove();
                skip[j] = true;
                q.add(j);
            }
        }
        cnt++;
    }
    out.println(cnt - 1);
    // /
    out.flush();
}