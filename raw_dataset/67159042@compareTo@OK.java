@Override
public int compareTo(node o) {
    if (this.debt >= o.debt) {
        return 1;
    } else {
        return -1;
    }
}