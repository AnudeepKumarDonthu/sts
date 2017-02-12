package spring.rest.post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spring.rest.model.Employee;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class PostRequests {

    @Autowired
    @Qualifier("objectMapper")
    private ObjectMapper mapper;

    /**
     * POST request with JSON input body return JSON response. URL:
     * http://localhost:9091/SpringRest/method1 method: POST body: { "id": "10",
     * "name": "testing1", "address": "testing2" }
     * 
     * @param inputJson
     * @return
     */
    @RequestMapping(value = "/method1", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Employee> method1(@RequestBody String inputJson) {
	Employee employee;
	List<Employee> list = new ArrayList<>();
	try {
	    employee = mapper.readValue(inputJson, Employee.class);
	    Employee employee1 = new Employee("test1", "address1");
	    list.add(employee1);
	    list.add(employee);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return list;
    }

    /**
     * POST method with input JSON and path variables. URL:
     * http://localhost:9091/SpringRest/method2/testing2/testing2 body: { "id":
     * "10", "name": "testing1", "address": "testing2" }
     * 
     * @param inputJson
     * @param name
     * @param address
     * @return
     */
    @RequestMapping(value = "/method2/{name}/{address}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Employee> method2(@RequestBody String inputJson, @PathVariable(value = "name") String name,
	    @PathVariable(value = "address") String address) {
	List<Employee> list = new ArrayList<>();
	try {
	    Employee employee1 = mapper.readValue(inputJson, Employee.class);
	    Employee employee2 = new Employee(name, address);
	    list.add(employee1);
	    list.add(employee2);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return list;
    }

    /**
     * POST method with input JSON and path variables. URL:
     * http://localhost:9091/SpringRest/method3?name=testing2&address=testing2
     * body: { "id": "10", "name": "testing1", "address": "testing2" }
     * 
     * @param inputJson
     * @param name
     * @param address
     * @return
     */
    @RequestMapping(value = "/method3", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Employee> method3(@RequestBody String inputJson, @RequestParam(value = "name", required = true) String name,
	    @RequestParam(value = "address", required = false) String address) {
	List<Employee> list = new ArrayList<>();
	try {
	    Employee employee1 = mapper.readValue(inputJson, Employee.class);
	    Employee employee2 = new Employee(name, address);
	    list.add(employee1);
	    list.add(employee2);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return list;
    }

    /**
     * POST method with input JSON and path variables. URL:
     * http://localhost:9091/SpringRest/method4 body: { "id": "10", "name":
     * "testing1", "address": "testing2" }. In Postman -> Headers tab -> give
     * key-value pairs (for example: name-testing, address-testing)
     * 
     * @param inputJson
     * @param name
     * @param address
     * @return
     */
    @RequestMapping(value = "/method4", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Employee> method4(@RequestBody String inputJson, @RequestHeader(value = "name") String name,
	    @RequestHeader(value = "address") String address) {
	List<Employee> list = new ArrayList<>();
	try {
	    Employee employee1 = mapper.readValue(inputJson, Employee.class);
	    Employee employee2 = new Employee(name, address);
	    list.add(employee1);
	    list.add(employee2);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return list;
    }

    /**
     * Method to demonstrate
     * {@link org.springframework.web.bind.annotation.PostMapping}
     * 
     * @param inputJson
     * @param name
     * @param address
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    @PostMapping(value = "/method5/{name}/{address}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Employee> method5(@RequestBody String inputJson, @PathVariable("name") String name,
	    @PathVariable("address") String address) throws JsonParseException, JsonMappingException, IOException {
	System.out.println("method5() -> inputJson: " + inputJson);
	Employee employee1 = mapper.readValue(inputJson, Employee.class);
	Employee employee2 = new Employee(name, address);
	return Arrays.asList(employee1, employee2);
    }
}
