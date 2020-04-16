private Set<Integer> answer(LinkedList<Integer>[] edges) {
    Set<Integer> set = new HashSet<>();
    set.add(1);
    List<Integer> content = new LinkedList<>(), next = new LinkedList<>();
    content.add(1);
    while (!content.isEmpty()) {
        for (Integer i : content) for (Integer j : edges[i]) if (!set.contains(j)) {
            set.add(j);
            next.add(j);
        }
        content = next;
        next = new LinkedList<>();
    }
    return set;
}