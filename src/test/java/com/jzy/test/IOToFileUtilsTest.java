package com.jzy.test;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.jzy.utils.IOToFileUtils;


public class IOToFileUtilsTest {

    /**
     * ���ֽ�Ϊ��λ��ȡ�ļ��������ڶ�ȡ�������ļ����磺ͼƬ��������Ӱ���
     * <���滻�ɹ�������> <br>
     * <���滻����ϸ����>
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017��2��7��]
     */
    @Test
    public void readFileByBytes(){
        String fileName = "F:\\ר��һ\\2019-09-Сһ\\git\\sssss.txt";//��ȡʱ���ܻ��������
        IOToFileUtils.readFileByBytes(fileName);
    }

    /**
     * ���ַ�Ϊ��λ��ȡ�ļ��������ڶ�ȡ�ı������ֵ����͵��ļ�
     * <���滻�ɹ�������> <br>
     * <���滻����ϸ����>
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017��2��7��]
     */
    @Test
    public void readFileByCharts(){
        String fileName = "E:/mkdir/copy/free.ftl";
        IOToFileUtils.readFileByChars(fileName);
    }

    /**
     * ����Ϊ��λ��ȡ�ļ��������ڶ�ȡ�����еĸ�ʽ���ļ�
     * <���滻�ɹ�������> <br>
     * <���滻����ϸ����>
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017��2��7��]
     */
    @Test
    public void readFileByLines(){
        String fileName = "E:/mkdir/copy/append.txt";
        IOToFileUtils.readFileByLines(fileName);
    }

    /**
     * �����ȡ�ļ�����
     * <���滻�ɹ�������> <br>
     * <���滻����ϸ����>
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017��2��7��]
     */
    @Test
    public void readFileByRandomAccess(){
        String fileName = "E:/mkdir/copy/free.ftl";
        IOToFileUtils.readFileByRandomAccess(fileName);
    }

    /**
     * ������׷�ӵ��ļ�β��  A������ʹ��RandomAccessFile
     * <���滻�ɹ�������> <br>
     * <���滻����ϸ����>
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017��2��7��]
     * @throws UnsupportedEncodingException 
     */
    @Test
    public void appendToFile_A() throws UnsupportedEncodingException{
        String fileName = "E:/mkdir/copy/append.txt";
        String content = "aaaa���Ǻ�����ӵ�����A��";//�������ʱ��������
        IOToFileUtils.appendToFile_A(fileName, content);
    }

    /**
     * ������׷�ӵ��ļ�β��  B������ʹ��FileWriter
     * <���滻�ɹ�������> <br>
     * <���滻����ϸ����>
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017��2��7��]
     */
    @Test
    public void appendToFile_B(){
        String fileName = "E:/mkdir/copy/append.txt";
        String content = "aaaa���Ǻ�����ӵ����ݣ�B";//ע�����txt����ʱ�ı����ʽutf-8
        IOToFileUtils.appendToFile_B(fileName, content);
    }

    @Test
    public void appendToFile_C(){
        String fileName = "E:/mkdir/copy/append.txt";
        String content = "aaaa���Ǻ�����ӵ����ݣ�C";//ע�����txt����ʱ�ı����ʽutf-8
        IOToFileUtils.appendToFile_C(fileName, content);
    }
}
