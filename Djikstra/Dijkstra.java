/**
 * Dijkstra editted by Ecclesiastes Gan, UNI: efg2123
 */
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Dijkstra {

  // Keep a fast index to nodes in the map
  private Map<String, Vertex> vertexNames;

  /**
   * Construct an empty Dijkstra with a map. The map's key is the name of a vertex
   * and the map's value is the vertex object.
   */
  public Dijkstra() {
    vertexNames = new HashMap<String, Vertex>();
  }

  /**
   * Adds a vertex to the dijkstra. Throws IllegalArgumentException if two vertices
   * with the same name are added.
   *
   * @param v
   *          (Vertex) vertex to be added to the dijkstra
   */
  public void addVertex(Vertex v) {
    if (vertexNames.containsKey(v.name))
      throw new IllegalArgumentException("Cannot create new vertex with existing name.");
    vertexNames.put(v.name, v);
  }

  /**
   * Gets a collection of all the vertices in the dijkstra
   *
   * @return (Collection<Vertex>) collection of all the vertices in the dijkstra
   */
  public Collection<Vertex> getVertices() {
    return vertexNames.values();
  }

  /**
   * Gets the vertex object with the given name
   *
   * @param name
   *          (String) name of the vertex object requested
   * @return (Vertex) vertex object associated with the name
   */
  public Vertex getVertex(String name) {
    return vertexNames.get(name);
  }

  /**
   * Adds a directed edge from vertex u to vertex v
   *
   * @param nameU
   *          (String) name of vertex u
   * @param nameV
   *          (String) name of vertex v
   * @param cost
   *          (double) cost of the edge between vertex u and v
   */
  public void addEdge(String nameU, String nameV, Double cost) {
    if (!vertexNames.containsKey(nameU))
      throw new IllegalArgumentException(nameU + " does not exist. Cannot create edge.");
    if (!vertexNames.containsKey(nameV))
      throw new IllegalArgumentException(nameV + " does not exist. Cannot create edge.");
    Vertex sourceVertex = vertexNames.get(nameU);
    Vertex targetVertex = vertexNames.get(nameV);
    Edge newEdge = new Edge(sourceVertex, targetVertex, cost);
    sourceVertex.addEdge(newEdge);
  }

  /**
   * Adds an undirected edge between vertex u and vertex v by adding a directed
   * edge from u to v, then a directed edge from v to u
   *
   * @param nameU
   *          (String) name of vertex u
   * @param nameV
   *          (String) name of vertex v
   * @param cost
   *          (double) cost of the edge between vertex u and v
   */
  public void addUndirectedEdge(String nameU, String nameV, double cost) {
    addEdge(nameU, nameV, cost);
    addEdge(nameV, nameU, cost);
  }

  // STUDENT CODE STARTS HERE

  /**
   * Computes the euclidean distance between two points as described by their
   * coordinates
   *
   * @param ux
   *          (double) x coordinate of point u
   * @param uy
   *          (double) y coordinate of point u
   * @param vx
   *          (double) x coordinate of point v
   * @param vy
   *          (double) y coordinate of point v
   * @return (double) distance between the two points
   */

	  public double computeEuclideanDistance(double ux, double uy, double vx, double vy) {
		  //Formula that computes the Euclidean distance using the euclidean formula
		  //couldn't remember what the formula was so I wikied Euclidean formula
		    return Math.sqrt(Math.pow(ux - vx, 2) + Math.pow(uy - vy, 2));
		  }

  /**
   * Calculates the euclidean distance for all edges in the map using the
   * computeEuclideanCost method.
   */
  public void computeAllEuclideanDistances() {
	  for (Vertex u : getVertices())//for loop that gets all the values of the vertices stored in a collection
	      for (Edge uv : u.adjacentEdges) {//for loop that gets the adjacent edges of each vertices as we go through
	    	  //i.e. Vancouver's adjacent edges are Seattle and Calgary
	        Vertex v = uv.target; //sets Seattle as target
	        uv.distance = computeEuclideanDistance(u.x, u.y, v.x, v.y);//calculates the distance from e.g. Vancouver to Seattle
	      }
	  }

  /**
   * Dijkstra's Algorithm.
   *
   * @param s
   *          (String) starting city name
   *          Ecclesiastes' Comments: TBH i didn't know how to do it with a list.
   *          So i did it with a PriorityQueue instead
   */
  public void doDijkstra(String s) {
	  PriorityQueue<Vertex> queue = new PriorityQueue<>();//instantiates a PQ
	  /* this for loop essentially does the first step of the dijkstra algorithm whereby we go to
	   * every vertice and set it to unknown, distance = infinity, and pv to null!
	   */
	    for (Vertex u : getVertices()) {
	      u.known = false;
	      u.distance = Double.POSITIVE_INFINITY;
	      u.prev = null;

	    }

	    Vertex v;
	    Vertex u = vertexNames.get(s);//assign the starting city

	    u.known = true;//set it to known
	    u.distance = 0;//distance is therefore 0
	    queue.offer(u);//i offer it to the pq.

	    Vertex next;//instantiate a next vertex variable
	    while (!queue.isEmpty()) {//queue should definitely not be empty
	      next = queue.poll();//first thing in the queue to be pulled off should be shortest distance

	      u = next;//set it to u again because if i don't it messes with the rest of the cities

	      u.known = true;

	      for (Edge uv : u.adjacentEdges) {//get the adjacent edges
	        v = uv.target;//set the target
	        System.out.println("Target: " + v);
	        if (!v.known && (u.distance + uv.distance < v.distance)) {
	          queue.remove(v);//for existing queues, if v exists in the queue already remove it, prevent's more than one v in queue
	          v.prev = u;//sets v's prev to u
	          v.distance = uv.distance + u.distance;//sets v's distance
	          queue.offer(v);//offer it back to queue
	        }
	      }
	    }
	  }
  /**
   * Returns a list of edges for a path from city s to city t. This will be the
   * shortest path from s to t as prescribed by Dijkstra's algorithm
   *
   * @param s
   *          (String) starting city name
   * @param t
   *          (String) ending city name
   * @return (List<Edge>) list of edges from s to t
   */
  public List<Edge> getDijkstraPath(String s, String t) {
    doDijkstra(s);//do dijkstra's on starting city

    List<Edge> paths = new LinkedList<>();//instantiate a list to store the paths

    Vertex v = vertexNames.get(t);//get the name of the ending city

    // Follow backpointers and insert new edges
    while (v.prev != null) {//while loop that gets the path of dijkstra path found
      paths.add(getPath(v.prev, v ));
      v = v.prev;
    }
    Collections.reverse(paths);//because the path found is in reverse order i.e end to start i reverse it
    return paths;
  }
  private Edge getPath(Vertex vprev, Vertex v){// private method to get paths
	  for(Edge e : v.prev.adjacentEdges){
		  if(e.target == v)
			  return e;
	  }
	  return null;
  }
  /*
   * private method to calculate total distance of the dijkstra path found
   */
  public static double getTotalDistanceOfDijkstra(List<Edge> paths){
	  double totalDistance = 0.0;
	  for(Edge u : paths){
		  totalDistance += u.distance;
	  }
	  return totalDistance;
  }

  // STUDENT CODE ENDS HERE

  /**
   * Prints out the adjacency list of the dijkstra for debugging
   */
  public void printAdjacencyList() {
    for (String u : vertexNames.keySet()) {
      StringBuilder sb = new StringBuilder();
      sb.append(u);
      sb.append(" -> [ ");
      for (Edge e : vertexNames.get(u).adjacentEdges) {
        sb.append(e.target.name);
        sb.append("(");
        sb.append(e.distance);
        sb.append(") ");
      }
      sb.append("]");
      System.out.println(sb.toString());
    }
  }


  /**
   * A main method that illustrates how the GUI uses Dijkstra.java to
   * read a map and represent it as a graph.
   * You can modify this method to test your code on the command line.
   */
  public static void main(String[] argv) throws IOException {
    String vertexFile = "cityxy.txt";
    String edgeFile = "citypairs.txt";

    Dijkstra dijkstra = new Dijkstra();
    String line;

    // Read in the vertices
    BufferedReader vertexFileBr = new BufferedReader(new FileReader(vertexFile));
    while ((line = vertexFileBr.readLine()) != null) {
      String[] parts = line.split(",");
      if (parts.length != 3) {
        vertexFileBr.close();
        throw new IOException("Invalid line in vertex file " + line);
      }
      String cityname = parts[0];
      int x = Integer.valueOf(parts[1]);
      int y = Integer.valueOf(parts[2]);
      Vertex vertex = new Vertex(cityname, x, y);
      dijkstra.addVertex(vertex);
    }
    vertexFileBr.close();

    BufferedReader edgeFileBr = new BufferedReader(new FileReader(edgeFile));
    while ((line = edgeFileBr.readLine()) != null) {
      String[] parts = line.split(",");
      if (parts.length != 3) {
        edgeFileBr.close();
        throw new IOException("Invalid line in edge file " + line);
      }
      dijkstra.addUndirectedEdge(parts[0], parts[1], Double.parseDouble(parts[2]));
    }
    edgeFileBr.close();

    // Compute distances.
    // This is what happens when you click on the "Compute All Euclidean Distances" button.
    dijkstra.computeAllEuclideanDistances();

    // print out an adjacency list representation of the graph
    dijkstra.printAdjacencyList();

    // This is what happens when you click on the "Draw Dijkstra's Path" button.

    // In the GUI, these are set through the drop-down menus.
    String startCity = "SanFrancisco";
    String endCity = "Boston";

    // Get weighted shortest path between start and end city.
    List<Edge> path = dijkstra.getDijkstraPath(startCity, endCity);

    System.out.print("Shortest path between "+startCity+" and "+endCity+": ");
    System.out.println(path);
    System.out.println("Total Distance equals: " + getTotalDistanceOfDijkstra(path));
  }

}
