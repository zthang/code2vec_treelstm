/*
  PriorityQueue<aksh> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.p < o2.p)
                return 1;
            else if (o1.p > o2.p)
                return -1;
            else
                return 0;
 
        });//decreasing order acc to p*/
static int power(int x, int y, int m) {
    if (y == 0)
        return 1;
    int p = power(x, y / 2, m) % m;
    p = (p * p) % m;
    if (y % 2 == 0)
        return p;
    else
        return (x * p) % m;
}