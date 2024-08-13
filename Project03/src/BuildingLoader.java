import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Interface for MapLoader.
 * @author Orion Meng
 */
interface BuildingLoaderInterface {
  public List<BuildingDataInterface> loadFile(String path) throws FileNotFoundException;
  public List<BuildingDataInterface> loadDirectoryFiles(String path) throws FileNotFoundException;
}

/*
 * Loads map information from CSV file.
 * @author Orion Meng
 */
public class BuildingLoader implements BuildingLoaderInterface {

  /*
   * Loads a CSV file of BuildingData objects.
   * @param filePath path of CSV file
   * @return buildings list representation of CSV file
   * @throws FileNotFoundException if CSV file not found
   */
  @Override
  public List<BuildingDataInterface> loadFile(String filePath)
      throws FileNotFoundException {
    File file = new File(filePath); // load file
    Scanner scnr = new Scanner(file); // scan file
    List<BuildingDataInterface> buildings = new LinkedList<>(); // file contents
    scnr.nextLine(); // skip header
    
    while (scnr.hasNextLine()) {
      String location = scnr.nextLine();
      buildings.add(new BuildingData(location));
    }
    scnr.close();
    return buildings;
  }

  /*
   * Loads multiple CSV files from a directory.
   * @param directoryPath path of directory
   * @return buildings list representation of directory CSV file(s)
   * @throws FileNotFoundException if no CSV files are found
   */
  @Override
  public List<BuildingDataInterface> loadDirectoryFiles(String directoryPath)
      throws FileNotFoundException {
    File folder = new File(directoryPath);
    List<BuildingDataInterface> buildings = new LinkedList<>();
    File[] files = new File(directoryPath).listFiles();
    for (int i = 0; i < files.length; i++) {
      buildings.addAll(loadFile(files[i].getAbsolutePath()));
    }
    return buildings;
  }

}
