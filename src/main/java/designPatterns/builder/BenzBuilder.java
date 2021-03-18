package designPatterns.builder;

import java.util.ArrayList;

public class BenzBuilder  extends CarBuilder {
    private BenzModel benz = new BenzModel();
    public CarModel getCarModel() {
        return this.benz;
    }
    public void setSequence(ArrayList sequence) {
        this.benz.setSequence(sequence);
    }
}