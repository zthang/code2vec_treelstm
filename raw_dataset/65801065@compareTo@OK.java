@Override
public int compareTo(Bridge o) {
    if (this.count == o.count) {
        return this.value - o.value;
    }
    return this.count - o.count;
}