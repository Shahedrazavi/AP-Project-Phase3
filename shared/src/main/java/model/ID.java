package model;

import java.util.Objects;

public class ID {
    private int idNumber;

    public ID(int idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ID id = (ID) o;
        return idNumber == id.idNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber);
    }

    @Override
    public String toString() {
        return Integer.toString(idNumber);
    }
}
