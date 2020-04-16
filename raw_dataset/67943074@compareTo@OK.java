public int compareTo(Vertex v) {
    int c = Integer.compare(degree, v.degree);
    if (c == 0)
        c = Integer.compare(id, v.id);
    return c;
}