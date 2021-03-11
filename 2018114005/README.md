# Distributed Systems Assignment 3
## Java RMI

### Running the code
I have used Java for this assignment.

```
javac *.java
java Server <port_number>
java Client 127.0.0.1 <port_number>
```

## Architecture

- Java RMI has been used for the simple client server architecture which supports multiple clients. RMI stands for Remote Method Invocation. It is a mechanism that allows an object residing in one system (JVM) to access/invoke an object running on another JVM.
- RMI provides the ability for the client to remotely call functions which are provided by the server.
- This interface contains the required functions for the Client to invoke and the functions are implemented in an another file which implements this interface.
- The client searches the registry for this interface by using correct host address and port number and then calls the functions after parsing the commands as required.

## Algorithm

- To store multiple graphs, I have used a HashMap which stores the Graph for each graph identifier key.
- To get MST of a graph, I have used Kruskal's Algorithm.
- If the number of edges we get in the MST is not N - 1, then it means that the graph is disconnected and does not have a MST. Hence the answer is -1. (where N is the number of nodes in the graph)
- Else, the weight of the MST is printed.
- Time Complexity of Kruskal's Algorithm is O(M log(M)) where M is the number of edges.

## Results and Observations

For a graph with 10<sup>5</sup> Nodes and around the same number of edges, it takes just above 3 seconds to return the final weight of the MST.


### Assignment by
- Tanish Lad (2018114005)
