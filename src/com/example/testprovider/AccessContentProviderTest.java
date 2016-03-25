package com.example.testprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.test.AndroidTestCase;
import android.util.Log;

public class AccessContentProviderTest extends AndroidTestCase 
{
	private static final String TAG="AccessContentProviderTest";
	public void testInsert() throws Exception
	{
		Uri uri = Uri.parse("content://com.example.providers.personprovider/person");
		ContentResolver resolver = this.getContext().getContentResolver();
		ContentValues values = new ContentValues();
		values.put("name","zhuzhuzhu");
		values.put("phone","1233333455");
		values.put("amount", "88888888");
		resolver.insert(uri, values); 
	}
	
	public void testDelete() throws Exception
	{
		Uri uri = Uri.parse("content://com.example.providers.personprovider/person/20");
		ContentResolver resolver = this.getContext().getContentResolver();
		resolver.delete(uri, null, null);
	}
	
	public void testUpdate() throws Exception
	{
		Uri uri = Uri.parse("content://com.example.providers.personprovider/person/19");
		ContentResolver resolver = this.getContext().getContentResolver();
		ContentValues values = new ContentValues();
		values.put("name","zhuangadjfksdjfl");
		resolver.update(uri, values, null, null);
	}
	public void testQuery() throws Exception
	{
		Uri uri = Uri.parse("content://com.example.providers.personprovider/person");
		ContentResolver resolver = this.getContext().getContentResolver();
		Cursor cursor = resolver.query(uri, null, null, null, "personid asc");
		while(cursor.moveToNext())
		{
			String name = cursor.getString(cursor.getColumnIndex("name"));
			Log.i(TAG,name);
		}
		cursor.close();
	}
	
	
	
}
