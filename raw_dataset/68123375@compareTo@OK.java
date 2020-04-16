@Override
public int compareTo(Pair o) {
    return this.first != o.first ? this.first - o.first : this.second - o.second;
}