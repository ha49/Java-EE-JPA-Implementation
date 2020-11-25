package se.iths.util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class DataGenerator {
    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {


        Student student1 = new Student("Elon", "Tesla", "Elon.Tesla@tesla.com", "000-000001");
        Student student2 = new Student("Hillary", "Mail", "Hillary.Mail@gmail.com", "000-000002");
        Student student3 = new Student("Leonardo", "Oscar", "Leonardo.Oscar@revenant.com", "000-000003");
        Student student4 = new Student("Trump", "Golf", "Trump.Golf@pennsylvania.com", "000-000004");
        Student student5 = new Student("Maradona", "Drug", "Maradona.Drug@fifa.com", "000-000005");
        Student student6 = new Student("Joe", "Winner", "Joe.Winner@vithus.com", "000-000006");
        Student student7 = new Student("Angelina", "Pitt", "Angeli.Pitt@mrmrssimith.com", "000-000007");
        Student student8 = new Student("John", "Envoy", "John.Envoy@enviroment.com", "000-000008");


        Subject subject1 = new Subject("Football");
        Subject subject2 = new Subject("Space");
        Subject subject3 = new Subject("Diplomacy");
        Subject subject4 = new Subject("Governance");
        Subject subject5 = new Subject("Cinema");

        Teacher teacher1 = new Teacher("Tom", "Hanks", "Tom.Hanks@academy.com", "100-000000");
        Teacher teacher2 = new Teacher("Madeleine", "Albright", "Madeleine.Albright@state.gov", "200-000000");
        Teacher teacher3 = new Teacher("Barack", "Obama", "Barack.Obama@potus.gov", "300-000000");
        Teacher teacher4 = new Teacher("Pele", "Pele", "Pele@fifa.com", "400-000000");


        student1.addSubject(subject2);
        student2.addSubject(subject3);
        student3.addSubject(subject5);
        student4.addSubject(subject4);
        student5.addSubject(subject1);
        student6.addSubject(subject4);
        student7.addSubject(subject5);
        student7.addSubject(subject3);
        student8.addSubject(subject3);


        teacher1.addSubject(subject5);
        teacher2.addSubject(subject3);
        teacher2.addSubject(subject4);
        teacher3.addSubject(subject4);
        teacher4.addSubject(subject1);

        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityManager.persist(student4);
        entityManager.persist(student5);
        entityManager.persist(student6);
        entityManager.persist(student7);
        entityManager.persist(student8);

        entityManager.persist(teacher1);
        entityManager.persist(teacher2);
        entityManager.persist(teacher3);
        entityManager.persist(teacher4);
    }
}