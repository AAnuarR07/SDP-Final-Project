package factory.creator;

import factory.product.JpegPhoto;
import factory.product.Photo;
import java.time.LocalDate;

public class JpegPhotoFactory extends PhotoFactory {
    @Override
    protected Photo createPhoto(String name, int sizeKb, LocalDate date) {
        return new JpegPhoto(name, sizeKb, date);
    }
}