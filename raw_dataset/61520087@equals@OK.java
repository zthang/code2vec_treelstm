@Override
public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o == null || getClass() != o.getClass())
        return false;
    Vertex vertex = (Vertex) o;
    return num == vertex.num;
}