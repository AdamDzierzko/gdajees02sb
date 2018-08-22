package pl.coderslab.demospringdata.repository;

public interface BookRepositoryCustom {

    void changeBookTitle(final String oldOne, final String newOne);


    // nazwa doczepianego repository musi się pokrywać z główny repo
    void resetRating(int rating);


}
