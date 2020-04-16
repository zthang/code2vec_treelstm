ArrayList<Integer> Kahntsort() {
    ArrayList<Integer> ans = new ArrayList<Integer>();
    PriorityQueue<Integer> q = new PriorityQueue<Integer>();
    int[] in = new int[size];
    for (int i = 0; i < size; i++) {
        for (Edge e : list[i]) in[e.to]++;
    }
    for (int i = 0; i < size; i++) {
        if (in[i] == 0)
            q.add(i);
    }
    while (!q.isEmpty()) {
        int v = q.poll();
        ans.add(v);
        for (Edge e : list[v]) {
            in[e.to]--;
            if (in[e.to] == 0)
                q.add(e.to);
        }
    }
    for (int i = 0; i < size; i++) {
        if (in[i] > 0)
            return new ArrayList<Integer>();
    }
    return ans;
}