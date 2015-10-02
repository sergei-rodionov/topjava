# Занятие 4 онлайн проекта <a href="https://github.com/JavaWebinar/topjava04">Topjava</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFfkxqbVpwZUd5anQ2TXE4bm5HbXhtVmkxMUxFSjhNQ1hXYVVTTTZEMzkzN2s">Материалы урока</a>


## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFdVhaMklZQVNkUGc">HW3: JdbcUserMealRepositoryImpl + UserMealServiceTest</a>
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFbFN3VjFTWTN2bWM">1_ HW3.patch</a>**
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFanZBX3pKM2c3Zms">2_ HW3_ Optional.patch</a>**

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFU0Z2R190eDllYmM">Spring: инициализация и популирование DB</a>
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFQ0VUem1ldFNnU1k">3_ init_ and_ populate_ db.patch</a>**

-  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/jdbc.html#jdbc-initializing-datasource-xml">Инициализация базы при старте приложения</a>
-  Инициализация базы из java: DbPopulator. <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#integration-testing-annotations-spring">Spring Testing Annotations</a>
-  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#resources">Абстракция Resource</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFNTNWV04weDBGSmc">Починка mock: подмена контекста при тестировании</a>
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFWFd5WUV5aFNUSzA">4_ create_ mock_ test_ ctx.patch</a>**

## Переносим DTO объект UserMealWithExceed в пакет to
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFZTZGY01PN21OUVk">5_ move_ UserMealWithExceed.patch</a>**
-  <a href="http://martinfowler.com/eaaCatalog/dataTransferObject.html">Паттерн DTO</a>. <a href="http://stackoverflow.com/questions/1612334/difference-between-dto-vo-pojo-javabeans">Value Object и Data Transfer Object</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVWZYcHoyUF9qX2M">ORM. Hibernate. JPA.</a>
> ВНИМАНИЕ: патч меняет postgres.properties, в котором у вас свои креденшелы к базе.
 
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFZV9UNDFLTmFucEU">6_ make_ entity_ add_ jpa.patch</a>**
   
-  <a href="http://ru.wikipedia.org/wiki/ORM">ORM</a>. 
-  <a href="http://en.wikibooks.org/wiki/Java_Persistence/Mapping">Mapping</a>. Описания модели Hibernate (hbm.xml/annotation)
-  <a href="https://ru.wikipedia.org/wiki/Hibernate_(библиотека)">Hibernate</a>. Другие ORM: <a href="http://en.wikipedia.org/wiki/TopLink">TopLink</a>, <a href="http://en.wikipedia.org/wiki/EclipseLink">ElipseLink</a>, <a href="http://en.wikipedia.org/wiki/Ebean">EBean</a> (<a href="http://www.playframework.com/documentation/2.2.x/JavaEbean">used in Playframework</a>).
-  <a href="http://ru.wikipedia.org/wiki/Java_Persistence_API">JPA (wiki)</a>. <a href="https://en.wikipedia.org/wiki/Java_Persistence_API">JPA (english wiki)</a>. <a href="http://www.jpab.org/All/All/All.html">JPA Performance Benchmark</a>
-  Подключение к проекту Spring ORM и Hibernate
-  <a href="http://en.wikibooks.org/wiki/Java_Persistence/Inheritance">Отображения наследования объектов на таблицы</a>
-  <a href="http://en.wikibooks.org/wiki/Java_Persistence/Identity_and_Sequencing">Стратегии генерации PK</a>
-  Добавление <a href="http://validator.hibernate.org">hibernate-validator</a>. <a href="http://stackoverflow.com/questions/14730329/jpa-2-0-exception-to-use-javax-validation-package-in-jpa-2-0">JSR-303 -> JSR-349</a>
-  <a href="http://devcolibri.com/2046">Описание связей в модели. Ленивая загрузка объекта.</a>
-  Конфигурирование JPA. Сканировние Entities. <a href="http://docs.jboss.org/hibernate/entitymanager/3.6/reference/en/html/architecture.html#d0e61">JPA definitions</a>
-  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/expressions.html">Spring expressions: выражения в конфигурации</a>
-  Создание JPA Facet. Назначение DataSource.
-  Имплементация JpaUserRepository через EntityManagerFactory/ SessionFactory
-  Использование TypedQuery и @NamedQuery. Назначение параметров по индексу и имени.
-  <a href="http://docs.jboss.org/hibernate/orm/4.2/devguide/en-US/html/ch11.html">HQL</a>/ <a href="http://ru.wikipedia.org/wiki/Java_Persistence_Query_Language">JPQL</a>.
-  <a href="http://www.objectdb.com/java/jpa/query/criteria">JPA Criteria API</a>. <a href="http://www.querydsl.com/">Unified Queries for Java</a>
-  <a href="https://weblogs.java.net/blog/montanajava/archive/2014/06/17/using-java-8-datetime-classes-jpa">Java 8 Time API Converter</a>

- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFWWVZbW5ENEpZaUE">7_ jpa_ impl_ transaction.patch</a>**
-  <a href="http://ru.wikipedia.org/wiki/Транзакция_(информатика)">Транзакция. ACID. Уровни изоляции транзакций.</a> 
-  Подключаем транзакции. <a href="http://www.tutorialspoint.com/spring/spring_transaction_management.htm">Spring Transaction Management</a>
-  <a href="https://jira.spring.io/browse/DATAJPA-601">readOnly и Propagation.SUPPORTS</a>
-  <a href="http://habrahabr.ru/post/232381/">@Transactional в тестах. Настройка EntityManagerFactory</a>

-  Ресурсы:
   - <a href="http://www.youtube.com/watch?v=YzOTZTt-PR0">Николай Алименков — Босиком по граблям Hibernate</a>
   - <a href="http://stackoverflow.com/questions/8994864/how-would-i-specify-a-hibernate-pattern-annotation-using-a-regular-expression">Validate by RegExp</a>
   - <a href="http://en.wikibooks.org/wiki/Java_Persistence">Java Persistence</a>
   - <a href="http://hibernate.org/">Hibernate</a>
   - <a href="http://stackoverflow.com/questions/26482495/which-transaction-manager-should-i-use-jta-vs-jpa">JTA vs JPA</a> 
   - <a href="http://docs.spring.io/spring-framework/docs/4.0.x/spring-framework-reference/html/transaction.html">Spring Framework transaction management</a>
   - <a href="http://www.objectdb.com/java/jpa/persistence/managed#Entity_Object_Life_Cycle">Working with JPA Entity Objects</a>
   - <a href="http://www.ibm.com/developerworks/ru/library/j-ts1/">Стратегии работы с транзакциями: Распространенные ошибки</a>
   - <a href="http://habrahabr.ru/post/208400/">Принципы работы СУБД. MVCC</a>
   - <a href="https://ru.wikipedia.org/wiki/MVCC">MVCC</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFSTJEQ1Rvd3Jvc2c">Добавляем поддержку HSQLDB</a>
>  ВНИМАНИЕ: патч меняет postgres.properties

- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFd0FFMG5vcEsyejA">8_ hsqldb_ support.patch</a>**


## Домашнее задание HW4
-  <a href="https://weblogs.java.net/blog/montanajava/archive/2014/06/17/using-java-8-datetime-classes-jpa">Using the Java 8 DateTime Classes with JPA</a>
-  <a href="http://stackoverflow.com/questions/31965179/whats-new-in-hibernate-5">What's new in Hibernate 5?</a>
-  <a href="https://github.com/junit-team/junit/wiki/Rules">JUnit @Rules</a>

Required

    Сделать UserMeal Hibernate entity 
    Добавить поддержку LocalDateTime
    Имплементировать и протестировать JpaUserMealRepositoryImpl 

Optional

    Сделать тесты UserMealServiceTest через @Rule: 
     
Question / hints:

-  Тк. JPQL работает с объектами мы не можем использовать userId. Можно сделать пример так:

        User ref = em.getReference(User.class, userId);
        meal.setUser(ref);

    При этом от User нам нужет только id, те реального запроса в базу за юзером не будет- проверьте по логам.
    
-  Есть несколько аналогичных "встроенных" баз данных. H2, HSQLDB, Derby, SQLite. Почему был выбран HSQLDB?
>  Просто с ней приходилось работать. H2 еще наиболее популярна
    
-  Чистого JPA не существует, т.е. это всего лишь интерфейс, спецификация?
   Говорим JPA, подразумеваем какой-то ORM фрэймворк? А что тогда используют чистый jdbc, Spring-jdbc, MyBatis? MyBatis не реализует JPA?
> JPA- это спецификация, ее реализации- Hibernate, OpenJPA, EclipceLink. Spring-Jdbc, MyBatis, db-utils не реализуют JPA, это обертки к jdbc
    
    
