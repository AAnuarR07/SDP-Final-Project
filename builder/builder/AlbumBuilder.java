package builder.builder;

import builder.product.Album;
import factory.product.Photo;
import java.util.ArrayList;
import java.util.List;

public class AlbumBuilder {
    private String name = "Untitled Album";
    private String description = "No description";
    private final List<Photo> photos = new ArrayList<>();

    public AlbumBuilder name(String name) {
        this.name = name;
        return this;
    }

    public AlbumBuilder description(String description) {
        this.description = description;
        return this;
    }

    public AlbumBuilder addPhoto(Photo photo) {
        photos.add(photo);
        return this;
    }

    public Album build() {
        return new Album(name, description, photos);
    }
}