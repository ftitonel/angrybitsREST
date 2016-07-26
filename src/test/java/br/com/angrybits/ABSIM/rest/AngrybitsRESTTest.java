package br.com.angrybits.ABSIM.rest;

public class AngrybitsRESTTest {
	
//	private CloseableHttpClient client;
//
//	private ObjectMapper mapper;
//
//	private String url;
//
//	@Before
//	public void before() throws Exception {
//		client = HttpClientBuilder.create().build();
//		mapper = new ObjectMapper();
//
//		Configuration config = new PropertiesConfiguration("test.properties");
//		url = config.getString("services.url");
//	}
//
//	@After
//	public void after() throws Exception {
//		client.close();
//	}
//	
//	private CloseableHttpResponse createSample() throws Exception {
//		
//		String consumo = "ConsumoTeste";
//
//		HttpPost request = new HttpPost(url + "/consumo");
//		request.setEntity(EntityBuilder.create().setText(mapper.writeValueAsString(consumo)).build());
//		request.addHeader("Content-Type", "application/json");
//		//request.addHeader("Authorization", BASIC_CREDENTIALS);
//
//		CloseableHttpResponse response = client.execute(request);
//		response.close();
//
//		return response;
//	}
//	
//	private <T> T parseEntity(HttpEntity entity, Class<T> type) throws Exception {
//		return mapper.readValue(entity.getContent(), type);
//	}
//	
//	private void destroySample(Long id) throws Exception {
//		HttpDelete request = new HttpDelete(url + "/bookmark/" + id);
//		//request.addHeader("Authorization", BASIC_CREDENTIALS);
//		client.execute(request).close();
//	}
//	
//	@Test
//	public void insertSuccessful() throws Exception {
//		CloseableHttpResponse response = createSample();
//		response.close();
//
//		Long id = parseEntity(response.getEntity(), Long.class);
//		assertNotNull(id);
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
