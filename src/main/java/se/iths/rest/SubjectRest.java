package se.iths.rest;

import se.iths.entity.Subject;
import se.iths.exceptions.RequiredFieldIsEmptyException;
import se.iths.exceptions.StudentNotFoundException;
import se.iths.exceptions.SubjectNotFoundException;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subject")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {


    @Inject
    SubjectService subjectService;



    @Path("new")
    @POST
    public Response addSubject(Subject subject) {

        if (RequiredFieldIsEmpty(subject)) {
            throw new RequiredFieldIsEmptyException("subject matter can not be empty. \nPlease fill " +
                    "all required field.");

        } else {
            subjectService.addSubject(subject);
            return Response.ok(subject).build();
        }
    }


    @Path("update")
    @PUT
    public Response updateSubject(Subject subject) {
        subjectService.updateSubject(subject);
        return Response.ok(subject).build();
    }

    @Path("{id}")
    @GET
    public Response getSubject(@PathParam("id") Long id) {
        Subject foundSubject = subjectService.findSubjectById(id);
        if (foundSubject != null) {
            return Response.ok(foundSubject).build();
        } else {
            throw new SubjectNotFoundException("Subject with ID:" + id + " not found");
            //              return Response.status(Response.Status.NOT_FOUND).entity("Item with ID:" + id+ " not found").type(MediaType.TEXT_PLAIN_TYPE).build();
        }
    }


    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @DELETE

    public Response removeSubject(@PathParam("id") Long id) {
        Subject foundSubject = subjectService.findSubjectById(id);
        if (foundSubject != null) {
            subjectService.deleteSubject(id);
            return Response.ok().entity("subject with id: " + id + " was successfully removed").build();
        } else {
            throw new SubjectNotFoundException("Subject with ID:" + id + " not found");

        }
    }


    @Path("getall")
    @GET
    public List<Subject> getAllSubjects() {
        List<Subject> subjectList = subjectService.getAllSubjects();
        if (subjectList.isEmpty()) {
            throw new SubjectNotFoundException("Currently there is no subject information recorded in the database");
        } else {
            return subjectService.getAllSubjects();
        }
    }

    @Path("getSubjectMatters")
    @GET
    public List<Subject> getAllSubjectMatters() {
        List<Subject> subjectList = subjectService.getAllSubjectMatters();
        if (subjectList.isEmpty()) {
            throw new SubjectNotFoundException("Currently there is no subject information recorded in the database");
        } else {
            return subjectService.getAllSubjectMatters();
        }
    }

    @Path("getAllBySubject/{name}")
    @GET
    public List<Subject> getAllStudentsAndTeachersBySubjectNameNP(@PathParam("name") String name) {

        List<Subject> subjectList = subjectService.getSubjectByNameNamedParameters(name);
        if (subjectList.isEmpty()) {
            throw new SubjectNotFoundException("There is no subject with name " + name);
        } else {
            return subjectService.getSubjectByNameNamedParameters(name);
        }


    }


    @Path("getStudents/{subject}")
    @GET
    public Response getStudentsBySubject(@PathParam("subject") String name) {
        List<Subject> studentList = subjectService.getAllStudentsBySubject(name);
        if (studentList != null) {
            return Response.ok(studentList).build();
        } else {
            throw new StudentNotFoundException("No students found related to subject " + name );
        }
    }

    @Path("getTeachers/{subject}")
    @GET
    public Response getTeachersBySubject(@PathParam("subject") String name) {
        List<Subject> teacherList = subjectService.getAllTeachersBySubject(name);
        if (teacherList.isEmpty()) {
            throw new StudentNotFoundException("No teachers found related to subject " + name );

        } else {
            return Response.ok(teacherList).build();
        }
    }




    public static Boolean RequiredFieldIsEmpty(Subject subject) {

        return subject.getSubjectMatter().isBlank() ;

    }
}


