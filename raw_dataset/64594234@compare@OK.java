@Override
public int compare(Tuple o1, Tuple o2) {
    if (o1.ves == o2.ves && o1.to == o2.to)
        return Integer.compare(o1.from, o2.from);
    if (o1.ves == o2.ves)
        return Integer.compare(o1.to, o2.to);
    return Long.compare(o1.ves, o2.ves);
}