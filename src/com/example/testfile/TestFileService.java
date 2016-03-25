package com.example.testfile;

import android.test.AndroidTestCase;
import android.util.Log;

import com.example.service.FileService;


public class TestFileService extends AndroidTestCase 
{
	private static final String TGA="TestFileService"; 
	public void testRead() throws Throwable
	{
		FileService fs = new FileService(this.getContext());
		String result=fs.read("s.txt");
		Log.i(TGA, result);
	}

}
