"""
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
"""
from UndirectedGraphNode import UndirectedGraphNode


class Solution:
    # @param node, a undirected graph node
    # @return a undirected graph node
    def cloneGraph(self, node):
        if not node:
            return node
        map_dict = {}
        queue = [node]
        root = UndirectedGraphNode(node.label)
        map_dict[node] = root

        while queue:
            cur = queue.pop()
            cur_clone = map_dict.get(cur)
            for neighbor in cur.neighbors:
                if map_dict.get(neighbor):
                    neighbor_clone = map_dict.get(neighbor)
                    cur_clone.neighbors.append(neighbor_clone)
                else:
                    neighbor_clone = UndirectedGraphNode(neighbor.label)
                    map_dict[neighbor] = neighbor_clone
                    cur_clone.neighbors.append(neighbor_clone)
                    queue.append(neighbor)
        return root


if __name__ == '__main__':
    n1 = UndirectedGraphNode(1)
    n2 = UndirectedGraphNode(2)
    n3 = UndirectedGraphNode(3)
    n4 = UndirectedGraphNode(4)
    n5 = UndirectedGraphNode(5)
    n1.neighbors = [n2, n3]
    n2.neighbors = [n3, n4]
    n3.neighbors = [n1, n5]
    n5.neighbors = [n4]

    root = Solution().cloneGraph(n1)
    print n2.bfs()
