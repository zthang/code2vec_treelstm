public static int[] bfs(int at, int[] went, ArrayList<ArrayList<Integer>> queue, int numNodes, ArrayList<ArrayList<Integer>> connect) {
    if (went[at] == 0) {
        went[at] = queue.get(numNodes).get(1);
        for (int i = 0; i < connect.get(at).size(); i++) {
            if (went[connect.get(at).get(i)] == 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(connect.get(at).get(i));
                temp.add(queue.get(numNodes).get(1) + 1);
                queue.add(temp);
            }
        }
    }
    if (queue.size() == numNodes + 1) {
        return went;
    } else {
        return bfs(queue.get(numNodes + 1).get(0), went, queue, numNodes + 1, connect);
    }
}