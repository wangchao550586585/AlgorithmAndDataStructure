package h_tree.A_TwoForkTree;

public class Tree {
	private Node root;

	public Tree() {
		root = null;
	}

	/*
	 * ��ѯĳֵ
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
	 * ����
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
	 * ɾ���ڵ�
	 */
	public boolean delete(int key) {
		Node parent = root;
		Node current = root;
		boolean isLeftChild = true;
		// ��ȡɾ���Ľڵ㣬û�з���false
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
		// currentΪҶ�ڵ�
		if (current.leftChild == null && current.rightChild == null) {
			if (current == root)
				root = null;
			else if (isLeftChild)
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}
		// current�����ӽڵ�
		else if (current.leftChild == null) {
			if (current == root)
				root = current.rightChild;
			else if (isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;
		}
		// current�����ӽڵ�
		else if (current.rightChild == null) {
			if (current == root)
				root = current.leftChild;
			else if (isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;
		}
		// current�������ӽڵ�
		else {
			Node successor = getSuccessor(current);// �õ���̽ڵ�
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
	 * ��ú�̽ڵ�
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
	 * ѡ������ʽ
	 */
	public void traverse(int traverseType) {
		switch (traverseType) {
		case 1:
			System.out.println("ǰ��");
			preOrder(root);
			break;
		case 2:
			System.out.println("����");
			inOrder(root);
			break;
		case 3:
			System.out.println("����");
			postOrder(root);
			break;
		}
		System.out.println();
	}

	/*
	 * ǰ��
	 */
	private void preOrder(Node localRoot) {
		if (localRoot != null) {
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	/*
	 * ����
	 */
	private void inOrder(Node localRoot) {
		if (localRoot != null) {
			preOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.rightChild);
		}
	}

	/*
	 * ����
	 */
	private void postOrder(Node localRoot) {
		if (localRoot != null) {
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
			System.out.print(localRoot.iData + " ");
		}
	}

	// ջ�������� ����2�㣬1:�����2�������ŷ�
	// �����Ƿ�Ϊnull����Ҫ����λ��
	// ÿ�м�¼���ھֲ�ջ���棬һ�н������ֲ�ջ����ȫ���ƶ���ȫ��ջ�С�
	// �ж�ȫ��ջ�Ƿ�Ϊ��
	// -------------��Ϊ��(2�������1�����ݡ�2��null)
	// ---------------��ջ���жϳ�ջ�����Ƿ�Ϊ����
	// -----------------�ǣ�������ݣ�Ȼ��洢���ݵ������ӽڵ�
	// -------------------�ж������ӽڵ������Ƿ�Ϊnull
	// ----------------------��Ϊnull����ջ��Ϊ��
	// -------------���ǣ����-��Ȼ��洢null �ֲ�ջ���ݳ�ջ��ȫ��ջ��
	// ѭ�������������ӽڵ�����������
	// ��ֹ�����������ҽڵ㶼������.
	/*
	 * ��ʾ
	 */
	public void displayTree() {
		Stack global = new Stack();// ջ�����
		global.push(root);// ��ջ
		int nBlank = 32;// ���
		boolean isRowEmpty = false;
		while (!isRowEmpty) {// ����в��ǿյ�
			isRowEmpty = true;
			Stack local = new Stack();
			for (int i = 0; i < nBlank; i++)
				System.out.print(" ");// ��߼��
			while (!global.isEmpty()) {// ���ջ���ǿյ�
				Node temp = (Node) global.pop();// ��ջ
				if (temp != null) {// �ڵ㲻Ϊ��
					System.out.print(temp.iData);
					local.push(temp.leftChild);
					local.push(temp.rightChild);
					if (temp.leftChild != null || temp.rightChild != null) {// ��������ӽڵ㲻Ϊ�գ������ѭ��
						isRowEmpty = false;
					}
				} else {
					System.out.print("--");
					local.push(null);
					local.push(null);
				}
				for (int i = 0; i < nBlank * 2 - 2; i++) {
					System.out.print(" ");// �м���
				}
			}
			System.out.println();// ����
			nBlank /= 2;
			while (!local.isEmpty()) {
				global.push(local.pop());
			}
		}

	}

}
