# Photo Gallery App

A Java console project that demonstrates six design patterns working together in one Photo Gallery app.

## Patterns

| Type       | Pattern        | Package     | Role in the project                                              |
|------------|----------------|-------------|------------------------------------------------------------------|
| Creational | Factory Method | `factory`   | Creates JPEG, PNG and RAW photos                                 |
| Creational | Builder        | `builder`   | Assembles an `Album` step by step                                |
| Structural | Adapter        | `adapter`   | Lets a cloud photo be used as a regular `Photo`                  |
| Structural | Facade         | `facade`    | One simple entry point to the whole app                          |
| Behavioral | Strategy       | `strategy`  | Switchable sorting: by name, by date, by size                    |
| Behavioral | Observer       | `observer`  | Listeners react when a new photo is added to the gallery         |

## Project Structure

```
src/
├── Main.java
├── factory/
│   ├── product/    Photo, BasePhoto, JpegPhoto, PngPhoto, RawPhoto
│   └── creator/    PhotoFactory, JpegPhotoFactory, PngPhotoFactory, RawPhotoFactory
├── builder/
│   ├── product/    Album
│   └── builder/    AlbumBuilder
├── adapter/
│   ├── adaptee/    CloudPhoto
│   └── adapter/    CloudPhotoAdapter
├── strategy/
│   ├── strategy/   SortStrategy
│   ├── concrete/   SortByName, SortByDate, SortBySize
│   └── context/    GallerySorter
├── observer/
│   ├── subject/    PhotoPublisher
│   └── listener/   PhotoListener, NotificationListener, StorageListener
└── facade/         GalleryFacade
```

`Main` is the only class outside the pattern packages and it tests everything.

## How the Patterns Work Together

1. `GalleryFacade` uses the **Factory Method** creators to produce photos
2. The **Builder** collects the photos into an `Album`
3. Photos from the cloud go through the **Adapter** and join the same album
4. Every new photo is announced by the **Observer** publisher: `NotificationListener` reports it and `StorageListener` warns when the storage limit is exceeded
5. The **Strategy** sorts the album by name, date or size at runtime
6. The **Facade** hides all of the above behind `addPhoto`, `importFromCloud`, `showSorted` and `printAlbum`

## Design Principles

- **Single Responsibility:** each class has one job.
- **Open/Closed:** new formats, sorting rules or listeners can be added without changing existing classes
- **Liskov Substitution:** all photos, including the adapted cloud photo, are used through `Photo`
- **Interface Segregation:** small interfaces (`Photo`, `SortStrategy`, `PhotoListener`)
- **Dependency Inversion:** high-level code depends on interfaces, not on concrete classes
- **DRY:** shared photo data lives in `BasePhoto` and the description text in `Photo`
- **KISS:** simple classes, no unnecessary abstractions.

## Build and Run

From the project root:
```
java -cp out Main
```

## Action

`Main` runs this scenario:

1. Creates the gallery through the facade: the factories create three photos and the builder assembles the album
2. Prints the album
3. Adds a JPEG photo and imports a photo from the cloud: the observers report both, and the storage warning appears when the 15000 KB limit is exceeded
4. Prints the album again
5. Sorts the album by name, by date and by size

## Example Output

```
[Factory] Created JPEG 'Screenshot' 3200 KB, 2026-08-02
[Observer] New photo added: JPEG 'Screenshot' 3200 KB, 2026-08-02
[Observer] Storage used: 14200 / 15000 KB
[Adapter] Imported CLOUD 'Dinner at relatives house' 5120 KB, 2026-07-30
[Observer] New photo added: CLOUD 'Dinner at relatives house' 5120 KB, 2026-07-30
[Observer] WARNING: storage limit exceeded (19320 / 15000 KB)
[Strategy] Sorting by size (largest first)
```