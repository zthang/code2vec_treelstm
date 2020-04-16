public static Class<?> primitiveToWrapper(Class<?> clss) {
    return primitiveClassWrappers.getOrDefault(clss, clss);
}