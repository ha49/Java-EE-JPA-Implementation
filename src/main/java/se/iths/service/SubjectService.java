package se.iths.service;

import se.iths.entity.Subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;


    public Subject addSubject(Subject subject) {
        entityManager.persist(subject);
        return subject;
    }

    public Subject updateSubject(Subject subject) {
        entityManager.merge(subject);
        return subject;
    }

    public void deleteSubject(Long id) {
        Subject deleteThisSubject = entityManager.find(Subject.class, id);
        entityManager.remove(deleteThisSubject);


    }

    public Subject findSubjectById(Long id) {
        return entityManager.find(Subject.class, id);
    }

    public List<Subject> getAllSubjects() {
        return entityManager.
                createQuery("SELECT s from Subject s", Subject.class).
                getResultList();
    }

    public List<Subject> getSubjectByNameNamedParameters(String name) {
        String query = "SELECT s FROM Subject s " +
                "WHERE LOWER (s.subjectMatter) = LOWER(:name )ORDER BY s.subjectMatter ";
        return entityManager.
                createQuery(query, Subject.class).
                setParameter("name".toLowerCase(), name).
                getResultList();


    }

    public  List<Subject> getAllStudentsBySubject(String name) {

        return entityManager
                .createQuery("SELECT s FROM Subject s WHERE s.subjectMatter =\'" + name + "\'", Subject.class)
                .getResultList();
    }



    public  List<Subject> getAllTeachersBySubject(String name) {

        return entityManager
                .createQuery("SELECT s FROM Subject s WHERE s.subjectMatter =\'" + name + "\'", Subject.class)
                .getResultList();
    }

/*
    public List<Subject> getSubjectsOfSpecificStudent(String studentName) {

        String query = "SELECT st.firstName FROM Student sb " +
                "INNER JOIN FETCH i.buyer b INNER JOIN FETCH"+
                "WHERE LOWER (s.subjectMatter) = LOWER(:name )ORDER BY s.subjectMatter ";
        return entityManager.
                createQuery(query, Subject.class).
                setParameter("studentName".toLowerCase(), studentName).
                getResultList();






    }*/
}
