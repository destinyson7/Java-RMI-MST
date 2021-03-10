import java.util.*;
// Implementing the remote interface
public class MSTImplementation implements MSTInterface {

   public class Graph
   {
      public int n;
      public int[] parent;
      public int[] siz;

      Graph(int n)
      {
         this.n = n;
         this.parent = new int[n + 5];
         this.siz = new int[n + 5];
      }

      public class Edge implements Comparable<Edge>
      {
         public int u, v, w;

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

      int find(int u)
      {
         if(parent[u] == u)
         {
            return u;
         }

         return parent[u] = find(parent[u]);
      }

      void union(int u, int v)
      {
         int a = parent[u];
         int b = parent[v];

         if(siz[a] < siz[b])
         {
            parent[a] = b;
            siz[b] += siz[a];
         }

         else
         {
            parent[b] = a;
            siz[a] += siz[b];
         }
      }

      public int kruskals()
      {
         for(int i = 0; i <= n; i++)
         {
            parent[i] = i;
            siz[i] = 1;
         }

         int count = 0, ans = 0;

         for(Edge cur_edge: adj)
         {
            int u = cur_edge.u;
            int v = cur_edge.v;
            int w = cur_edge.w;

            if(find(u) != find(v))
            {
               ans += w;
               count++;

               union(u, v);
            }
         }

         if(count == n - 1)
         {
            return ans;
         }

         else
         {
            return -1;
         }
      }
   }

   Map <String, Graph> graphs = new HashMap <String, Graph> ();

   // Implementing the interface methods
   public void add_graph(String id, int n)
   {
      Graph new_graph = new Graph(n);
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
