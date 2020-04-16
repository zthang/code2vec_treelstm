void setPartition(boolean[] col) {
    for (int i = 0; i < col.length; i++) {
        col[i] = (ThreadLocalRandom.current().nextBoolean());
    }
}