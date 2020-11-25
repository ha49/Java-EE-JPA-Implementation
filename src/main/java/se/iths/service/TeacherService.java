package se.iths.service;

import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TeacherService {




    @PersistenceContext
    EntityManager entityManager;


    //    ADD
    public Teacher addTeacher(Teacher teacher) {
        entityManager.persist(teacher);
        return teacher;
    }


    // UPDATE
    public Teacher updateTeacher(Teacher teacher) {
        entityManager.merge(teacher);
        return teacher;
    }

    //DELETE
    public void deleteTeacher(Long id) {
        Teacher deleteThisTeacher = entityManager.find(Teacher.class, id);
        entityManager.remove(deleteThisTeacher);


    }
    // FIND BY ID
    public Teacher findTeacherById(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    // GET ALL
    public List<Teacher> getAllTeachers() {
        return entityManager.
                createQuery("SELECT t from Teacher t", Teacher.class).
                getResultList();
    }
    //GET BY LAST NAME
    public List<Teacher> getTeacherByLastNameNamedParameters(String name) {
        String query = "SELECT t FROM Teacher t " +
                "WHERE LOWER (t.lastName) = LOWER(:name )" +
                "ORDER BY t.firstName ";
        return entityManager.
                createQuery(query, Teacher.class).
                setParameter("name".toLowerCase(), name).
                getResultList();


    }

}

