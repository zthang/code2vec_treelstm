void processTodo(Integer element) {
    if (!done[element]) {
        done[element] = true;
        todo.add(element);
    }
    count++;
    while (!todo.isEmpty()) {
        Iterator<Integer> kt = todo.iterator();
        Integer toProcess = kt.next();
        kt.remove();
        removing++;
        if (!remaining.isEmpty())
            processRemaining(toProcess);
    }
}