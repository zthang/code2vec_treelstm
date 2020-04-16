/*Template Stuff*/
ArrayList<Long> getDiv(long num) {
    long square_root = (long) sqrt(num) + 1;
    ArrayList<Long> l = new ArrayList<>();
    for (long i = 1; i < square_root; i++) {
        if (num % i == 0 && i * i != num) {
            l.add(i);
            l.add(num / i);
        }
        if (num % i == 0 && i * i == num)
            l.add(i);
    }
    return l;
}