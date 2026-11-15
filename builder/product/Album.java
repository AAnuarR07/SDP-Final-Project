package builder.product;

import factory.product.Photo;
import java.util.Collections;
import java.util.List;

public class Album {
    private final String name;
    private final String description;
    private final List<Photo> photos;

    public Album(String name, String description, List<Photo> photos) {
        this.name = name;
        this.description = description;
        this.photos = photos;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Photo> getPhotos() {
        return Collections.unmodifiableList(photos);
    }

    public void addPhoto(Photo photo) {
        photos.add(photo);
    }

    public int getTotalSizeKb() {
        int total = 0;
        for (Photo photo : photos) {
            total += photo.getSizeKb();
        }
        return total;
    }
}