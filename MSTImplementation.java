import java.util.*;
// Implementing the remote interface
public class MSTImplementation implements MSTInterface {

   // Implementing the interface methods
   public void add_graph(String id, int n)
      throws RemoteException;

   public void add_edge(String id, int u, int v, int w)
      throws RemoteException;

   public int get_mst(String id)
      throws RemoteException;
}
