package strategy.context;

import factory.product.Photo;
import java.util.ArrayList;
import java.util.List;
import strategy.strategy.SortStrategy;

public class GallerySorter {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Photo> sort(List<Photo> photos) {
        System.out.println("[Strategy] Sorting by " + strategy.getName());
        List<Photo> sorted = new ArrayList<>(photos);
        sorted.sort(strategy.getComparator());
        return sorted;
    }
}