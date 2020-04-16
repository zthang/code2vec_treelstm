private void initStep(int capacity) {
    step = RND.nextInt(capacity - 2) + 1;
    while (IntegerUtils.gcd(step, capacity) != 1) {
        step++;
    }
}