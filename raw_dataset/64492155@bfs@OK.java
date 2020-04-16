static void bfs(int begin) {
    LinkedList<Integer> nextToVisit = new LinkedList<Integer>();
    nextToVisit.add(begin);
    visited[begin] = true;
    Iterator<Integer> it;
    while (!nextToVisit.isEmpty()) {
        int id = nextToVisit.poll();
        it = rest.iterator();
        while (it.hasNext()) {
            int next = it.next();
            if (one[id].contains(next))
                continue;
            it.remove();
            if (visited[next])
                continue;
            visited[next] = true;
            nextToVisit.add(next);
        }
    }
}