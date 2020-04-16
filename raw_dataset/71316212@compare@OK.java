public int compare(Trip t1, Trip t2) {
    if (t1.rd == t2.rd)
        return t1.id - t2.id;
    return t2.rd - t1.rd;
}