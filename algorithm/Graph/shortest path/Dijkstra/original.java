class Edge {
	int from, to, dis;

	public Edge(int from, int to, int dis) {
		this.from = from;
		this.to = to;
		this.dis = dis;
	}
}

class Node {
	int d, node;

	public Node(int d, int u) {
		this.d = d;
		this.node = u;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getNode() {
		return node;
	}

	public void setNode(int node) {
		this.node = node;
	}
}

int n, m;
Edge[] edges;
int[][] G;
boolean[] vis;
int L[], path[];

void init() {
	n = cd.nextInt();
	m = n * (n - 1);
	edges = new Edge[m];
	G = new int[n][n - 1];
	L = new int[n];
	Arrays.fill(L, INF);
	vis = new boolean[n];
	path = new int[n];
	for (int i = 0, t = 0; i < n; i++) {
		for (int j = 0, k = 0; j < n; j++) {
			int d = cd.nextInt();
			edges[t] = new Edge(i, j, d);
			G[i][k] = t;
			t += 1;
			k += 1;
		}
	}
}

void dijkstra() {
	PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getD).reversed());
	L[0] = 0;
	queue.add(new Node(0, 0));
	while (!queue.isEmpty()) {
		Node x = queue.poll();
		int node = x.node;
		if (vis[node]) continue;
		vis[node] = true;
		for (int id : G[node]) {
			Edge e = edges[id];
			if (L[e.to] > L[node] + e.dis) {
				L[e.to] = L[node] + e.dis;
				path[e.to] = id;
				queue.add(new Node(L[e.to], e.to));
			}
		}
	}
}
/*
todo:
- docs
*/
