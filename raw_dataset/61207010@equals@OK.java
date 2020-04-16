@Override
public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o == null || getClass() != o.getClass())
        return false;
    Domino domino = (Domino) o;
    return a == domino.a && b == domino.b;
}