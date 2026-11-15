package factory.product;

import java.time.LocalDate;

public class RawPhoto extends BasePhoto {
    public RawPhoto(String name, int sizeKb, LocalDate date) {
        super(name, sizeKb, date);
    }

    @Override
    public String getFormat() {
        return "RAW";
    }
}