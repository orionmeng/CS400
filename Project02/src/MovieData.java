import javax.swing.plaf.ComponentInputMapUIResource;
interface MovieDataInterface {
    public String getTitle();
    public double getRating();
    public int getYear();
    public int compareTo(MovieData other);
    public String toString();
}
/**
 * Data object to store the movie's information
 * @author arthur arwang5@wisc.edu
 */
public class MovieData implements MovieDataInterface, Comparable<MovieData> {
    String title;
    double rating;
    int year;
    /**
     * Creates and initializes variables for the objects
     * @param title Title of the movie
     * @param rating Rating of the movie
     * @param year Year of the movie
     */
    public MovieData(String title, double rating, int year) {
        this.title = title;
        this.rating = rating;
        this.year = year;
    }
    /**
     * Returns the title of the movie
     * @return The title of the movie
     */
    @Override
    public String getTitle() {
        return title;
    }
    /**
     * Returns the rating of the movie
     * @return The rating of the movie
     */
    @Override
    public double getRating() {
        return rating;
    }
    /**
     * Returns the year of the movie
     * @return The year of the movie
     */
    @Override
    public int getYear() {
        return year;
    }

    /**
     * Compares the current MovieData object with another MovieData object
     * @param other The object being compared with
     * @return 1 if this object is greater, -1 if smaller, and 0 if equal
     */
    @Override public int compareTo(MovieData other) {
        if (this.rating != other.getRating()) {
            return (this.rating > other.getRating()) ? 1 : -1;
        } else {
            if (!this.title.equals(other.getTitle())) {
                return (this.title.compareTo(other.getTitle()));
            } else {
                if (this.year != other.getYear()) {
                    return (this.year > other.getYear()) ? 1 : -1;
                } else {
                    return 0;
                }
            }
        }
    }
    /**
     * Returns a string representation of this object
     * @return A string representation of this object
     */
    @Override public String toString() {
        return title + ", " + rating;
    }
}
