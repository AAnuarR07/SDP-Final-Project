package factory.product;

import java.time.LocalDate;

public abstract class BasePhoto implements Photo {
    protected final String name;
    protected final int sizeKb;
    protected final LocalDate date;

    protected BasePhoto(String name, int sizeKb, LocalDate date) {
        this.name = name;
        this.sizeKb = sizeKb;
        this.date = date;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSizeKb() {
        return sizeKb;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }
}