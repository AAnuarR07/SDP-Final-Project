package factory.creator;

import factory.product.Photo;
import java.time.LocalDate;

public abstract class PhotoFactory {
    protected abstract Photo createPhoto(String name, int sizeKb, LocalDate date);

    public Photo create(String name, int sizeKb, LocalDate date) {
        Photo photo = createPhoto(name, sizeKb, date);
        System.out.println("[Factory] Created " + photo.describe());
        return photo;
    }
}