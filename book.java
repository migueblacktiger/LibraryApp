class Book {
    private int Id;
    private String title;
    private String author;
    private int publicationYear;
    private int numberOfPages;

    public Book(int Id, String title, String author, int publicationYear, int numberOfPages) {
        this.Id = Id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.numberOfPages = numberOfPages;
    }

    public int getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id='" + Id + '\'' +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}