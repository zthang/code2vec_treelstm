public int compareTo(Node x) {
    if (this.val > x.val)
        return -1;
    if (this.val < x.val)
        return 1;
    return 0;
}