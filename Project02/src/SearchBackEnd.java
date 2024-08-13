import java.util.NoSuchElementException;

/*
 * The interface for the back end of this program.
 * @author Orion Meng
 */
interface SearchBackEndInterface {
  public void insertMovie(MovieData movie);         // inserts a movie if it does not already exist
  public boolean searchMovie(String title);         // returns true if the movie is found
  public double getRating(String title, int year);  // returns the rating of the movie
  public String getTree();                          // returns a list of all movies in the tree
}

/*
 * The back end of this program.
 * @author Orion Meng
 */
public class SearchBackEnd implements SearchBackEndInterface {
  
  protected RedBlackTree tree = new RedBlackTree<>();       // primary tree
  protected RedBlackTree titles = new RedBlackTree<>();     // secondary tree
  
  /*
   * Inserts a movie if it does not already exist.
   * @param movie - movie to be inserted.
   */
  @Override
  public void insertMovie(MovieData movie) {
    tree.insert(movie);
    titles.insert(movie.getTitle());
  }
  
  /*
   * Returns true if the title of a movie in the RedBlackTree matches the given title.
   * @param title - title to be searched for.
   * @return true if the title of a movie in the RedBlackTree matches the given title.
   */
  @Override
  public boolean searchMovie(String title) {
    return titles.contains(title);
  }
  
  /*
   * Returns the rating of the movie that corresponds to the given title/year.
   * @param title - title of the movie.
   * @param year - year of the movie.
   * @return the rating of the movie that corresponds to the given title/year.
   * @throws NoSuchElementException if no movie in the RedBlack tree matches the given title/year.
   */
  @Override
  public double getRating(String title, int year) throws NoSuchElementException {
    double rating = -1;
    for (int i = 0; i < 11; i++) {
      for (double j = 0; j < 10; j++) {
        if (i == 10 && j >= 1) {
          break;
        }
        double k = j/10;
        k += i;
        MovieData temp = new MovieData(title,k,year);
        if (tree.contains(temp)) {
          rating = k;
          break;
        }
        if (rating > 0) {
          break;
        }
      }
      if (rating > 0) {
        break;
      }
    }
    if (rating < 0) {
      throw new NoSuchElementException("Movie not found; "
          + "please enter the full title and year of the movie.");
    }
    return rating;
  }
  
  /*
   * Returns a string representation of all movies in the RedBlackTree.
   * Primarily organized by rating.
   * If two ratings are equal, then organized by title.
   * If two titles are identical, then organized by year.
   * 
   * Movies:
   * Hello, 10.0
   * Hello, 9.0
   * World, 0.0
   * 
   * @return a string representation of all movies in the RedBlackTree.
   */
  @Override
  public String getTree() {
    return tree.toString();
  }
}

/*
 * The placeholder for the back end of this program.
 * @author Orion Meng
 */
class SearchBackEndPlaceholder implements SearchBackEndInterface {
  private MovieData onlyMovie = new MovieData("title",10.0,1999);
  public void insertMovie(MovieData movie) {
    this.onlyMovie = movie;
  }
  @Override
  public boolean searchMovie(String title) {
    return onlyMovie.getTitle().equals(title);
  }
  @Override
  public double getRating(String title, int year) throws NoSuchElementException {
    if (!title.equals(onlyMovie.getTitle())) {
      throw new NoSuchElementException();
    }
    if (year != onlyMovie.getYear()) {
      throw new NoSuchElementException();
    }
    return onlyMovie.getRating();
  }
  @Override
  public String getTree() {
    return "Movies:\n"+onlyMovie.getTitle()+", "+onlyMovie.getRating()+"\n";
  }
}
