package factory.product;

import java.time.LocalDate;

public interface Photo {
    String getName();
    String getFormat();
    int getSizeKb();
    LocalDate getDate();

    default String describe() {
        return getFormat() + " '" + getName() + "' " + getSizeKb() + " KB, " + getDate();
    }
}