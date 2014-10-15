package jfxpojobinding;

/**
 *
 * @author Mario
 */
public class PojoB {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PojoB{" + name + '}';
    }
    
}
