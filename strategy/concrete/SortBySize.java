package strategy.concrete;

import factory.product.Photo;
import java.util.Comparator;
import strategy.strategy.SortStrategy;

public class SortBySize implements SortStrategy {
    @Override
    public String getName() {
        return "size (largest first)";
    }

    @Override
    public Comparator<Photo> getComparator() {
        return Comparator.comparingInt(Photo::getSizeKb).reversed();
    }
}