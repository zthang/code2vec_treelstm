public int compare(Princess a, Princess b) {
    for (int i = 0; i < Math.min(a.num, b.num); i++) {
        if (a.list.get(i) == b.list.get(i))
            continue;
        return a.list.get(i) - b.list.get(i);
    }
    return a.num - b.num;
}