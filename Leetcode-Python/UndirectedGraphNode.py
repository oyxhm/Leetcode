class UndirectedGraphNode:
    def __init__(self, x):
        self.label = x
        self.neighbors = []

    def __str__(self):
        return "<UndirectedGraphNode [%s]>" % str(self.label)

    def __repr__(self):
        return self.__str__()

    def dfs(self):
        traversal = []

        def __dfs(node):
            if node in traversal:
                return
            traversal.append(node)
            for neighbor in node.neighbors:
                __dfs(neighbor)

        __dfs(self)
        return traversal

    def bfs(self):
        queue = [self]
        traversal = []
        while queue:
            node = queue.pop(0)
            traversal.append(node)
            for neighbor in node.neighbors:
                if neighbor not in traversal and neighbor not in queue:
                    queue.append(neighbor)
        return traversal
