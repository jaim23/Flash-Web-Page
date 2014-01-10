package es.uca.flashandroid;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends FragmentActivity {
	
	private String[] opcionesMenu;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private CharSequence tituloApp;
	private CharSequence tituloSeccion;
	private ActionBarDrawerToggle mDrawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		opcionesMenu = new String[] {"General", "Atletismo", "Baloncesto", "Fútbol"};
		mDrawerLayout = (DrawerLayout)
		findViewById(R.id.drawer_layout);
		mDrawerList = (ListView)
		findViewById(R.id.left_drawer);
		mDrawerList.setAdapter(new ArrayAdapter<String>(getActionBar().getThemedContext(),android.R.layout.simple_list_item_1,opcionesMenu));
		
		mDrawerList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView parent, View view, int position, long id) {
			Fragment fragment = null;
			switch (position) 
			{
				case 0: fragment = new General(); break;
				case 1: fragment = new Atletismo(); break;
				case 2: fragment = new Baloncesto(); break;
				case 3: fragment = new Futbol();break;
			}
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction().
			replace(R.id.content_frame,fragment).commit();
			mDrawerList.setItemChecked(position, true);
			tituloSeccion = opcionesMenu[position];
			getActionBar().setTitle(tituloSeccion);
			mDrawerLayout.closeDrawer(mDrawerList); } });
		
			tituloSeccion = getTitle(); tituloApp = getTitle();
			mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
			mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.drawable.ic_launcher, R.string.drawer_open, R.string.drawer_close)
			{
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(tituloSeccion);
				invalidateOptionsMenu(); // calls to onPrepareOptionsMenu() 
			}
			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(tituloApp);
				invalidateOptionsMenu(); // calls to onPrepareOptionsMenu()
			}
			};
			mDrawerLayout.setDrawerListener(mDrawerToggle);
			getActionBar().setDisplayHomeAsUpEnabled(true);
			getActionBar().setHomeButtonEnabled(true);
			
	}
	
	@Override public boolean onPrepareOptionsMenu(Menu menu) {
				boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
				menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
				return super.onPrepareOptionsMenu(menu);
		}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
