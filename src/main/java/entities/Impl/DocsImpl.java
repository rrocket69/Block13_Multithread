package entities.Impl;

import entities.Docs;
import entities.Speciality;

public class DocsImpl implements Docs {
    private Speciality current;

    public DocsImpl(Speciality speciality) {
        current = speciality;
    }

    public Speciality getCurrent() {
        return current;
    }

    @Override
    public String toString() {
        return "DocsImpl{" +
                "current=" + current +
                '}';
    }
}
