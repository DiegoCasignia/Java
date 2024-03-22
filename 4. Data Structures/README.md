# Data Structures
Data structures are ways of organizing and storing data in a computer so that they can be accessed and manipulated efficiently. These structures are fundamental in programming, as they allow for the management and manipulation of large volumes of information in an organized manner.

## Arrays
Arrays allow us to store a colections of data continously in memory. Array have a fixed size.

## List
List is a sequence of nodes, where each node have a value and a reference to the next node. Unlike arrays, linked lists do not require contiguous memory location, allowing them to grow dynamically.
List can be:
- Singly list: each node has a link to the next node.
- Doubly list: each node has a link to the previous and next nodes.
- Circular list: the last node links to the first, forming a cycle.
Basic Operations:
- Insertion: adding a new node at a specific position.
- Deletion: removing a node from the list.
- Search: finding a specific value in the list.
- Traversal: traversing all nodes in the list.

## Stacks
Stacks are linear data structures that follow a restricted access principle, known as LIFO (Last In, First Out). The last added element is the first to be removed.
Basic Operations:
- Push: adding an element to the top of the stack.
- Pop: removing and returning the top element of the stack.
- Peek: getting the top element without removing it.

## Queues
Queues are linear data structures that follow a restricted access principle, known as FIFO (First In, First Out). The first added element is the first to be removed.
Basic Operations:
- Enqueue: adding an element to the end of the queue.
- Dequeue: removing and returning the first element of the queue.
- Peek: getting the first element without removing it.

## Trees
A tree is a nonlinear data structure cinsisting of a set of nodes connected by links called branches. Each tree has a special node called the root. The remaining nodes are divided into levels.
Types of Trees:
- Binary Tree: each node has at most two children nodes
- AVL Tree: a type of balanced binary search tree in height.
- B-Tree: a balanced search tree that allows more than two children per node.
- Red-Black Tree: A red-black tree is another type of self-balancing binary search tree in which each node is colored red or black, and it satisfies certain properties to ensure balance.
- Trie: A trie is a tree data structure used to efficiently store and retrieve strings.
Basic Operations:
- Insertion: adding a new node to the tree.
- Deletion: removing an existing node from the tree.
- Search: finding a specific value in the tree.
- Traversal: visiting all nodes of the tree in a specific order, such as preorder, postorder, or inorder.

## Graphs
A graphs ia nonlineal data structure cinsisting of a set of nodes and a set of connections between pairs of nodes (edges).
Types of Graphs:
- Directed Graphs 
- Undirected Graphs
- Weighted Graphs
- Unweighted Graphs
- Connected Graphs
- Disconnected Graphs
- Bipartite Graphs
- Complete Graphs
- Cyclic Graphs
- Acyclic Graphs

## Sorting Algorithms
Sorting algorithms are methods for organizing elements in a sequence in ascending or descending order.
Some common sorting algorithms include:
- Bubble Sort
> An example is in LinkedList
- Selection Sort
> An example is in DoublyLinkedList
- Insertion Sort
> An example is in CircularLinkedList
- Merge Sort
> An example is in Stack
- Quick Sort
- Heap Sort

## Search Algorithms
Search algorithms are methods for finding a specific element in a collection of elements. The choice of search algorithm depends on the type of data and the data structure used.
Some common search algorithms include:
- Linear Search
- Binary Search
- Tree Search
- Graph Search