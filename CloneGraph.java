import java.util.*;

/**
 * Created by yhf on 15/4/26.
 */

/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}

public class CloneGraph {
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        queue.add(node);
        map.put(node, root);

        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.remove();
            UndirectedGraphNode curClone = map.get(cur);
            List<UndirectedGraphNode> neighbors = cur.neighbors;

            for (UndirectedGraphNode neighbor : neighbors) {
                if (map.containsKey(neighbor)) {
                    UndirectedGraphNode neighborClone = map.get(neighbor);
                    curClone.neighbors.add(neighborClone);
                } else {
                    UndirectedGraphNode neighborClone = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, neighborClone);
                    curClone.neighbors.add(neighborClone);
                    queue.add(neighbor);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
