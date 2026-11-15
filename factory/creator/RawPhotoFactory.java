package factory.creator;

import factory.product.RawPhoto;
import factory.product.Photo;
import java.time.LocalDate;

public class RawPhotoFactory extends PhotoFactory {
    @Override
    protected Photo createPhoto(String name, int sizeKb, LocalDate date) {
        return new RawPhoto(name, sizeKb, date);
    }
}