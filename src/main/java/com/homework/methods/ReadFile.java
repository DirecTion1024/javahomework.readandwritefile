package com.homework.methods;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.homework.log.LogUtil;

public class ReadFile {

	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	public List<Map> readFile(String filepath) {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		ArrayList al = new ArrayList();
		List<Map> list = new ArrayList();
		String raw = null;
		BufferedReader br = null; 
		try {
			LogUtil.logInfo("开始获取文件");
			String str = "";
			fis = new FileInputStream(filepath);// FileInputStream
			// 从文件系统中的某个文件中获取字节
			isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
			br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new
											// InputStreamReader的对象
			LogUtil.logInfo("获取文件成功");
			LogUtil.logInfo("开始向arraylist中写入数据");
			while ((str = br.readLine()) != null) {
				al.add(str);
			};
			for (int i = 0; i < al.size(); i++) {
			    System.out.println(al.get(i));
			}
			LogUtil.logInfo("数据写入完毕");
			LogUtil.logInfo("开始拼接字符串并写入list");
			for(int i=0;i<al.size();i++){
				raw = (String) al.get(i);
				System.out.println(raw);
				final String strname = raw.substring(0, raw.indexOf("|"));
				System.out.println(strname);
				final String strage = raw.substring(raw.lastIndexOf("|")+1);
				System.out.println(strage);
				final String strsex = (raw.substring(raw.indexOf("|")+1, raw.lastIndexOf("|")));
				System.out.println(strsex);
				Map map = new HashMap(){{
					put("姓名", strname);
					put("年龄", strage);
					put("性别", strsex);
				}};
				list.add(map);
			}
			for (int i = 0; i < list.size(); i++) {
			    System.out.println(list.get(i));
			}
			LogUtil.logInfo("list数据写入完毕");
		} catch (FileNotFoundException e) {
			System.out.println("找不到指定文件");
		} catch (IOException e) {
			System.out.println("读取文件失败");
		} finally {
			try {
				br.close();
				isr.close();
				fis.close();
				// 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}