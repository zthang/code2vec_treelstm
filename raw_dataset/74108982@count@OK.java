public int count(int s, boolean[] v, int[] cmpOfNode, int cmp) {
    int count = 1;
    Queue<Integer> q = new LinkedList();
    q.add(s);
    v[s] = true;
    while (q.size() > 0) {
        int cur = q.poll();
        cmpOfNode[cur] = cmp;
        v[cur] = true;
        ArrayList<Integer> st = list[cur];
        for (int val : st) {
            if (!v[val]) {
                q.add(val);
                cmpOfNode[val] = cmp;
                v[val] = true;
                count++;
            }
        }
    }
    return count;
}