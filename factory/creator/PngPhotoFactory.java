package factory.creator;

import factory.product.PngPhoto;
import factory.product.Photo;
import java.time.LocalDate;

public class PngPhotoFactory extends PhotoFactory {
    @Override
    protected Photo createPhoto(String name, int sizeKb, LocalDate date) {
        return new PngPhoto(name, sizeKb, date);
    }
}