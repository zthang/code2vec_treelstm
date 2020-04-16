public boolean join(int first, int second) {
    first = parent[first];
    second = parent[second];
    if (first == second) {
        return false;
    }
    int firstSize = lists[first] == null ? 1 : lists[first].size() + 1;
    int secondSize = lists[second] == null ? 1 : lists[second].size() + 1;
    if (firstSize < secondSize) {
        int temp = first;
        first = second;
        second = temp;
    }
    if (lists[first] == null) {
        lists[first] = new IntArrayList();
    }
    lists[first].add(second);
    parent[second] = first;
    if (lists[second] != null) {
        lists[first].addAll(lists[second]);
        final int finalFirst = first;
        lists[second].forEach((IntTask) i -> parent[i] = finalFirst);
    }
    lists[second] = null;
    if (listener != null) {
        listener.joined(second, first);
    }
    setCount--;
    return true;
}