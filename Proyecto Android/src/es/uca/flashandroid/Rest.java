package es.uca.flashandroid;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;



import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class Rest extends Fragment {
	TextView MiLabel;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
		View vista = inflater.inflate(R.layout.rest,container, false);

		Button MiBoton2=(Button)vista.findViewById(R.id.botLocal);
		MiBoton2.setOnClickListener(new View.OnClickListener() 
		{
		@Override
		public void onClick(View view) {
			new LongRunningGetIO().execute();
			}
		});
		

	      return vista;
	}
	public void mensaje(){
		Toast.makeText(getActivity(), "Servicio se ha ejecutado",Toast.LENGTH_SHORT).show();
	}
	private class LongRunningGetIO extends AsyncTask <Void, Void, String> {

		@Override
		protected String doInBackground (Void ...params){
			HttpClient httpClient = new DefaultHttpClient();
			HttpContext localContext = new BasicHttpContext();
			HttpGet httpGet = new HttpGet("http://maps.googleapis.com/maps/api/geocode/xml?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&sensor=true_or_false");
			String text = null;
			try {
				HttpResponse response = httpClient.execute(httpGet, localContext);
				HttpEntity entity = response.getEntity();
				Log.v("Test","En la invocaci�n");
				text=EntityUtils.toString(entity);
			} catch (Exception e) { return e.toString(); }

		return text; }	
		
		
		protected void onPostExecute(String results) {
			mensaje();
			if (results!=null) {			
				MiLabel=(TextView)getActivity().findViewById(R.id.textPosicion);
				MiLabel.setText(results); 
				}
		}

		}
	
}