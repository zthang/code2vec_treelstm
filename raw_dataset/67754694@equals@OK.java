@Override
public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o == null || getClass() != o.getClass())
        return false;
    Trio piece = (Trio) o;
    return a == piece.a && b == piece.b && c == piece.c;
}