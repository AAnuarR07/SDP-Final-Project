package strategy.concrete;

import factory.product.Photo;
import java.util.Comparator;
import strategy.strategy.SortStrategy;

public class SortByName implements SortStrategy {
    @Override
    public String getName() {
        return "name (A-Z)";
    }

    @Override
    public Comparator<Photo> getComparator() {
        return Comparator.comparing(Photo::getName);
    }
}