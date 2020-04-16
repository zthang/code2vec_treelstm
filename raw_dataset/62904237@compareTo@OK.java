@Override
public int compareTo(Pair p) {
    // return first - second < p.first - p.second ? 1 : -1; //first-secondの降順にソート
    return Math.atan2(second, first) > Math.atan2(p.second, p.first) ? 1 : -1;
}