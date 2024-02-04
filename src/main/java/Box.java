import java.util.ArrayList;
import java.util.List;

class Box<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public double getWeight() {
        if (fruits.isEmpty()) {
            return 0.0;
        }
        double weight = fruits.get(0) instanceof Apple ? 1.0 : 1.5;
        return weight * fruits.size();
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public void transferFruitsToAnotherBox(Box<T> anotherBox) {
        if (this.getClass() == anotherBox.getClass()) {
            anotherBox.fruits.addAll(this.fruits);
            this.fruits.clear();
        } else {
            System.out.println("Can't transfer fruits to a box of a different type");
        }
    }
}


