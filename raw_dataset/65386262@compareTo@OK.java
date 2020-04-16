// Comparator function used for sorting edges
// based on their weight
public int compareTo(Edge compareEdge) {
    return this.weight - compareEdge.weight;
}