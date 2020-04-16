@Override
public int compareTo(Pair<T, U> o) {
    return (int) (this.a.equals(o.a) ? this.b.equals(o.b) ? 0 : ((Long) this.b - (Long) o.b) / Math.abs((Long) this.b - (Long) o.b) : ((Long) this.a - (Long) o.a) / Math.abs((Long) this.a - (Long) o.a));
}