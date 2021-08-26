package model;

public abstract class Model {
    private ID id;

    public Model(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
