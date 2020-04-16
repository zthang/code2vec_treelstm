@Override
public int compareTo(Data o) {
    if (a == o.a) {
        return Long.compare(b, o.b);
    }
    return Long.compare(a, o.a);
}