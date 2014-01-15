package es.uca.flashandroid;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;




//import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
			
			final EditText txtTexto = (EditText)getActivity().findViewById(R.id.inputCalle);
			String calle = txtTexto.getText().toString();
			final EditText txtNumero = (EditText)getActivity().findViewById(R.id.inputNumero);
			String numero = txtNumero.getText().toString();
			final EditText txtCiudad = (EditText)getActivity().findViewById(R.id.inputCiudad);
			String ciudad = txtCiudad.getText().toString();
		
			HttpGet httpGet = new HttpGet("http://maps.googleapis.com/maps/api/geocode/xml?address="+calle+"+"+numero+"+"+ciudad+"&sensor=true");
			String text = null;
			try {
				HttpResponse response = httpClient.execute(httpGet, localContext);
				HttpEntity entity = response.getEntity();
				Log.v("Test","En la invocaci�n");
				text=EntityUtils.toString(entity);
			} catch (Exception e) { return e.toString(); }

		return text; 
		
		/*	HttpClient httpClient = new DefaultHttpClient();
		 
			final EditText txtTexto = (EditText)getActivity().findViewById(R.id.inputCalle);
			String calle = txtTexto.getText().toString();
			final EditText txtNumero = (EditText)getActivity().findViewById(R.id.inputNumero);
			String numero = txtNumero.getText().toString();
			final EditText txtCiudad = (EditText)getActivity().findViewById(R.id.inputCiudad);
			String ciudad = txtCiudad.getText().toString();
			
			HttpGet httpGet = new HttpGet("http://maps.googleapis.com/maps/api/geocode/json?address="+calle+"+"+numero+"+"+ciudad+"&sensor=false");
			httpGet.setHeader("content-type", "application/json");
			String respStr = null;
			try {
				HttpResponse response=httpClient.execute(httpGet);
				respStr = EntityUtils.toString(response.getEntity());
				
				JSONObject respJSON = new JSONObject(respStr);
				String nombre = respJSON.getString("formatted_address");
				//String autor = respJSON.getString("location");
				respStr= nombre ;
			} catch (Exception e) { return e.toString(); }
			return respStr; */
		
		}	
		
		
		protected void onPostExecute(String results) {
			mensaje();
			if (results!=null) {			
				MiLabel=(TextView)getActivity().findViewById(R.id.textPosicion);
				MiLabel.setText(results); 
				}
		}

		}
	
}