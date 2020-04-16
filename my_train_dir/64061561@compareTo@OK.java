@Override
public int compareTo(Node o) {
    if (this.val < o.val)
        return -1;
    if (this.val > o.val)
        return 1;
    return 0;
}