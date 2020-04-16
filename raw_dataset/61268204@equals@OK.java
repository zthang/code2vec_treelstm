@Override
public boolean equals(Object obj) {
    if (obj instanceof Pair) {
        Pair o = (Pair) obj;
        return o.a == a && o.b == b;
    }
    return false;
}