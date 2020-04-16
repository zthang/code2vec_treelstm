static void bfs(HashSet<Long> edge, int s, boolean[] v, TreeSet<Integer> vertices) {
    long n = v.length;
    LinkedList<Integer> queue = new LinkedList();
    ArrayList<Integer> toDelete = new ArrayList();
    queue.add(s);
    vertices.remove(s);
    v[s] = true;
    while (queue.size() > 0) {
        s = queue.poll();
        for (Integer i : vertices) if (v[i] == false) {
            long k = n * Math.min(s, i) + Math.max(s, i);
            if (!edge.contains(k)) {
                queue.add(i);
                toDelete.add(i);
                v[i] = true;
            }
        }
        for (Integer i : toDelete) vertices.remove(i);
        toDelete.clear();
    }
}