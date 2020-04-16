@Override
public int compareTo(Data o) {
    if (a == o.a) {
        return Integer.compare(b, o.b);
    }
    return Integer.compare(a, o.a);
}