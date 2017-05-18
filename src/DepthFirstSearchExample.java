/**
 * Created by Amel on 17.05.2017.
 */

import java.util.ArrayList;
import java.util.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class DepthFirstSearchExample
{
    int timeStamp = 0;
    static ArrayList<Node> nodes=new ArrayList();

    static class Node
    {
        int data;
        boolean visited;
        int timeStampForward;
        int timeStampBack;

        Node(int data)
        {
            this.data=data;
        }

        public int getData()
        {
            return data;
        }
    }

    // find neighbors of node using adjacency matrix
    // if adjacency_matrix[i][j]==1, then nodes at index i and index j are connected
    public ArrayList<Node> findNeighbours(int adjacency_matrix[][],Node x)
    {
        int nodeIndex=-1;

        ArrayList<Node> neighbours=new ArrayList<Node>();
        for (int i = 0; i < nodes.size(); i++)
        {
            if(nodes.get(i).equals(x))
            {
                nodeIndex=i;
                break;
            }
        }

        if(nodeIndex!=-1)
        {
            for (int j = 0; j < adjacency_matrix[nodeIndex].length; j++)
            {
                if(adjacency_matrix[nodeIndex][j]==1)
                {
                    neighbours.add(nodes.get(j));
                }
            }
        }
        return neighbours;
    }


    // Recursive DFS
    public  void dfs(int adjacency_matrix[][], Node node)
    {
        timeStamp++;
        node.timeStampForward = timeStamp;
        System.out.print(node.data + " TimeStampForward " + node.timeStampForward + "\n");
        ArrayList<Node> neighbours=findNeighbours(adjacency_matrix,node);
        for (int i = 0; i < neighbours.size(); i++)
        {
            Node n=neighbours.get(i);
            if(n!=null && !n.visited)
            {
                dfs(adjacency_matrix,n);
                n.visited=true;
            }
        }
        timeStamp++;
        node.timeStampBack = timeStamp;
        System.out.print("TimeBack" + node.timeStampBack + "\n");
    }


    public static void main(String arg[])
    {

        Node node40 =new Node(40);
        Node node10 =new Node(10);
        Node node20 =new Node(20);
        Node node30 =new Node(30);
        Node node60 =new Node(60);
        Node node50 =new Node(50);
        Node node70 =new Node(70);

        nodes.add(node40);
        nodes.add(node10);
        nodes.add(node20);
        nodes.add(node30);
        nodes.add(node60);
        nodes.add(node50);
        nodes.add(node70);
        int adjacency_matrix[][] =
                {
                {0,1,1,0,0,0,0},  // Node 1: 40
                {0,0,0,1,0,0,0},  // Node 2 :10
                {0,1,0,1,1,1,0},  // Node 3: 20
                {0,0,0,0,1,0,0},  // Node 4: 30
                {0,0,0,0,0,0,1},  // Node 5: 60
                {0,0,0,0,0,0,1},  // Node 6: 50
                {0,0,0,0,0,0,0},  // Node 7: 70
        };

        DepthFirstSearchExample dfsExample = new DepthFirstSearchExample();

        clearVisitedFlags();

        System.out.println("The DFS traversal of the graph using recursion ");
        dfsExample.dfs(adjacency_matrix, node40);
        ausgabe();

    }

    public static void clearVisitedFlags()
    {
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).visited=false;
        }
    }

    public static void ausgabe()
    {
        System.out.print("\nTEST\n");
        for (int i = 0; i<nodes.size(); i++)
        {
            System.out.print("\nKnoten: " + nodes.get(i).data);
            System.out.print("  TimeStampForward: " + nodes.get(i).timeStampForward);
            System.out.print("  TimeStampBack: " + nodes.get(i).timeStampBack);
        }

    }

}
