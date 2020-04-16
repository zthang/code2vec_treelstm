@Override
public int compare(Pair o1, Pair o2) {
    if (o1.x == o2.x)
        return Integer.compare(o1.y, o2.y);
    return Integer.compare(o1.x, o2.x);
}