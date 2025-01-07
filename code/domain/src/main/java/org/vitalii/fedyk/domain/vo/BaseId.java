package org.vitalii.fedyk.domain.vo;

import java.util.Objects;

public class BaseId <ID>{
    private final ID id;

    public BaseId(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BaseId<?> baseId = (BaseId<?>) o;
        return Objects.equals(id, baseId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}