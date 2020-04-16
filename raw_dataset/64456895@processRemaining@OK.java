void processRemaining(Integer toProcess) {
    Iterator<Integer> it = remaining.iterator();
    while (it.hasNext()) {
        Integer x = it.next();
        if (!edges.get(toProcess).contains(x)) {
            if (!done[x]) {
                todo.add(x);
                done[x] = true;
            }
            it.remove();
        }
    }
}