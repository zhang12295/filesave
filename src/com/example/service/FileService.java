package com.example.service;

import java.io.*;

 
import android.content.Context;

public class FileService 
{
	private Context context;
	public FileService(Context context)
	{
		this.context = context;
	}
	/**
	 * 保存文件
	 * @param filename  文件名称
 	 * @param filecontent  文件内容
	 * @throws Exception 
	 */

	public void save(String filename, String filecontent) throws Exception 
	{
		FileOutputStream fos= context.openFileOutput(filename,Context.MODE_PRIVATE);
		fos.write(filecontent.getBytes());
		fos.close();
		
	}
	
	public String read(String filename) throws Exception
	{
		byte buffer[]=new byte[1024];
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		FileInputStream fis=context.openFileInput(filename);
		int len=0;
		while((len=fis.read(buffer))!=-1)
		{
			baos.write(buffer,0,len);
		}
		byte data[]=baos.toByteArray();
		
		return new String(data);
		
	}

}
