package com.servicio.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;


public class Cliente {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ClientProtocolException, IOException {		
		    @SuppressWarnings("deprecation")
			HttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost("http://localhost:8060/WebServiceJersey/GetApi/agregar");
		  List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		    formparams.add(new BasicNameValuePair("name", "jaime"));
		    formparams.add(new BasicNameValuePair("surname", "rodas"));
		    formparams.add(new BasicNameValuePair("age", "31"));
		    formparams.add(new BasicNameValuePair("title", "Licenciado"));
		    formparams.add(new BasicNameValuePair("desc", "Analista"));
		    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
		    post.setEntity(entity);
		    System.out.println("=="+entity);
		    System.out.println("=="+post);
		    HttpResponse httpresponse = httpClient.execute(post);
		    HttpEntity resEntity = httpresponse.getEntity();		   
		    System.out.println(httpresponse.getStatusLine());
		   
	}

}
