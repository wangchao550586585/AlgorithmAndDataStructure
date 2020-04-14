package h_tree.A_TwoForkTree;

public class Tree {
	private Node root;

	public Tree() {
		root = null;
	}

	/*
	 * 查询某值
	 */
	public Node find(int key) {
		Node current = root;
		while (current.iData != key) {
			if (key < current.iData)
				current = current.leftChild;
			else
				current = current.rightChild;
			if (current == null)
				return null;
		}
		return current;
	}

	/*
	 * 插入
	 */
	public void insert(int id, double dd) {
		Node nowNode = new Node();
		nowNode.iData = id;
		nowNode.dData = dd;
		if (root == null) {
			root = nowNode;
		} else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (id < current.iData) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = nowNode;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = nowNode;
						return;
					}
				}

			}

		}
	}

	/*
	 * 删除节点
	 */
	public boolean delete(int key) {
		Node parent = root;
		Node current = root;
		boolean isLeftChild = true;
		// 获取删除的节点，没有返回false
		while (current.iData != key) {
			parent = current;
			if (key < current.iData) {
				current = current.leftChild;
				isLeftChild = true;
			} else {
				current = current.rightChild;
				isLeftChild = false;
			}
			if (current == null) {
				return false;
			}
		}
		// current为叶节点
		if (current.leftChild == null && current.rightChild == null) {
			if (current == root)
				root = null;
			else if (isLeftChild)
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}
		// current无左子节点
		else if (current.leftChild == null) {
			if (current == root)
				root = current.rightChild;
			else if (isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;
		}
		// current无右子节点
		else if (current.rightChild == null) {
			if (current == root)
				root = current.leftChild;
			else if (isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;
		}
		// current有左右子节点
		else {
			Node successor = getSuccessor(current);// 得到后继节点
			if (current == root)
				root = successor;
			else if (isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			successor = current.leftChild;
		}
		return true;
	}

	/*
	 * 获得后继节点
	 */
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}

	/*
	 * 选择排序方式
	 */
	public void traverse(int traverseType) {
		switch (traverseType) {
		case 1:
			System.out.println("前序");
			preOrder(root);
			break;
		case 2:
			System.out.println("中序");
			inOrder(root);
			break;
		case 3:
			System.out.println("后序");
			postOrder(root);
			break;
		}
		System.out.println();
	}

	/*
	 * 前序
	 */
	private void preOrder(Node localRoot) {
		if (localRoot != null) {
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	/*
	 * 中序
	 */
	private void inOrder(Node localRoot) {
		if (localRoot != null) {
			preOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.rightChild);
		}
	}

	/*
	 * 后序
	 */
	private void postOrder(Node localRoot) {
		if (localRoot != null) {
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
			System.out.print(localRoot.iData + " ");
		}
	}

	// 栈排列数， 考虑2点，1:间隔。2：数字排放
	// 无论是否为null，都要考虑位置
	// 每行记录放在局部栈里面，一行结束，局部栈数据全部移动到全局栈中。
	// 判断全局栈是否为空
	// -------------不为空(2中情况，1：数据。2：null)
	// ---------------出栈，判断出栈数据是否为数据
	// -----------------是：输出数据，然后存储数据的左右子节点
	// -------------------判断左右子节点任意是否不为null
	// ----------------------不为null：则栈不为空
	// -------------不是：输出-，然后存储null 局部栈数据出栈到全局栈中
	// 循环条件：左右子节点任意有数据
	// 终止条件，数左右节点都无数据.
	/*
	 * 显示
	 */
	public void displayTree() {
		Stack global = new Stack();// 栈存放树
		global.push(root);// 入栈
		int nBlank = 32;// 间隔
		boolean isRowEmpty = false;
		while (!isRowEmpty) {// 如果行不是空的
			isRowEmpty = true;
			Stack local = new Stack();
			for (int i = 0; i < nBlank; i++)
				System.out.print(" ");// 左边间隔
			while (!global.isEmpty()) {// 如果栈不是空的
				Node temp = (Node) global.pop();// 出栈
				if (temp != null) {// 节点不为空
					System.out.print(temp.iData);
					local.push(temp.leftChild);
					local.push(temp.rightChild);
					if (temp.leftChild != null || temp.rightChild != null) {// 如果任意子节点不为空，则继续循环
						isRowEmpty = false;
					}
				} else {
					System.out.print("--");
					local.push(null);
					local.push(null);
				}
				for (int i = 0; i < nBlank * 2 - 2; i++) {
					System.out.print(" ");// 中间间隔
				}
			}
			System.out.println();// 换行
			nBlank /= 2;
			while (!local.isEmpty()) {
				global.push(local.pop());
			}
		}

	}

}
