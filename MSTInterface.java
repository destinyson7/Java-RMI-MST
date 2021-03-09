import java.rmi.Remote;
import java.rmi.RemoteException;

// Creating Remote interface for our application
public interface MSTInterface extends Remote {

   public void add_graph(String id, int n)
      throws RemoteException;

   public void add_edge(String id, int u, int v, int w)
      throws RemoteException;

   public int get_mst(String id)
      throws RemoteException;
}
