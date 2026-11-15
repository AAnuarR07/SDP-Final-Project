package factory.product;

import java.time.LocalDate;

public class JpegPhoto extends BasePhoto {
    public JpegPhoto(String name, int sizeKb, LocalDate date) {
        super(name, sizeKb, date);
    }

    @Override
    public String getFormat() {
        return "JPEG";
    }
}