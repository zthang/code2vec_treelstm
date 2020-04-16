public void time(String s) {
    long time = System.currentTimeMillis() - startTime;
    println(s + "(" + time + ")");
}