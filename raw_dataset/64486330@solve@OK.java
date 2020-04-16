String solve() {
    // LinkedHashSet instead of HashSet because HashSet#iterator() is unbearably slow.
    // In the MST
    Set<Integer> todo = new LinkedHashSet<>();
    // Still to process
    Set<Integer> remaining = new LinkedHashSet<>();
    for (int i = 1; i <= n; i++) remaining.add(i);
    int count = -1;
    while (!remaining.isEmpty()) {
        // Move element from remaining to todo
        Iterator<Integer> rt = remaining.iterator();
        todo.add(rt.next());
        rt.remove();
        count++;
        while (!todo.isEmpty()) {
            Iterator<Integer> ti = todo.iterator();
            Integer processing = ti.next();
            todo.remove(processing);
            // Look for free outgoing edges of processing
            Iterator<Integer> it = remaining.iterator();
            while (it.hasNext()) {
                Integer x = it.next();
                if (!edges.get(processing).contains(x)) {
                    todo.add(x);
                    it.remove();
                }
            }
        }
    }
    return String.valueOf(count);
}