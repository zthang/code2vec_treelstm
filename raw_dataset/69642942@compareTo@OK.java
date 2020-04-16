public int compareTo(Node o) {
    if (this.deg != o.deg)
        return this.deg < o.deg ? -1 : 1;
    if (this.id != o.id)
        return this.id < o.id ? -1 : 1;
    return 0;
}