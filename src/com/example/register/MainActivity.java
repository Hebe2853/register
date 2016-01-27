package com.example.register;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	private boolean isChecked=true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle("注册");
		final EditText username=(EditText)findViewById(R.id.editText_username);
		final EditText password=(EditText)findViewById(R.id.editText_password);
		final EditText rePassword=(EditText)findViewById(R.id.editText_rePassword);
		final CheckBox check =(CheckBox)findViewById(R.id.checkbox);
		Button reg = (Button)findViewById(R.id.button_register);
		Button cancel = (Button)findViewById(R.id.button_cancel);
		//添加checkbox的监听事件
		
		check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		@Override
			public void onCheckedChanged(CompoundButton arg0, boolean flag) {
			// TODO Auto-generated method stub
				isChecked=flag;
			}
			});
			
		
		//添加注册的监听事件
		reg.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				String strUser = username.getText().toString();
				String strPassword = password.getText().toString();
				String strRePassword = rePassword.getText().toString();
				if(strUser.equals(""))
				{
					//弹出对话框，验证是否填写用户名
					new AlertDialog.Builder(MainActivity.this)
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle("警告")
					.setMessage("请输入用户名")
					.setPositiveButton("确定",null)
					.show();
					return;
				}
				if(!strPassword.equals(strRePassword))
				{
					//弹出对话框，验证是否填写用户名
					new AlertDialog.Builder(MainActivity.this)
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle("警告")
					.setMessage("两次输入的密码不一致")
					.setPositiveButton("确定",null)
					.show();
					return;
				}
				
				if(!isChecked)
				{
					//弹出对话框，验证是否填写用户名
					new AlertDialog.Builder(MainActivity.this)
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle("警告")
					.setMessage("请勾选同意条款")
					.setPositiveButton("确定",null)
					.show();
					return;
				}
				
				//发送数据到另一个Activity
				Bundle bundle = new Bundle();
				bundle.putString("username",strUser);
				bundle.putString("password",strPassword);
				bundle.putBoolean("check", isChecked);
				Intent intent = new Intent(MainActivity.this,Success.class);
				intent.putExtra("info", bundle);
				//启动这个Activity
				
				MainActivity.this.startActivity(intent);
				MainActivity.this.finish();
				
								
			}
			});
		//添加取消的监听事件
		cancel.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg0)
			{
				MainActivity.this.finish();
			}
		});
		
		
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main,
					container, false);
			return rootView;
		}
	}

}
