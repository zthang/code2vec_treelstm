private void dfs(Integer cnode) {
    List<Integer> list = new ArrayList<>();
    for (Iterator<Integer> it = nodes.iterator(); it.hasNext(); ) {
        Integer node = it.next();
        if (Collections.binarySearch(edges[cnode], node) < 0) {
            list.add(node);
            it.remove();
        }
    }
    for (Integer node : list) {
        dfs(node);
    }
}