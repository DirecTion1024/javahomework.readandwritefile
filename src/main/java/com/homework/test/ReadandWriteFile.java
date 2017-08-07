package com.homework.test;

import java.util.Scanner;

import com.homework.log.LogUtil;
import com.homework.methods.ReadFile;
import com.homework.methods.WriteExcel;


public class ReadandWriteFile {
	
	@SuppressWarnings({ "static-access", "resource" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Logger logger = LoggerFactory.getLogger(ReadandWriteFile.class);*/
		Scanner request = new Scanner(System.in);
		System.out.println("请输入读取的txt文件位置：");    //F:\\readfile.txt
		String readpath = request.nextLine();
		System.out.println("请输入写入的excel文件位置：");   //F:\\writefile.xlsx
		String writepath = request.nextLine();
		LogUtil.logInfo("start readfile");
		ReadFile rf = new ReadFile();
		LogUtil.logInfo("readfile success");
		LogUtil.logInfo("start writefile");
		WriteExcel we = new WriteExcel();
		we.writeExcel(rf.readFile(readpath), writepath); 
		LogUtil.logInfo("writefile success");
	}
}
