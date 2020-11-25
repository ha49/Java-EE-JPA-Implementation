package se.iths.rest;


import se.iths.entity.Student;
import se.iths.exceptions.RequiredFieldIsEmptyException;
import se.iths.exceptions.StudentNotFoundException;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;


    @Path("new")
    @POST
    public Response addStudent(Student student) {

        if (RequiredFieldIsEmpty(student)) {
            throw new RequiredFieldIsEmptyException("Firstname, lastname and e-mail can not be empty. \nPlease fill " +
                    "all required fields.");

        } else {
            studentService.addStudent(student);
            return Response.ok(student).build();
        }
    }


    @Path("update")
    @PUT
    public Response updateStudent(Student student) {
        studentService.updateStudent(student);
        return Response.ok(student).build();
    }

    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent != null) {
            return Response.ok(foundStudent).build();
        } else {
            throw new StudentNotFoundException("Student with ID:" + id + " not found");
            //              return Response.status(Response.Status.NOT_FOUND).entity("Item with ID:" + id+ " not found").type(MediaType.TEXT_PLAIN_TYPE).build();
        }
    }


    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @DELETE

    public Response removeStudent(@PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent != null) {
            studentService.deleteStudent(id);
            return Response.ok().entity("student with id: " + id + " was successfully removed").build();
        } else {
            throw new StudentNotFoundException("Student with ID:" + id + " not found");

        }
    }


    @Path("getall")
    @GET
    public List<Student> getAllStudents() {
        List<Student> studentList = studentService.getAllStudents();
        if (studentList.isEmpty()) {
            throw new StudentNotFoundException("Currently there is no student information recorded in the database");
        } else {
            return studentService.getAllStudents();
        }
    }

    @Path("getbyname_np/{name}")
    @GET
    public List<Student> getByNameNP(@PathParam("name") String name) {

        List<Student> studentList = studentService.getByLastNameNamedParameters(name);
        if (studentList.isEmpty()) {
            throw new StudentNotFoundException("There is no student with surname " + name);
        } else {
            return studentService.getByLastNameNamedParameters(name);
        }
    }

    private static Boolean RequiredFieldIsEmpty(Student student) {

        return student.getFirstName().isBlank() || student.getLastname().isBlank() || student.getEmail().isBlank();

    }

}
