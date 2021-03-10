import java.util.*;
// Implementing the remote interface
public class MSTImplementation implements MSTInterface {

   public class Graph
   {
      public int n;

      public class Edge implements Comparable<Edge>
      {
         public int u;
         public int v;
         public int w;

         public int compareTo(Edge cur)
         {
            if(w == cur.w)
            {
               if(v == cur.v)
               {
                  return u - cur.u;
               }

               return v - cur.v;
            }

            return w - cur.w;
         }
      }

      SortedSet <Edge> adj = new TreeSet <Edge> ();

      public void add_edge(int u, int v, int w)
      {
         Edge cur_edge = new Edge();
         cur_edge.u = u;
         cur_edge.v = v;
         cur_edge.w = w;

         adj.add(cur_edge);
      }

      public int kruskals()
      {

      }
   }

   Map <String, Graph> graphs = new HashMap <String, Graph> ();

   // Implementing the interface methods
   public void add_graph(String id, int n)
   {
      Graph new_graph = new Graph();
      new_graph.n = n;
      graphs.put(id, new_graph);
   }

   public void add_edge(String id, int u, int v, int w)
   {
      graphs.get(id).add_edge(u, v, w);
   }

   public int get_mst(String id)
   {
      return graphs.get(id).kruskals();
   }
}
