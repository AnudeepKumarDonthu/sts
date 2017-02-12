package spring.rest.get;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spring.rest.model.Employee;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * class for writing REST web service using Spring with GET method
 * @author Donthu Avinash Babu
 *
 */
@RestController
public class GetRequests {

    @Autowired
    @Qualifier("objectMapper")
    private ObjectMapper mapper;

    /**
     * Method to return plain string as rest response
     * 
     * @return
     */
    @RequestMapping(value = "/method1", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String method1() {
	return "Test method()";
    }

    /**
     * Method to return json String as response
     * 
     * @return
     */
    @RequestMapping(value = "/method2", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String method2() {
	Employee employee = new Employee("ramesh", "address1");
	String result = "";
	try {
	    result = mapper.writeValueAsString(employee);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return result;
    }

    /**
     * Method to return JSON string as response but object will be converted to
     * JSON automatically
     */
    @RequestMapping(value = "/method3", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee method3() {
	Employee employee = new Employee("suresh", "address1");
	return employee;
    }

    /**
     * Method to return String as response {@link ResponseBody} added. this is
     * difference between method1 and this method
     * 
     * @return
     */
    @RequestMapping(value = "/method4", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody String method4() {
	return "Test method4()";
    }

    /**
     * Method to return JSON as response
     * 
     * @return
     */
    @RequestMapping(value = "/method5", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Employee method5() {
	Employee employee = new Employee("mahesh", "address5");
	return employee;
    }

    /**
     * Method to access variable in URL.
     * 
     * @param var
     * @return
     */
    @RequestMapping(value = "/method6/{variable1}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Employee method6(@PathVariable(value = "variable1") String var) {
	System.out.println("var: " + var);
	Employee employee = new Employee("mahesh", "address5");
	employee.setId(var);
	return employee;
    }

    /**
     * Demo request parameter URL:
     * http://localhost:9091/SpringRest/method7?id=10
     * 
     * @param var
     * @return
     */
    @RequestMapping(value = "/method7", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Employee method7(@RequestParam(value = "id", required = false) String var) {
	System.out.println("var: " + var);
	Employee employee = new Employee("mahesh", "address5");
	employee.setId(var);
	return employee;
    }

    /**
     * list of objects as JSON value
     * 
     * @return
     */
    @RequestMapping(value = "/method8", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Employee> method8() {
	Employee employee1 = new Employee("test1", "address1");
	Employee employee2 = new Employee("test2", "address2");
	Employee employee3 = new Employee("test3", "address3");
	Employee employee4 = new Employee("test4", "address4");

	return Arrays.asList(employee1, employee2, employee3, employee4);
    }

    /**
     * URL contains name, address as request params like:
     * baseURL?name=test&address=test
     * 
     * @param name
     * @param address
     * @return
     */
    @RequestMapping(value = "/method9", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Employee> method9(@RequestParam(value = "name", required = true) String name,
	    @RequestParam(value = "address", required = false) String address) {
	Employee employee1 = new Employee("test9", "address9");
	Employee employee2 = new Employee(name, address);
	return Arrays.asList(employee1, employee2);
    }

    /**
     * URL contains name and address. Ex: /baseUrl/{name}/{address}
     * 
     * @param name
     * @param address
     * @return
     */
    @RequestMapping(value = "/method10/{name}/{address}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Employee> method10(@PathVariable(value = "name") String name, @PathVariable(value = "address") String address) {
	Employee employee1 = new Employee("test10", "address10");
	Employee employee5 = new Employee(name, address);
	return Arrays.asList(employee1, employee5);
    }

    /**
     * Passing request headers along with REST request. in Postman -> Headers
     * tab -> give key-value pairs (for example: name-testing, address-testing)
     * 
     * @param name
     * @param address
     * @return
     */
    @RequestMapping(value = "/method11", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Employee> method11(@RequestHeader(value = "name") String name, @RequestHeader(value = "address") String address) {
	Employee employee1 = new Employee("test11", "address11");
	Employee employee5 = new Employee(name, address);
	return Arrays.asList(employee1, employee5);
    }

    /**
     * Method to demonstrate that we can write GET service using
     * {@link org.springframework.web.bind.annotation.GetMapping} annotation
     * 
     * @param name
     * @param address
     * @return
     */
    @GetMapping(value = "/method12/{name}/{address}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Employee> method12(@PathVariable("name") String name, @PathVariable("address") String address) {
	Employee employee1 = new Employee("test12", "address12");
	Employee employee2 = new Employee(name, address);
	return Arrays.asList(employee1, employee2);
    }

    /**
     * Return result as org.springframework.http.ResponseEntity<List<Employee>>
     * @return
     */
    @RequestMapping(value = "/method13", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Employee>> method13() {
	Employee employee1 = new Employee("test1", "address1");
	Employee employee2 = new Employee("test2", "address2");
	Employee employee3 = new Employee("test3", "address3");
	Employee employee4 = new Employee("test4", "address4");

	List<Employee> list = Arrays.asList(employee1, employee2, employee3, employee4);
	ResponseEntity<List<Employee>> responseEntity = new ResponseEntity<List<Employee>>(list, HttpStatus.OK);

	return responseEntity;
    }

    /**
     * Sample URL: http://localhost:9091/SpringRest/method14?name=name1&name=name2&address=address1&address=address2
     * @param names
     * @param addresses
     * @return
     */
    @RequestMapping(value = "/method14", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Employee> method14(@RequestParam("name") List<String> names, @RequestParam("address") List<String> addresses) {
	System.out.println("names: " + names + ", addresses: " + addresses);
	Employee employee1 = new Employee(names.get(0), addresses.get(0));
	Employee employee2 = new Employee(names.get(1), addresses.get(1));
	return Arrays.asList(employee1, employee2);
    }
}
