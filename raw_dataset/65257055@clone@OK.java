public Structure clone() {
    try {
        Structure struct = (Structure) super.clone();
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (Modifier.isTransient(field.getModifiers())) {
                continue;
            }
            field.set(struct, field.get(this));
        }
        return struct;
    } catch (CloneNotSupportedException e) {
        throw new AssertionError("Cloning a structure should always be supported - please report this bug", e);
    } catch (IllegalAccessException e) {
        throw new RuntimeException("Can't access my own elements!", e);
    }
}