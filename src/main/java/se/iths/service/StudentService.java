package se.iths.service;


import se.iths.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StudentService {


    @PersistenceContext
    EntityManager entityManager;


    //    ADD
    public Student addStudent(Student student) {
        entityManager.persist(student);
        return student;
    }


    // UPDATE
    public Student updateStudent(Student student) {
        entityManager.merge(student);
        return student;
    }

    //DELETE
    public void deleteStudent(Long id) {
        Student deleteThisStudent = entityManager.find(Student.class, id);
        entityManager.remove(deleteThisStudent);


    }
    // FIND BY ID
    public Student findStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    // GET ALL
    public List<Student> getAllStudents() {
        return entityManager.
                createQuery("SELECT s from Student s", Student.class).
                getResultList();
    }
    //GET BY LAST NAME
    public List<Student> getByLastNameNamedParameters(String name) {
        String query = "SELECT s FROM Student s " +
                "WHERE LOWER (s.lastname) = LOWER(:name )" +
                "ORDER BY s.firstName ";
        return entityManager.
                createQuery(query, Student.class).
                setParameter("name".toLowerCase(), name).
                getResultList();


    }


}
