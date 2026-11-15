package strategy.strategy;

import factory.product.Photo;
import java.util.Comparator;

public interface SortStrategy {
    String getName();
    Comparator<Photo> getComparator();
}