public int compareTo(Node o) {
    if (sDist != o.sDist)
        return Integer.compare(sDist, o.sDist);
    return Integer.compare(eDist, o.eDist);
}