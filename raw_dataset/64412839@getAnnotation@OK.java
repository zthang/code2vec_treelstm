private static ContestSubmission getAnnotation(Class<? extends AbstractSubmission> clss) {
    if (!clss.isAnnotationPresent(ContestSubmission.class)) {
        throw new RuntimeException("ContestSubmission annotation not present on class " + clss.getCanonicalName() + "!");
    }
    return clss.getAnnotation(ContestSubmission.class);
}