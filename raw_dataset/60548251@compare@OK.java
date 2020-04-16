@Override
public int compare(pair pair, pair t1) {
    return Integer.compare(pair.a, t1.a) * 2 + Integer.compare(pair.b, t1.b);
}