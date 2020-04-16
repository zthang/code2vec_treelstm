private Set<Integer> dfs(int no) {
    List<Integer> ret = new ArrayList<>();
    Stack<Integer> s = new Stack<>();
    s.push(no);
    while (!s.isEmpty()) {
        no = s.pop();
        nodes[no].v = true;
        ret.add(no);
        for (int ch : nodes[no].n) {
            if (nodes[ch].v)
                continue;
            nodes[ch].v = true;
            s.add(ch);
        }
    }
    return new HashSet<>(ret);
}