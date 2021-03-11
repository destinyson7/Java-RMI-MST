import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends MSTImplementation
{
   public Server() {}

   public static void main(String args[])
   {
      try
      {
         // Instantiating the implementation class
         MSTImplementation obj = new MSTImplementation();

         // Exporting the object of implementation class
         // (here we are exporting the remote object to the stub)
         MSTInterface stub = (MSTInterface) UnicastRemoteObject.exportObject(obj, 0);

         // Binding the remote object (stub) in the registry
         String host = "127.0.0.1";
         int port = Integer.parseInt(args[0]);
         LocateRegistry.createRegistry(port);
         Registry registry = LocateRegistry.getRegistry(host, port);

         registry.bind("MSTInterface", stub);
         System.err.println("Server ready");
      }

      catch (Exception e)
      {
         System.err.println("Server exception: " + e.toString());
         e.printStackTrace();
      }
   }
}
