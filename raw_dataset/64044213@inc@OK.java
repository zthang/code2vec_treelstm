private static List<Integer> inc(List<Integer> C) {
    for (ListIterator<Integer> i = C.listIterator(); i.hasNext(); ) i.set(i.next() + 1);
    return C;
}