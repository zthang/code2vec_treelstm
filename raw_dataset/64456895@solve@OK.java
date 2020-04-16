String solve() {
    todo = new LinkedList<>();
    done = new boolean[n + 1];
    remaining = new LinkedList<>();
    for (int i = 1; i <= n; i++) remaining.add(i);
    count = -1;
    while (!remaining.isEmpty()) {
        processTodo(remaining.removeFirst());
    }
    return "" + count;
}