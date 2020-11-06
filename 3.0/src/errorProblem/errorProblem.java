package errorProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Implementation.Impl;

public class errorProblem {
	private int allProblemCount = getAllProblemCount();// 当前错题集中所有错题数量
	private final String errorProblemString = "src\\errorProblem\\errorProblem.txt";// 所有的错题的路径
	private final String allProblemCountString = "src\\errorProblem\\allProblemCount.txt";// 所有错题数目的路径

	/**
	 * 根据错题构造答案
	 * 
	 * @param list 错题
	 * @return 根据错题构造的答案
	 */
	public List<String> createAnswer(List<String> list) {
		List<String> answerList = new ArrayList<String>();
		for (String xString : list) {
			String xString2[] = xString.split("\\+");
			if (xString2.length > 1) {
				answerList.add(String.valueOf(Integer.valueOf(xString2[0]) + Integer.valueOf(xString2[1])));
			} else {
				String xString3[] = xString.split("\\-");
				answerList.add(String.valueOf(Integer.valueOf(xString3[0]) - Integer.valueOf(xString3[1])));
			}
		}
		return answerList;
	}

	/**
	 * 返回当前所有错题数目
	 * 
	 * @return
	 */
	public int getAllProblemCount() {
		File file = new File(allProblemCountString);
		BufferedReader reader = null;
		String string = "";
		try {
			reader = new BufferedReader(new FileReader(file));
			string = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return Integer.valueOf(string);
	}

	/**
	 * 将参数中的当前所有错题（每道题之间是用回车间隔开的）前加上序号,并且添加到错题集中
	 * 
	 * @param list 传入的错题数组
	 */
	public void addErrorProblemAndNumber(List<String> list) {
		List<String> result = new ArrayList<String>();
		for (String xString : list) {
			allProblemCount++;
			xString = allProblemCount + ":" + xString;
			result.add(xString);
		}
		List<String> aList = new ArrayList<String>();
		aList.add(String.valueOf(allProblemCount));
		WriteMessageInFile(aList, allProblemCountString, false);
		WriteMessageInFile(result, errorProblemString, true);
	}

	/**
	 * 随机提取文件中错题
	 * 
	 * @param number 想要提取的错题数量
	 * @return 所有错题构成的字符串数组
	 */
	public List<String> getErrorProblem(int number) {
		Impl impl = new Impl();
		List<Integer> problemNumber = new ArrayList<Integer>();// 保存随机生成的提取题号的链表
		for (int i = 0; i < number; i++) {
			int x = impl.createRandomNumber(allProblemCount + 1);
			while (x == 0 || problemNumber.contains(x)) {
				x = impl.createRandomNumber(allProblemCount + 1);
			}
			problemNumber.add(x);
		}
		Collections.sort(problemNumber);// 对所有随机生成的要提取的随机数进行排列
		return removeNumberAddNewNumber(readFileByLines(problemNumber, errorProblemString));
	}

	/**
	 * 将string写入文件
	 * 
	 * @param list     要写入文件的字符串数组
	 * @param filePath 要写入的文件路径
	 * @param flag     是否覆盖之前的文件
	 */
	private void WriteMessageInFile(List<String> list, String filePath, Boolean flag) {
		try {
			File file = new File(filePath);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw;
			if (flag) {
				fw = new FileWriter(file, true);
			} else {
				fw = new FileWriter(file);
			}
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < list.size(); i++) {
				bw.write(list.get(i)+"\n");
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 将string中的当前所有错题（每道题之间是用回车间隔开的）前移除序号
	private List<String> removeNumberAddNewNumber(List<String> string) {
		List<String> result = new ArrayList<String>();
		for (String xString : string) {
			String xString1[] = xString.split(":");
			xString = xString1[1];
			result.add(xString);
		}
		return result;
	}

	// 返回题号为list中的题目
	private List<String> readFileByLines(List<Integer> list, String filePath) {
		File file = new File(filePath);
		BufferedReader reader = null;
		int i = 0;
		List<String> result = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null && i < list.size()) {
				String xString[] = tempString.split(":");
				if (Integer.valueOf(xString[0]) == list.get(i)) {
					result.add(tempString);
					i++;
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return result;
	}
}
