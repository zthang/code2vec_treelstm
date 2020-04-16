// **just change the name of class from Main to reuquired**
public void run() {
    InputReader sc = new InputReader(System.in);
    PrintWriter w = new PrintWriter(System.out);
    int n = sc.nextInt(), m = sc.nextInt();
    long[] bal = new long[n + 1];
    for (int i = 0; i < m; i++) {
        int u = sc.nextInt(), v = sc.nextInt(), x = sc.nextInt();
        bal[u] -= x;
        bal[v] += x;
    }
    ArrayList<Integer> pos = new ArrayList<Integer>();
    ArrayList<Integer> neg = new ArrayList<Integer>();
    ArrayList<Long> amt = new ArrayList<Long>();
    for (int i = 1; i < n + 1; i++) {
        if (bal[i] < 0)
            neg.add(i);
        if (bal[i] > 0)
            pos.add(i);
    }
    ArrayList<Integer> give = new ArrayList<Integer>();
    ArrayList<Integer> take = new ArrayList<Integer>();
    int N = 0, P = 0;
    while (N < neg.size() && P < pos.size()) {
        int u = neg.get(N);
        int v = pos.get(P);
        give.add(u);
        take.add(v);
        long val = Math.min(Math.abs(bal[u]), Math.abs(bal[v]));
        amt.add(val);
        bal[u] += val;
        bal[v] -= val;
        if (bal[u] == 0)
            N++;
        if (bal[v] == 0)
            P++;
    }
    w.println(amt.size());
    for (int i = 0; i < amt.size(); i++) {
        w.println(give.get(i) + " " + take.get(i) + " " + amt.get(i));
    }
    System.out.flush();
    w.close();
}