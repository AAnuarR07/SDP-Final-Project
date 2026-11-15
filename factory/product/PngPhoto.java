package factory.product;

import java.time.LocalDate;

public class PngPhoto extends BasePhoto {
    public PngPhoto(String name, int sizeKb, LocalDate date) {
        super(name, sizeKb, date);
    }

    @Override
    public String getFormat() {
        return "PNG";
    }
}