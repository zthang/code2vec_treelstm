public void dfs(int index) {
    set.remove(index);
    Integer last = 0;
    while (!set.isEmpty()) {
        last = set.higher(last);
        if (last == null) {
            break;
        }
        if (!graph[index].contains(last)) {
            dfs(last);
        }
    }
}