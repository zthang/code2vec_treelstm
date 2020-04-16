public ArrayList<Integer> primetablearray(int m) {
    ArrayList<Integer> al = new ArrayList<Integer>();
    Queue<Integer> q = new ArrayDeque<Integer>();
    for (int i = 2; i <= m; i++) {
        q.add(i);
    }
    boolean[] b = new boolean[m + 1];
    while (!q.isEmpty()) {
        int e = q.poll();
        if (!b[e]) {
            al.add(e);
            for (int j = 1; e * j <= 1000000; j++) {
                b[e * j] = true;
            }
        }
    }
    return al;
}