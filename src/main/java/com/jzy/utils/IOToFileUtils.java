package com.jzy.utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Reader;

/**
 * Java��ȡ�ļ������ࡪ��IO
 * <���滻�ɹ�������> <br>
 * <���滻����ϸ����>
 * @author caizh
 * @since [1.0.0]
 * @version [1.0.0,2017��2��6��]
 */
public class IOToFileUtils {

    /**
     * ���ֽ�Ϊ��λ��ȡ�ļ��������ڶ�ȡ�������ļ����磺ͼƬ��������Ӱ���
     * <���滻�ɹ�������> <br>
     * <���滻����ϸ����>
     * @param fileName
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017��2��6��]
     */
    public static void readFileByBytes(String fileName){
        File file = new File(fileName);
        InputStream in = null;
        try{
            System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");
            //һ�ζ�ȡһ���ֽ�
            in = new FileInputStream(file);
            int tempbyte;
            while((tempbyte=in.read())!= -1){
                System.out.write(tempbyte);
            }
            in.close();
        }catch(Exception e){
            e.printStackTrace();
            return;
        }
        try{
            System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�ȡ����ֽڣ�");
            //һ�ζ�ȡ����ֽ�
            byte[] tempbytes = new byte[1024];
            int byteread = 0;
            in = new FileInputStream(fileName);
            showAvailableBytes(in);
            //�������ֽڵ��ֽ������У�bytereadΪһ�ζ�����ֽ���
            while((byteread=in.read(tempbytes))!= -1){
                System.out.write(tempbytes, 0, byteread);;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * ���ַ�Ϊ��λ��ȡ�ļ��������ڶ�ȡ�ı������ֵ����͵��ļ�
     * <���滻�ɹ�������> <br>
     * <���滻����ϸ����>
     * @param fileName
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017��2��6��]
     */
    public static void readFileByChars(String fileName){
        File file = new File(fileName);
        Reader reader = null;
        try{
            System.out.println("���ַ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�ȡһ���ַ���");
            //һ�ζ�ȡһ���ַ�
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while((tempchar=reader.read())!= -1){
                //����window�£�/r/n�������ַ���һ��ʱ����ʾһ�����С�
                //������������ַ��ֿ���ʾ�ǣ��ỻ�����С�
                //��ˣ����ε�/r,��������/n�����򣬽������ܶ����
                if(((char)tempchar)!= '\r'){
                    System.out.print((char)tempchar);
                }
            }
            reader.close();
        }catch(Exception e){
            e.printStackTrace();  
        }
        try{
            System.out.println("���ַ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�ȡ����ַ���");
            //һ�ζ�ȡ����ַ�
            char[] tempchars = new char[30];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(fileName));
            //��ȡ����ַ����ַ������У�charreadΪһ�ζ�ȡ�ַ���
            while((charread=reader.read(tempchars))!=-1){
                //���ε�/r����ʾ
                if((charread == tempchars.length) && (tempchars[tempchars.length-1]!='\r')){
                    System.out.print(tempchars);
                }else{
                    for(int i=0;i<charread;i++){
                        if(tempchars[i] == '\r'){
                            continue;
                        }else{
                            System.out.print(tempchars[i]);
                        }
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * ����Ϊ��λ��ȡ�ļ��������ڶ�ȡ�����еĸ�ʽ���ļ�
     * <���滻�ɹ�������> <br>
     * <���滻����ϸ����>
     * @param fileName
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017��2��6��]
     */
    public static void readFileByLines(String fileName){
        File file = new File(fileName);
        BufferedReader reader = null;
        try{
            System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�ȡһ���У�");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            //һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            while((tempString = reader.readLine())!=null){
                //��ʾ�к�
                System.out.println("line "+line+":"+tempString);
                line++;
            }
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * �����ȡ�ļ�����
     * <���滻�ɹ�������> <br>
     * <���滻����ϸ����>
     * @param fileName
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017��2��6��]
     */
    public static void readFileByRandomAccess(String fileName){
        RandomAccessFile randomFile = null;
        try{
            System.out.println("�����ȡһ���ļ����ݣ�");
            //��һ����������ļ�������ֻ����ʽ
            randomFile = new RandomAccessFile(fileName,"r");
            //�ļ����ȣ��ֽ���
            long fileLength = randomFile.length();
            //���ļ�����ʼλ��
            int beginIndex = (fileLength>4)?4:0;
            //����ȡ�ļ��Ŀ�ʼλ���Ƶ�beginIndex��λ����
            randomFile.seek(beginIndex);
            byte[] bytes = new byte[10];
            int byteread = 0;
            //һ�ζ�ȡ10���ֽڣ�����ļ����ݲ���10���ֽڣ����ȡʣ�µ��ֽڡ�
            //��һ�ζ�ȡ���ֽ�������byteread
            while((byteread = randomFile.read(bytes))!= -1){
                System.out.write(bytes,0,byteread);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(randomFile!=null){
                try {
                    randomFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * ��ʾ�������л�ʣ���ֽ���
     * <���滻�ɹ�������> <br>
     * <���滻����ϸ����>
     * @param in
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017��2��6��]
     */
    public static void showAvailableBytes(InputStream in){
        try{
            System.out.println("��ǰ�ֽ��������е��ֽ���Ϊ��"+in.available());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * ������׷�ӵ��ļ�β��  A������ʹ��RandomAccessFile
     * <���滻�ɹ�������> <br>
     * <���滻����ϸ����>
     * @param fileName ��������·�����ļ���
     * @param content Ҫ׷�ӵ�����
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017��2��6��]
     */
    public static void appendToFile_A(String fileName,String content){
        try{
            //��һ��������ʵ��ļ���������д��ʽ
            RandomAccessFile randomFile = new RandomAccessFile(fileName,"rw");
            //�ļ����ȣ��ֽ���
            long fileLength = randomFile.length();
            //��д�ļ�ָ���Ƶ��ļ�β��
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * ������׷�ӵ��ļ�β��  B������ʹ��FileWriter
     * <���滻�ɹ�������> <br>
     * <���滻����ϸ����>
     * @param fileName
     * @param content
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017��2��6��]
     */
    public static void appendToFile_B(String fileName,String content){
        try{
            //��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
            FileWriter writer = new FileWriter(fileName,true);            
            writer.write(content);
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * ������׷�ӵ��ļ�β�� C������ʹ��BufferedWriter
     * <���滻�ɹ�������> <br>
     * <���滻����ϸ����>
     * @param fileName
     * @param content
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017��2��10��]
     */
    public static void appendToFile_C(String fileName,String content){

        BufferedWriter out = null;
        try{
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName,true)));
            out.write(content);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                out.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
