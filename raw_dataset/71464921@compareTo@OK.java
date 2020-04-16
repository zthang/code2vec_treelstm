@Override
public int compareTo(Pair o) {
    return fromS == o.fromS ? fromT - o.fromT : fromS - o.fromS;
}