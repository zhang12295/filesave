package com.example.filesave;

import com.example.service.FileService;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu; 
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button=(Button)findViewById(R.id.button);
		
		button.setOnClickListener(new ButtonClickListener());
	}
	
	private final  class ButtonClickListener implements View.OnClickListener
	{

		public void onClick(View v) 
		{
			EditText nametext=(EditText)findViewById(R.id.filename);
			EditText contenttext=(EditText)findViewById(R.id.filecontent);
			String filename=nametext.getText().toString();
			String filecontent=contenttext.getText().toString();
			FileService service=new FileService(getApplicationContext());
			try {
				service.save(filename,filecontent);
				Toast.makeText(getApplicationContext(),R.string.success,1).show(); 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Toast.makeText(getApplicationContext(),R.string.fail,1).show(); 
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		
		int id = item.getItemId();
		if (id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
