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
    public List<Subject> getAllSubjectMatters() {
        return entityManager.
                createQuery("SELECT s.subjectMatter from Subject s", Subject.class).
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
            .createQuery("SELECT DISTINCT sub.students FROM Subject sub   WHERE LOWER (sub" +
                    ".subjectMatter )" +
                        "=LOWER(:name)",Subject.class).
                setParameter("name",name)
                .getResultList();
    }




    public  List<Subject> getAllTeachersBySubject(String name) {


        return entityManager
                .createQuery("SELECT DISTINCT sub.teacher FROM Subject sub   WHERE LOWER (sub" +
                        ".subjectMatter )" +
                        "=LOWER(:name)",Subject.class).
                        setParameter("name",name)
                .getResultList();
    }

}
