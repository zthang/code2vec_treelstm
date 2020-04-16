public List<Integer> getShortestPath(int src, int dst) {
    if (dist[src] != 0) {
        System.out.println("src dist isn't 0 !");
        return null;
    }
    if (dist[dst] == inf) {
        return new ArrayList<Integer>(Arrays.asList(-1));
    }
    int t = dst;
    Stack<Integer> path = new Stack<Integer>();
    path.push(dst);
    while (pv[t] != -1) {
        path.push(pv[t]);
        t = pv[t];
    }
    List<Integer> res = new ArrayList<>();
    // System.out.println("src = " + src + ", dst = " + dst + ", path is :");
    for (; !path.isEmpty(); ) {
        // System.out.print(path.pop() + " ");
        res.add(path.pop());
    }
    return res;
}