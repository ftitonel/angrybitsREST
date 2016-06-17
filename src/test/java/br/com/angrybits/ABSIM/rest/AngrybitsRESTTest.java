package br.com.angrybits.ABSIM.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AngrybitsRESTTest {
	
	private CloseableHttpClient client;

	private ObjectMapper mapper;

	private String url;

	@Before
	public void before() throws Exception {
		client = HttpClientBuilder.create().build();
		mapper = new ObjectMapper();

		Configuration config = new PropertiesConfiguration("test.properties");
		url = config.getString("services.url");
	}

	@After
	public void after() throws Exception {
		client.close();
	}
	
//	@Test
//	public void insertSuccessful() throws Exception {		
//
//		String expectedLocation = url + "/bookmark/" + id;
//		String returnedLocation = response.getHeaders("Location")[0].getValue();
//		assertEquals(expectedLocation, returnedLocation);
//
//		HttpGet request = new HttpGet(returnedLocation);
//		response = client.execute(request);
//		response.close();
//
//		destroySample(id);
//	}

}
