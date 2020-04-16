public static void repeat(int times, Runnable runnable) {
    repeat(times, (a) -> runnable.run());
}