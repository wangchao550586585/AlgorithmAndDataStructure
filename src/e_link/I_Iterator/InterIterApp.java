package e_link.I_Iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 链表实现迭代器
 * 
 * @author Administrator
 *
 */
public class InterIterApp {
	public static void main(String[] args) throws IOException {
		LinkList theList = new LinkList();
		ListIterator iterator = theList.getIterator();
		long value;

		iterator.insertAfter(20);
		iterator.insertAfter(30);
		iterator.insertAfter(40);
		iterator.insertAfter(50);
		iterator.insertBefore(60);

		while (true) {
			int cho = getChar();
			switch (cho) {
			case 's':// 遍历
				if (!theList.isEmpty())
					theList.displayList();
				else
					System.out.println("List is empty");
				break;
			case 'r':// 迭代器复位并设在表头
				iterator.reset();
				break;
			case 'n':// 下一个链接点
				if (!theList.isEmpty() && !iterator.atEnd())
					iterator.nextLink();
				else
					System.out.println("不能去下一个链接");
				break;
			case 'g':// 获取当前数据
				if (!theList.isEmpty()) {
					value = iterator.getCurrent().dData;
					System.out.println(value);
				} else
					System.out.println("链表为空");
				break;
			case 'b': // 在链接点前面插入新链接点
				value = getInt();
				iterator.insertBefore(value);
				break;
			case 'a': // 在链接点后面插入新链接点
				value = getInt();
				iterator.insertAfter(value);
				break;
			case 'd': // 删除当前
				if (!theList.isEmpty()) {
					value = iterator.deleteCurrent();
					System.out.println(value);
				} else
					System.out.println("不能删除");
				break;
			default:
				System.out.println("Invalid entry");// 无效
			}
		}
	}

	/*
	 * 返回控制台输出的字符
	 */
	public static String getString() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		return s;
	}

	private static int getChar() throws IOException {
		String s = getString();
		return s.charAt(0);
	}

	private static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}

}
