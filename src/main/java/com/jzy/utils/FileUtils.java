package com.jzy.utils;

import java.io.File;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class FileUtils {
	/***
	 * ��ȡ�ļ���չ�� ��׺��
	 * @return
	 * D:/test/test.txt
	 */
	public static String getSuffixName(String path) {
		File file = new File(path);
		boolean file2 = file.isFile();
		if(file2) {
			int indexOf = path.indexOf(".");
			String substring = path.substring(indexOf,path.length());
			return substring;
		}else {
			return "��·�����Ի��߲�����ͨ�ļ�";
		}
	}
	/***
	 * ɾ���ļ��������Ŀ¼����������ļ���������Ŀ¼�е��ļ���Ҫɾ��
	 */
	public static void deleteFiles(String path) {
		File file = new File(path);
		if(file.isFile()) {
			file.delete();
		}else if(file.isDirectory()){
			//��ȡĿ¼�µ������ļ� ����Ŀ¼
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				String path2 = file2.getPath();
				//d�ݹ�ɾ���ļ�
				deleteFiles(path2);
			}
		}
		//ɾ�����ļ���
		file.delete();
	}

	/***
	 * ��ȡ����ϵͳ�û�Ŀ¼
	 */
	public static String getHomeDirectory() {
		String property = System.getProperty("user.home");
		return property;
	}
	public static String getWorkDirectory() {
		String property = System.getProperty("user.dir");
		return property;
	}

	public static String getFileSize(String path,String unit) {
		File file = new File(path);
		long leng = file.length();
		double length = leng;
		double size = 0;

		switch (unit) {
		case "K":
			size = length/1024;
			break;
		case "M":
			size = length/1024/1024;
			break;
		case "G":
			size = length/1024/1024/1024;
			break;
		default:
			size = length;
			break;
		}
		NumberFormat data=NumberFormat.getNumberInstance();
		//������λС��
		data.setMaximumFractionDigits(4);
		// �������Ҫ�������룬����ʹ��RoundingMode.DOWN
		data.setRoundingMode(RoundingMode.UP);

		String format = data.format(size);
		return format + unit;
	}

}
