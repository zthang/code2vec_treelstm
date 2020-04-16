public static int bfs(ArrayList<ArrayList<Integer>> al, int s, boolean x) {
    int count = 0;
    LinkedList<Integer> q = new LinkedList<>();
    q.add(s);
    HashSet<Integer> visited = new HashSet<>();
    visited.add(s);
    while (q.size() > 0) {
        int val = q.removeFirst();
        // System.out.println(gap[val][0]+"-->"+val);
        // visited.add(val);
        ArrayList<Integer> al1 = al.get(val);
        for (Integer val1 : al1) {
            if (!visited.contains(val1)) {
                visited.add(val1);
                // System.out.println(val1+"&"+val);
                if (x == true) {
                    gap[val1][0] = gap[val][0] + 1;
                } else {
                    gap[val1][1] = gap[val][1] + 1;
                }
                q.addLast(val1);
            }
        }
    }
    return count;
}