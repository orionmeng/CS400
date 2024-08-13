import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SearchBackEndTests {
  /*
  public static boolean BackEndDeveloper_test() {
    SearchBackEnd backEnd = new SearchBackEnd();
    MovieData movie32a = new MovieData("m32", 2, 2001);
    MovieData movie32b = new MovieData("m32", 3, 2003);
    MovieData movie57 = new MovieData("m57", 57, 2003);
    MovieData movie62 = new MovieData("m62", 62, 2001);
    MovieData movie79 = new MovieData("m79", 79, 2002);
    MovieData movie81 = new MovieData("m81", 81, 2003);
    MovieData movie93 = new MovieData("m93", 93, 2003);
    MovieData movie97 = new MovieData("m97", 97, 2003);
    backEnd.insertMovie(movie32a);
    backEnd.insertMovie(movie32b);
    backEnd.insertMovie(movie57);
    backEnd.insertMovie(movie62);
    backEnd.insertMovie(movie79);
    backEnd.insertMovie(movie81);
    backEnd.insertMovie(movie93);
    backEnd.insertMovie(movie97);
    System.out.println(backEnd.getTree());
    System.out.println("Search for nonexistent movie (expected: false): "
    +backEnd.searchMovie("m1"));
    System.out.println("Search for existent movie (expected: true): "
    +backEnd.searchMovie("m32"));
    System.out.println("Search for rating of movie named m32 (expected: 2.0): "
    +backEnd.getRating("m32",2001));
    System.out.println("Search for rating of another movie named m32 (expected: 3.0): "
    +backEnd.getRating("m32",2003));
  }
  */

  /*
   * Test case for SearchBackEnd.insertMovie(MovieData movie).
   * @author Orion Meng (Back End Developer)
   */
  @Test
  public static void BackEndDeveloper_testInsert() {
    SearchBackEnd backEnd = new SearchBackEnd();
    MovieData movie32a = new MovieData("m32", 2, 2001);
    MovieData movie32b = new MovieData("m32", 3, 2003);
    MovieData movie32d = new MovieData("m31", 1, 2001);
    backEnd.insertMovie(movie32a);
    backEnd.insertMovie(movie32b);
    backEnd.insertMovie(movie32d);
    assertEquals("Movies:\n"
        + "m31, 1.0\n"
        + "m32, 2.0\n"
        + "m32, 3.0\n",
        backEnd.getTree());
  }

  /*
   * Test case for SearchBackEnd.searchMovie(String title).
   * @author Orion Meng (Back End Developer)
   */
  @Test
  public static void BackEndDeveloper_testSearch() {
    SearchBackEnd backEnd = new SearchBackEnd();
    MovieData movie57 = new MovieData("m57", 57, 2003);
    MovieData movie62 = new MovieData("m62", 62, 2001);
    MovieData movie79 = new MovieData("m79", 79, 2002);
    MovieData movie81 = new MovieData("m81", 81, 2003);
    MovieData movie93 = new MovieData("m93", 93, 2003);
    MovieData movie97 = new MovieData("m97", 97, 2003);
    backEnd.insertMovie(movie57);
    backEnd.insertMovie(movie62);
    backEnd.insertMovie(movie79);
    backEnd.insertMovie(movie81);
    backEnd.insertMovie(movie93);
    backEnd.insertMovie(movie97);
    assertEquals(false, backEnd.searchMovie("m1"));
    assertEquals(true, backEnd.searchMovie("m57"));
  }

  /*
   * Test case for SearchBackEnd.getRating(String title, int year).
   * @author Orion Meng (Back End Developer)
   */
  @Test
  public static void BackEndDeveloper_testRating() {
    SearchBackEnd backEnd = new SearchBackEnd();
    MovieData movie32a = new MovieData("m32", 2, 2001);
    MovieData movie32b = new MovieData("m32", 3, 2003);
    MovieData movie32d = new MovieData("m31", 1, 2001);
    backEnd.insertMovie(movie32a);
    backEnd.insertMovie(movie32b);
    backEnd.insertMovie(movie32d);
    assertEquals(true, backEnd.getRating("m32", 2001) == 2.0);
    assertEquals(true, backEnd.getRating("m32", 2003) == 3.0);
    assertEquals(true, backEnd.getRating("m31", 2001) == 1.0);
  }

  /*
   * Test case for SearchBackEnd.getTree().
   * @author Orion Meng (Back End Developer)
   */
  @Test
  public static void BackEndDeveloper_testTree() {
    SearchBackEnd backEnd = new SearchBackEnd();
    MovieData movie32a = new MovieData("m32", 2, 2001);
    MovieData movie32b = new MovieData("m32", 3, 2003);
    MovieData movie57 = new MovieData("m57", 5.7, 2003);
    MovieData movie62 = new MovieData("m62", 6.2, 2001);
    MovieData movie79 = new MovieData("m79", 7.9, 2002);
    MovieData movie81 = new MovieData("m81", 8.1, 2003);
    MovieData movie93 = new MovieData("m93", 9.3, 2003);
    MovieData movie97 = new MovieData("m97", 9.7, 2003);
    backEnd.insertMovie(movie32a);
    backEnd.insertMovie(movie32b);
    backEnd.insertMovie(movie57);
    backEnd.insertMovie(movie62);
    backEnd.insertMovie(movie79);
    backEnd.insertMovie(movie81);
    backEnd.insertMovie(movie93);
    backEnd.insertMovie(movie97);
    assertEquals("Movies:\n"
      +"m32, 2.0\n"
      +"m32, 3.0\n"
      +"m57, 5.7\n"
      +"m62, 6.2\n"
      +"m79, 7.9\n"
      +"m81, 8.1\n"
      +"m93, 9.3\n"
      +"m97, 9.7\n",
      backEnd.getTree());
  }

  /*
   * Runs all test methods.
   */
  public static void main(String[] args) {
    //BackEndDeveloper_test();
    BackEndDeveloper_testInsert();
    BackEndDeveloper_testSearch();
    BackEndDeveloper_testRating();
    BackEndDeveloper_testTree();
  }
}
