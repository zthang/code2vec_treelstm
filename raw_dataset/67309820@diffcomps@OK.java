public static int diffcomps(ArrayList<Node> nodes) {
    int i = 0;
    int count = 0;
    while (i != nodes.size()) {
        if (nodes.get(i).visited == false) {
            count += 1;
            Queue<Node> q = new LinkedList<>();
            q.add(nodes.get(i));
            while (q.size() != 0) {
                Node next = q.remove();
                if (next.visited == false) {
                    next.visited = true;
                    for (Node neighbor : next.edges) {
                        q.add(neighbor);
                    }
                }
            }
        } else {
            i += 1;
        }
    }
    return count;
}