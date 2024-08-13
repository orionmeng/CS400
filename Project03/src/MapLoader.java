import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Interface for MapLoader.
 * @author Orion Meng
 */
interface MapLoaderInterface {
  public List<MapDataInterface> loadCSVFile(String path) throws FileNotFoundException;
  public List<MapDataInterface> loadDirectoryFiles(String path) throws FileNotFoundException;
}

/*
 * Loads map information from CSV file.
 * @author Orion Meng
 */
public class MapLoader implements MapLoaderInterface {
  @Override
  public List<MapDataInterface> loadCSVFile(String path) throws FileNotFoundException {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public List<MapDataInterface> loadDirectoryFiles(String path) throws FileNotFoundException {
    // TODO Auto-generated method stub
    return null;
  }
}
