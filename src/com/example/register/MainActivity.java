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
		setTitle("ע��");
		final EditText username=(EditText)findViewById(R.id.editText_username);
		final EditText password=(EditText)findViewById(R.id.editText_password);
		final EditText rePassword=(EditText)findViewById(R.id.editText_rePassword);
		final CheckBox check =(CheckBox)findViewById(R.id.checkbox);
		Button reg = (Button)findViewById(R.id.button_register);
		Button cancel = (Button)findViewById(R.id.button_cancel);
		//���checkbox�ļ����¼�
		
		check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		@Override
			public void onCheckedChanged(CompoundButton arg0, boolean flag) {
			// TODO Auto-generated method stub
				isChecked=flag;
			}
			});
			
		
		//���ע��ļ����¼�
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
					//�����Ի�����֤�Ƿ���д�û���
					new AlertDialog.Builder(MainActivity.this)
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle("����")
					.setMessage("�������û���")
					.setPositiveButton("ȷ��",null)
					.show();
					return;
				}
				if(!strPassword.equals(strRePassword))
				{
					//�����Ի�����֤�Ƿ���д�û���
					new AlertDialog.Builder(MainActivity.this)
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle("����")
					.setMessage("������������벻һ��")
					.setPositiveButton("ȷ��",null)
					.show();
					return;
				}
				
				if(!isChecked)
				{
					//�����Ի�����֤�Ƿ���д�û���
					new AlertDialog.Builder(MainActivity.this)
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle("����")
					.setMessage("�빴ѡͬ������")
					.setPositiveButton("ȷ��",null)
					.show();
					return;
				}
				
				//�������ݵ���һ��Activity
				Bundle bundle = new Bundle();
				bundle.putString("username",strUser);
				bundle.putString("password",strPassword);
				bundle.putBoolean("check", isChecked);
				Intent intent = new Intent(MainActivity.this,Success.class);
				intent.putExtra("info", bundle);
				//�������Activity
				
				MainActivity.this.startActivity(intent);
				MainActivity.this.finish();
				
								
			}
			});
		//���ȡ���ļ����¼�
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
