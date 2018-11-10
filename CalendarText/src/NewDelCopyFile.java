

import java.io.File;

import java.io.FileWriter;

import java.io.PrintWriter;

public  class  NewDelCopyFile  {  
   public  NewDelCopyFile()  {  
   }  
 
   /**  
     *  �½�Ŀ¼  
     *  @param  folderPath  String  ��  c:/fqf  
     *  @return  boolean  
     */  
   public  void  newFolder(String  folderPath)  {  
       try  {  
           String  filePath  =  folderPath;  
           filePath  =  filePath.toString();  
           java.io.File  myFilePath  =  new  java.io.File(filePath);  
           if  (!myFilePath.exists())  {  
               myFilePath.mkdir();  
           }  
       }  
       catch  (Exception  e)  {  
           System.out.println("�½�Ŀ¼��������");  
           e.printStackTrace();  
       }  
   }  
 
   /**  
     *  �½��ļ�  
     *  @param  filePathAndName  String  �ļ�·��������  ��c:/fqf.txt  
     *  @param  fileContent  String  �ļ�����  
     *  @return  boolean  
     */  
   public  void  newFile(String  filePathAndName,  String  fileContent)  {  
 
       try  {  
           String  filePath  =  filePathAndName;  
           filePath  =  filePath.toString();  
           File  myFilePath  =  new  File(filePath);  
           if  (!myFilePath.exists())  {  
               myFilePath.createNewFile();  
           }  
           FileWriter  resultFile  =  new  FileWriter(myFilePath);  
           PrintWriter  myFile  =  new  PrintWriter(resultFile);  
           String  strContent  =  fileContent;  
           myFile.println(strContent);  
           resultFile.close();  
 
       }  
       catch  (Exception  e)  {  
           System.out.println("�½��ļ���������");  
           e.printStackTrace();  
 
       }  
 
   }  
 
   /**  
     *  ɾ���ļ�  
     *  @param  filePathAndName  String  �ļ�·��������  ��c:/fqf.txt  
     *  @param  fileContent  String  
     *  @return  boolean  
     */  
   public  void  delFile(String  filePathAndName)  {  
       try  {  
           String  filePath  =  filePathAndName;  
           filePath  =  filePath.toString();  
           java.io.File  myDelFile  =  new  java.io.File(filePath);  
           myDelFile.delete();  
 
       }  
       catch  (Exception  e)  {  
           System.out.println("ɾ���ļ���������");  
           e.printStackTrace();  
 
       }  
 
   }  
 
   /** 
     *  ɾ���ļ���  
     *  @param  filePathAndName  String  �ļ���·��������  ��c:/fqf  
     *  @param  fileContent  String  
     *  @return  boolean  
     */  
   public  void  delFolder(String  folderPath)  {  
       try  {  
           delAllFile(folderPath);  //ɾ����������������  
           String  filePath  =  folderPath;  
           filePath  =  filePath.toString();  
           java.io.File  myFilePath  =  new  java.io.File(filePath);  
           myFilePath.delete();  //ɾ�����ļ���  
 
       }  
       catch  (Exception  e)  {  
           System.out.println("ɾ���ļ��в�������");  
           e.printStackTrace();  
 
       }  
 
   }  
 
   /**   
     *  ɾ���ļ�������������ļ�  
     *  @param  path  String  �ļ���·��  ��  c:/fqf  
     */  
   public  void  delAllFile(String  path)  {  
       File  file  =  new  File(path);  
       if  (!file.exists())  {  
           return;  
       }  
       if  (!file.isDirectory())  {  
           return;  
       }  
       String[]  tempList  =  file.list();  
       File  temp  =  null;  
       for  (int  i  =  0;  i  <  tempList.length;  i++)  {  
           if  (path.endsWith(File.separator))  {  
               temp  =  new  File(path  +  tempList[i]);  
           }  
           else  {  
               temp  =  new  File(path  +  File.separator  +  tempList[i]);  
           }  
           if  (temp.isFile())  {  
               temp.delete();  
           }  
           if  (temp.isDirectory())  {  
               delAllFile(path+"/"+  tempList[i]);//��ɾ���ļ���������ļ�  
               delFolder(path+"/"+  tempList[i]);//��ɾ�����ļ���  
           }  
       }  
   }  
}