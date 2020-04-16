public int compareTo(Node o) {
    if (deg != o.deg)
        return Integer.compare(deg, o.deg);
    return Integer.compare(id, o.id);
}