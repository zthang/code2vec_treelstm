void pop(int u) {
    ArrayList<Edge> list = new ArrayList<>();
    for (; ; ) {
        Edge e = eStack.pop();
        list.add(e);
        if (e.u == u)
            break;
    }
    bccs.add(list);
}