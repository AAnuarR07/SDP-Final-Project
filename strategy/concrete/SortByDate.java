package strategy.concrete;

import factory.product.Photo;
import java.util.Comparator;
import strategy.strategy.SortStrategy;

public class SortByDate implements SortStrategy {
    @Override
    public String getName() {
        return "date (oldest first)";
    }

    @Override
    public Comparator<Photo> getComparator() {
        return Comparator.comparing(Photo::getDate);
    }
}