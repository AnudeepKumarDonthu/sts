package spring.rest.get;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import spring.rest.model.Employee;

/**
 * class to practice REST web service with GET method
 * @author Donthu Avinash Babu
 *
 */
public class GetRequestsClient {

    public static void main(String[] args) {
	GetRequestsClient getRequestsClient = new GetRequestsClient();
	getRequestsClient.method3();
    }

    /**
     * Rest Client for {@link GetRequests#method1()}
     */
    public void method1() {
	final String url = "http://localhost:8081/SpringRest/method1";
	RestTemplate restTemplate = new RestTemplate();
	String result = restTemplate.getForObject(url, String.class);
	System.out.println("GetRequestClient.method1() result: " + result);
    }

    /**
     * Rest Client for {@link GetRequests#method2()}
     */
    public void method2() {
	final String url = "http://localhost:8081/SpringRest/method2";
	RestTemplate restTemplate = new RestTemplate();
	String result = restTemplate.getForObject(url, String.class);
	System.out.println("GetRequestClient.method2() result: " + result);

	Employee result2 = restTemplate.getForObject(url, Employee.class);
	System.out.println("GetRequestClient.method2() result2: " + result2);
    }

    /**
     * Rest client for  {@link GetRequests#method3()}
     */
    public void method3() {
	final String url = "http://localhost:8081/SpringRest/method3";
	RestTemplate restTemplate = new RestTemplate();
	String result = restTemplate.getForObject(url, String.class);
	System.out.println("GetRequestClient.method3() result: " + result);
    }

    /**
     * Rest client for  {@link GetRequests#method4()}
     */
    public void method4() {
	final String url = "http://localhost:8081/SpringRest/method4";
	RestTemplate restTemplate = new RestTemplate();
	String result = restTemplate.getForObject(url, String.class);
	System.out.println("GetRequestClient.method4() result: " + result);
    }

    /**
     * Rest client for  {@link GetRequests#method5()}
     */
    public void method5() {
	final String url = "http://localhost:8081/SpringRest/method5";
	RestTemplate restTemplate = new RestTemplate();
	String result = restTemplate.getForObject(url, String.class);
	System.out.println("GetRequestClient.method5() result: " + result);
    }

    /**
     * Rest client for  {@link GetRequests#method6()}
     */
    public void method6() {
	final String url = "http://localhost:8081/SpringRest/method6/{variable1}";

	Map<String, String> params = new HashMap<>();
	params.put("variable1", "10");

	RestTemplate restTemplate = new RestTemplate();
	String result = restTemplate.getForObject(url, String.class, params);

	System.out.println("GetRequestClient.method6() result: " + result);
    }

    /**
     * Rest client for  {@link GetRequests#method7()}
     */
    public void method7() {
	final String url = "http://localhost:8081/SpringRest/method7?id=20";
	RestTemplate restTemplate = new RestTemplate();
	String result = restTemplate.getForObject(url, String.class);
	System.out.println("GetRequestClient.method7() result: " + result);
    }

    /**
     * Rest client for  {@link GetRequests#method8()}
     */
    public void method8() {
	final String url = "http://localhost:8081/SpringRest/method8";
	RestTemplate restTemplate = new RestTemplate();
	String result = restTemplate.getForObject(url, String.class);
	System.out.println("GetRequestClient.method8() result: " + result);
    }

    /**
     * Rest client for  {@link GetRequests#method9()}
     */
    public void method9() {
	final String url = "http://localhost:8081/SpringRest/method9?name=restClientName&address=restClientAddress";
	RestTemplate restTemplate = new RestTemplate();
	String result = restTemplate.getForObject(url, String.class);
	System.out.println("GetRequestClient.method9() result: " + result);
    }

    /**
     * Rest client for  {@link GetRequests#method10()}
     */
    public void method10() {
	final String url = "http://localhost:8081/SpringRest/method10/{name}/{address}";

	Map<String, String> params = new HashMap<>();
	params.put("name", "restClientName");
	params.put("address", "restClientAddress");

	RestTemplate restTemplate = new RestTemplate();
	String result = restTemplate.getForObject(url, String.class, params);

	System.out.println("GetRequestClient.method10() result: " + result);
    }

    /**
     * Rest client for  {@link GetRequests#method11()}
     */
    public void method11() {
	final String url = "http://localhost:8081/SpringRest/method11";

	HttpHeaders httpHeaders = new HttpHeaders();
	httpHeaders.set("name", "restClientName");
	httpHeaders.set("address", "restClientAddress");
	HttpEntity<String> httpEntity = new HttpEntity<String>("parameters", httpHeaders);

	RestTemplate restTemplate = new RestTemplate();
	ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
	System.out.println("GetRequestClient.method11() result: " + result.getBody());
    }

    /**
     * Rest client for  {@link GetRequests#method12()}
     */
    @Test
    public void method12() {
	final String url = "http://localhost:8081/SpringRest/method12/{name}/{address}";

	Map<String, String> params = new HashMap<>();
	params.put("name", "restClientName");
	params.put("address", "restClientAddress");

	RestTemplate restTemplate = new RestTemplate();
	String result = restTemplate.getForObject(url, String.class, params);

	System.out.println("method12() result: " + result);
    }

    /**
     * {@link GetRequests#method13()}
     */
    @Test
    public void method13() {
	final String url = "http://localhost:8081/SpringRest/method13";
	RestTemplate restTemplate = new RestTemplate();
	String result = restTemplate.getForObject(url, String.class);

	System.out.println("method13() result: " + result);
    }

    /**
     * {@link GetRequests#method14(java.util.List, java.util.List)}}
     */
    @Test
    public void method14() {
	final String url = "http://localhost:8081/SpringRest/method14?name=name1&name=name2&address=address1&address=address2";
	RestTemplate restTemplate = new RestTemplate();
	String result = restTemplate.getForObject(url, String.class);

	System.out.println("method14() result: " + result);
    }
}
