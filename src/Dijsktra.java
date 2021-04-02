
// Dijkstra's single source shortest path algorithm.
/*Marwa , Haya, Intesar
 * Group project Phase2 
 * 
 * */
import java.util.*;
import java.lang.*;
import java.io.*;
//Haya,Marwa,Intesar
class Dijsktra {
	// ////////////////////////////////////////////////////////////////////////////////////////
	static final int V = 12;
	/////////////////////////////////////////---Print---/////////////////////////////////////////////////////////////
	static void print(int distance[])
	{
		//print row of cities name
		String cities []= new String[]
				 {"Jeddah", "Makkah", "Madinah","Riyadh","Dammam","Taif","Abha","Tabuk","Qasim","Hail","Jizan","Najran"};
		System.out.println("Vertex \t\t|Distance from Source");
		System.out.println("--------------------------------------");
		for (int i = 0; i < V; i++) {
			//print each city with its distance
			System.out.println(cities[i] +"\t\t|" + distance[i]);
		}
	}
   ///////////////////////////////////////---Minmum distance---/////////////////////////////////////////////////////// 
	static int min_Distance(int distance[], Boolean set[])
{
	// Initialize mindistance to compare with it with other distance
   int mindistance = Integer.MAX_VALUE;
   int index = -1;
    for (int i = 0; i < V; i++) {
	// find the vertex with minimum distance value, from the set of vertices not yet included in shortest path tree
if ( (set[i] == false)  &&  (distance[i] <= mindistance) ) {
	mindistance =distance[i];
     index = i;
}
    }   
return index;
}
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// implements Dijkstra's algorithm for a cites Graph using adjacency matrix
static void dijkstra_algorithm(int cities[][], int src)
	{
		int distance[] = new int[V]; // The output array. dist[i] will hold
	    Boolean set[] = new Boolean[V];

		//Initialize all distances as infinite and set[] as false
	 for (int i = 0; i < V; i++) {
		 distance[i] = Integer.MAX_VALUE;
        set[i] = false;
		}
		// Distance src vertex from itself = 0
	 distance[src] = 0;
		// Find shortest path form src to all vertices
		for (int count = 0; count < V - 1; count++) {
			// Pick the minimum distance vertex from the set of vertices not yet processed. in the first iteration u == src
			int u = min_Distance(distance, set);
			set[u] = true;
			// Update distance value of the adjacent vertices of the
			for (int v = 0; v < V; v++)
				// if distance[v] not in the set -> update edge from u to v and total weight path from src to v is smaller than current value of distance[v]
	if (!set[v] && cities[u][v] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + cities[u][v] < distance[v])
					distance[v] = distance[u] + cities[u][v];
		}

		// print distance array ( solution )
		print(distance);
	}

	/////////////////////////////////////----Main Method---//////////////////////////////////////////////////////////////////
	public static void main(String[] args)
	{
		//Print all distance
		int cities[][] = new int[][] { 
			                        {0,79,420,949,1343,167,625,1024,863,777,710,905},
									{ 79,0,358,870,1265,88,627,1037,876,790,685,912 },
									{420,358,0,848,1343,446,985,679,518,432,1043,1270 },
									{ 949,870,848,0,395,782,1064,1304,330,640,1272,950},
									{1343,1265,1343,395,0,1177,1495,1729,725,1035,1667,1345},
									{167,88,446,782,1177,0,561,1204,936,957,763,864 },
									{625,627,985,1064,1459,561,0,1649,488,1402,202,280 },
									{ 1024,1037,679,1304,1729,1204,1649,0,974,664,1722,1929},
									{863,876,518,330,725,936,1488,974,0,310,1561,1280 }, 
									{777,790,432,640,1035,957,1402,664,974,0,1475,1590},
									{710,685,1043,1272,1667,763,202,1722,1561,1475,0,482},
									{905,912,1270,950,1345,864,280,1929,1280,1590,482,0}};
					
	
									dijkstra_algorithm(cities, 0);
									
	}
}
//////////////////////////////////////////////////////////////////////////////
