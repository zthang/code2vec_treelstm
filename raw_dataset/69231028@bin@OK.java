static void bin(int n) {
    if (n > 1)
        bin(n / 2);
    System.out.print(n % 2);
}