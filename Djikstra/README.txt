README.txt
Compiling Instructions: javac Dijkstra.java Edge.java Vertex.java Display.java

Dijkstra.java
Run: java Dijkstra cityxy.txt citypairs.txt
Please run them in this format as switching the file names will throw an error in the code

Lets get right down to business
Vertex.java
_________________
modified vertex.java to implement compareable so as to be able to compare vertex values in Dijkstra.java,
as i did not want to create an inner class in order to compare vertexNames
Overrided the compare method.

Edge.java
__________________
Nothing modified
__________________
Dijkstra.java)__________
made the methods public method that compute's euclidean distance according to the euclid's distance formula according to wikipedia
https://en.wikipedia.org/wiki/Euclidean_distance
then made a private method that compute's all the euclidean distances of the vertexes in the collection using the above's public method to compute

started with doDijkstra method, didn't know how to make it with a list so i did it with a PQ, even though Professor Blaer said not to, cause it might
not fulfill the Big O time complexity, but I think mine does.

First step of the code, is the first step of the dijkstra algorithm:
I go through all the vertices of the collection:
set it all to unknown, set all distances to infinity, set all previous to null

i then get the first vertice of the starting city, set it to known, set distance to 0, prev remains null as start does not have prev
offer it to a PQ
The reason i use a PQ is that the shortest distance will always be the item polled off in a PQ which is exactly what i want to happen for Dijkstra

I then get the next vertices, checks it's adjacent edges, check if the next vertice is know, and if it is not known and the distance of u + uv < v
i remove v if it exists in the queue already , set v's prev as u, set v's distance as uv + u, and offer it back to queue

Next Method getDijkstraPath, takes in both start and end cities
first step send the startcity to doDijkstra method
creates a list to store paths,
get the end city vertex
checks if v.prev == null, if it does not, add the path using getPath helper method,
This creates a path in reverse order just like how dijkstra algorithm does, so i reverse it using COllections.reverse
and walah u have your dijkstra path

two small helper methods
get path, which returns the path of the the prev v

second totalDistance of the dijkstra path:
calculates total distance of the dijkstra path found and returns it


Display.java
Run: java Display

made slight modification did not allow start city and end city to be the same. as creates an infinite loop.
end the GUI if done so.
