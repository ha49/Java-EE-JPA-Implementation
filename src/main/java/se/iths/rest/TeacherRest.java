package se.iths.rest;

import se.iths.entity.Teacher;
import se.iths.exceptions.RequiredFieldIsEmptyException;
import se.iths.exceptions.TeacherNotFoundException;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("teacher")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {

    @Inject
    TeacherService teacherService;

    @Path("new")
    @POST
    public Response addStudent(Teacher teacher) {

        if (RequiredFieldIsEmpty(teacher)) {
            throw new RequiredFieldIsEmptyException("Firstname, lastname and e-mail can not be empty. \nPlease fill " +
                    "all required fields.");

        } else {
            teacherService.addTeacher(teacher);
            return Response.ok(teacher).build();
        }
    }


    @Path("update")
    @PUT
    public Response updateTeacher(Teacher teacher) {
        teacherService.updateTeacher(teacher);
        return Response.ok(teacher).build();
    }

    @Path("{id}")
    @GET
    public Response getTeacher(@PathParam("id") Long id) {
        Teacher foundTeacher = teacherService.findTeacherById(id);
        if (foundTeacher != null) {
            return Response.ok(foundTeacher).build();
        } else {
            throw new TeacherNotFoundException("Teacher with ID:" + id + " not found");
            //              return Response.status(Response.Status.NOT_FOUND).entity("Item with ID:" + id+ " not found").type(MediaType.TEXT_PLAIN_TYPE).build();
        }
    }


    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @DELETE

    public Response removeTeacher(@PathParam("id") Long id) {
        Teacher foundTeacher = teacherService.findTeacherById(id);
        if (foundTeacher != null) {
            teacherService.deleteTeacher(id);
            return Response.ok().entity("teacher with id: " + id + " was successfully removed").build();
        } else {
            throw new TeacherNotFoundException("Teacher with ID:" + id + " not found");

        }
    }


    @Path("getall")
    @GET
    public List<Teacher> getAllTeachers() {
        List<Teacher> teacherList = teacherService.getAllTeachers();
        if (teacherList.isEmpty()) {
            throw new TeacherNotFoundException("Currently there is no teacher information recorded in the database");
        } else {
            return teacherService.getAllTeachers();
        }
    }

    @Path("getbyname_np/{name}")
    @GET
    public List<Teacher> getByNameNP(@PathParam("name") String name) {

        List<Teacher> teacherList = teacherService.getTeacherByLastNameNamedParameters(name);
        if (teacherList.isEmpty()) {
            throw new TeacherNotFoundException("There is no teacher with surname " + name);
        } else {
            return teacherService.getTeacherByLastNameNamedParameters(name);
        }
    }

    private static Boolean RequiredFieldIsEmpty(Teacher teacher) {

        return teacher.getFirstName().isBlank() || teacher.getLastName().isBlank() || teacher.getEmail().isBlank();

    }


}
