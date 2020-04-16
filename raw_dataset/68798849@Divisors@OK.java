public static ArrayList Divisors(long n) {
    ArrayList<Long> div = new ArrayList<>();
    for (long i = 1; i <= Math.sqrt(n); i++) {
        if (n % i == 0) {
            div.add(i);
            if (n / i != i)
                div.add(n / i);
        }
    }
    return div;
}