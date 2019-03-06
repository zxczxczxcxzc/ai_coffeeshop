package rest.api;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import bean.Staffs;
import bo.StaffsBO;

@Path("/staffs")
public class StaffsAPI {

	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String FAILURE_RESULT = "<result>failure</result>";

	StaffsBO staffsBO = new StaffsBO();

	@GET
	@Path("/action-staffs")
	@Produces("application/json")
	public List<Staffs> getListStaffs() {
		List<Staffs> list = staffsBO.getListStaffs();
		return list;
	}

	@POST
	@Path("/action-staffs")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String insertStaff(@FormParam("fullname") String fullname, @FormParam("email") String email,
			@FormParam("gender") String gender, @FormParam("dateofbirth") String dateOfBirth,
			@FormParam("phone") String phone, @Context HttpServletResponse servletResponse) {

		if (staffsBO.insertStaff(fullname, email, gender, dateOfBirth, phone)) {
			// return "{\"status\":\"true\"}";
			return SUCCESS_RESULT;
		} else {
			// return "{\"status\":\"false\"}";
			return FAILURE_RESULT;
		}
	}

	@PUT
	@Path("/action-staffs")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateStaff(@FormParam("id") String id, @FormParam("fullname") String fullname,
			@FormParam("email") String email, @FormParam("gender") String gender,
			@FormParam("dateofbirth") String dateOfBirth, @FormParam("phone") String phone,
			@Context HttpServletResponse servletResponse) {
		if (staffsBO.updateStaff(id, fullname, email, gender, dateOfBirth, phone)) {
			return SUCCESS_RESULT;
		} else {
			return FAILURE_RESULT;
		}
	}

	@DELETE
	@Path("/action-staffs/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String deleteStaff(@PathParam("id") String id) {
		if (staffsBO.deleteStaff(id)) {
			return SUCCESS_RESULT;
		} else {
			return FAILURE_RESULT;
		}
	}

	@OPTIONS
	@Path("/action-staffs")
	@Produces(MediaType.APPLICATION_XML)
	public String getSupportedOperations() {
		return "<operations>GET, PUT, POST, DELETE</operations>";
	}
}
