import java.util.Objects;

public class Meals {
    private String name;
    private String desc;
    private int price;

    public Meals(String name, String desc, int price) {
        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meals meals = (Meals) o;
        return Objects.equals(name, meals.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
