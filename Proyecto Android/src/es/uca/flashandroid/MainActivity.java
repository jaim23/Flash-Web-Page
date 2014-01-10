package es.uca.flashandroid;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;


@SuppressWarnings("unused")
public class MainActivity extends FragmentActivity {
	private String[] opcionesMenu;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private CharSequence tituloSeccion;
	private CharSequence tituloApp;
	private ActionBarDrawerToggle mDrawerToggle;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		opcionesMenu = new String[] {"General", "Atletismo", "Baloncesto","Fútbol"};
		mDrawerLayout = (DrawerLayout) 
		findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) 
		findViewById(R.id.left_drawer); 
		mDrawerList.setAdapter(new ArrayAdapter<String>(getActionBar().getThemedContext(),android.R.layout.simple_list_item_1,opcionesMenu));
		
		
		mDrawerList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(@SuppressWarnings("rawtypes") AdapterView parent, View view, int position, long id) {
				Fragment fragment = null;
				switch (position) {
					case 0: fragment = new General(); break;
					case 1: fragment = new Atletismo(); break;
					case 2: fragment = new Baloncesto(); break;
					case 3: fragment = new Futbol(); break;
					}
				FragmentManager fragmentManager = getSupportFragmentManager();
				fragmentManager.beginTransaction().
				replace(R.id.content_frame,fragment).commit();
				mDrawerList.setItemChecked(position, true);
				tituloSeccion = opcionesMenu[position];
				getActionBar().setTitle(tituloSeccion);
				mDrawerLayout.closeDrawer(mDrawerList); }  
			});
		
		tituloSeccion = getTitle(); tituloApp = getTitle(); 
			mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
			mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.drawable.menu_desplegable, R.string.drawer_open, R.string.drawer_close) 
			{
				public void onDrawerClosed(View view) {
					getActionBar().setTitle(tituloSeccion);
					invalidateOptionsMenu(); }
				public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(tituloApp);
				invalidateOptionsMenu(); }
				};
				mDrawerLayout.setDrawerListener(mDrawerToggle);
				getActionBar().setDisplayHomeAsUpEnabled(true);
				getActionBar().setHomeButtonEnabled(true);
							
	}
	
	@Override 
	public boolean onPrepareOptionsMenu(Menu menu) {
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		//MenuInflater inflater = getMenuInflater();
		//inflater.inflate(R.menu.main, menu);
		return super.onPrepareOptionsMenu(menu);
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState){
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState(); }
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)){return true;}
		return super.onOptionsItemSelected(item); }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/*@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		textView = (TextView) findViewById(R.id.txt2);
		switch (item.getItemId()) {
		case R.id.MnuOpc1:
			textView.setText("Opcion 1 pulsada!");
		return true;
		case R.id.MnuOpc2:
			textView.setText("Opcion 2 pulsada!");;
		return true;
		case R.id.MnuOpc3:
			textView.setText("Opcion 3 pulsada!");;
		return true;
		default:
		return super.onOptionsItemSelected(item);
		}
	}*/

}
