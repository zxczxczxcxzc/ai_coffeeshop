package test;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import bean.Staffs;

public class TestAPI {

	private Client client;
	private String REST_SERVICE_URL = "http://localhost:8080/Restful_API_AI_CoffeeShop/staffs/action-staffs";
	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String PASS = "pass";
	private static final String FAIL = "fail";

	private TestAPI() {
		this.client = ClientBuilder.newClient();
	}

	private void testGetAllUsers() {
		GenericType<List<Staffs>> list = new GenericType<List<Staffs>>() {
		};
		List<Staffs> staffs = client.target(REST_SERVICE_URL).request(MediaType.APPLICATION_XML).get(list);
		String result = PASS;
		if (staffs.isEmpty()) {
			result = FAIL;
		}
		System.out.println("Test case name: testGetAllUsers, Result: " + result);
	}

	private void testInsertStaff() {
		Form form = new Form();
		form.param("fullname", "Lê Văn A");
		form.param("email", "alen@gmai.com");
		form.param("gender", "1");
		form.param("dateofbirth", "20/10/1997");
		form.param("phone", "0337272727");
		String callResult = client.target(REST_SERVICE_URL).request(MediaType.APPLICATION_XML)
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}

		System.out.println("Test case name: testInsertStaff, Result: " + result);
	}

	private void testUpdateStaff() {
		Form form = new Form();
		form.param("id", "1");
		form.param("fullname", "Nguyễn Trọng Hiếu");
		form.param("email", "trongnghianguyen1003@gmai.com");
		form.param("gender", "1");
		form.param("dateofbirth", "10/03/1997");
		form.param("phone", "0336660207");

		String callResult = client.target(REST_SERVICE_URL).request(MediaType.APPLICATION_XML)
				.put(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}

		System.out.println("Test case name: testUpdateStaff, Result: " + result);
	}

	private void testDeleteStaff() {
		String callResult = client.target(REST_SERVICE_URL).path("/{id}").resolveTemplate("id", "2")
				.request(MediaType.APPLICATION_XML).delete(String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}

		System.out.println("Test case name: testDeleteUser, Result: " + result);
	}

	public static void main(String[] args) {
		TestAPI test = new TestAPI();
		test.testDeleteStaff();
	}

}
