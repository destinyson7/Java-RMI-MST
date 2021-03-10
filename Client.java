import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

public class Client
{
   private Client() {}

   public static void main(String[] args)
   {
      try
      {
         // Getting the registry
         String host = args[0];
         int port = Integer.parseInt(args[1]);
         Registry registry = LocateRegistry.getRegistry(host, port);

         // Looking up the registry for the remote object
         MSTInterface stub = (MSTInterface) registry.lookup("MSTInterface");

         // Calling the remote method using the obtained object
         Scanner scan = new Scanner(System.in);

         while(scan.hasNextLine())
         {
            String current = scan.nextLine();
            String[] arguments = current.split(" ");
            char request = arguments[0].charAt(4);
            String id = arguments[1];

            if(request == 'g')
            {
               int n = Integer.parseInt(arguments[2]);
               stub.add_graph(id, n);
            }

            else if(request == 'e')
            {
               int u = Integer.parseInt(arguments[2]);
               int v = Integer.parseInt(arguments[3]);
               int w = Integer.parseInt(arguments[4]);
               stub.add_graph(id, u, v, w);
            }

            else if(request == 'm')
            {
               System.out.println(stub.get_mst(id));
            }

            else
            {
               assert false;
            }
         }

         // String str = stub.printMsg();
         // System.err.println(str);
         // System.out.println("Remote method invoked");
      }

      catch (Exception e)
      {
         System.err.println("Client exception: " + e.toString());
         e.printStackTrace();
      }
   }
}
