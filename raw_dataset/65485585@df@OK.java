void df(int n, LinkedList<Integer> li) {
    int sz = li.size();
    if (sz >= rr || sz >= 11)
        return;
    int v = li.getLast();
    if (v == n) {
        cao = new LinkedList<>(li);
        rr = sz;
        return;
    }
    List<Integer> res = new ArrayList<>(li);
    Collections.reverse(res);
    for (int u : res) {
        for (int vv : res) {
            if (u + vv > v && u + vv <= n) {
                li.addLast(u + vv);
                df(n, li);
                li.removeLast();
            } else if (u + vv > n) {
                break;
            }
        }
    }
}