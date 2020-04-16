// @Override
// public int compareTo(Pair o) {
// return this.first != o.first ? o.first - this.first : o.second - this.second;
// }
@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + first;
    result = prime * result + second;
    return result;
}