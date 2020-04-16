private List<Integer> solve(int root) {
    List<List<Integer>> subtrees = new ArrayList<>();
    int assign = 0;
    Queue<Integer> thresholds = new ArrayDeque<>();
    int sc = score[root];
    int count = 0;
    for (int c : child[root]) {
        List<Integer> indices = solve(c);
        if (indices == null)
            return null;
        subtrees.add(indices);
        List<Integer> values = new ArrayList<>();
        int max = 0;
        for (int i : indices) {
            answer[i] += count;
            values.add(answer[i]);
            max = Math.max(max, answer[i]);
        }
        count = max;
        Collections.sort(values);
        int lastUnchanged = -1;
        for (int i = 0; i < Math.min(values.size(), sc); i++) {
            lastUnchanged = values.get(i);
        }
        sc -= Math.min(values.size(), sc);
        thresholds.add(lastUnchanged);
        assign = Math.max(assign, lastUnchanged);
    }
    if (sc > 0)
        return null;
    List<Integer> result = new ArrayList<>();
    for (List<Integer> indices : subtrees) {
        result.addAll(indices);
        int lastUnchanged = thresholds.remove();
        int diff = assign - lastUnchanged;
        for (int i : indices) {
            if (answer[i] > lastUnchanged) {
                answer[i] += 1 + diff;
            }
        }
    }
    answer[root] = assign + 1;
    result.add(root);
    return result;
}