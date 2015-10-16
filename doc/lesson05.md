# Занятие 5 онлайн проекта <a href="https://github.com/JavaWebinar/topjava04">Topjava</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFfmctT3oyNW1qaVhDb2p0bGpyTFVlaUJ2VVpOdVgtWF9KTUFBMWFaR2xVYVE">Материалы урока</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVFVVUGctMUxxSkE">Разбор вопросов</a>
- <a href="http://stackoverflow.com/questions/8994864/how-would-i-specify-a-hibernate-pattern-annotation-using-a-regular-expression">Validate by RegExp</a>
- <a href="http://www.objectdb.com/java/jpa/persistence/managed#Entity_Object_Life_Cycle">Working with JPA Entity Objects</a>
- <a href="https://en.wikibooks.org/wiki/Java_Persistence/Relationships">Java Persistence/Relationships</a>
- <a href="http://articles.javatalks.ru/articles/17">Использование ThreadLocal переменных</a>
- <a href="http://stackoverflow.com/questions/1069992/jpa-entitymanager-why-use-persist-over-merge">Merge vs Persist</a>
- <a href="http://www.youtube.com/watch?v=1KphwODu1gg">Видео: работа в ZK с OpenJPA (в чем Hibernate хуже)</a>
- <a href="https://developer.jboss.org/wiki/OpenSessionInView">Паттерн- открытие транзакции в фильтре</a> и <a href="http://stackoverflow.com/questions/1103363/why-is-hibernate-open-session-in-view-considered-a-bad-practice">почему это bad-practice</a>
- <a href="https://en.wikibooks.org/wiki/Java_Persistence/Identity_and_Sequencing#Sequence_Strategies">Sequence Strategies</a>
- <a href="http://stackoverflow.com/questions/9470442/why-is-the-hibernate-default-generator-for-postgresql-sequencegenerator-not?lq=1">SequenceGenerator/IdentityGenerator in PostgreSql</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFNFMyMGJCZWE4elk">HW4: JPA. @Rule</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFb1ZlU0hxS0Z5blk">1_ HW4.patch</a>**
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFMW9GekxScVhpRFE">2_ HW4_ Optional.patch</a>**

Изменения в проекте:

-  <a href="https://hibernate.atlassian.net/browse/HHH-8844">Add support for Java 8 date and time types (JSR-310)</a>
-  <a href="http://stackoverflow.com/questions/14892125/what-is-the-best-practice-to-determine-the-execution-time-of-the-bussiness-relev#27868954">Stopwatch</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFZENCVEhDMkZiV00">Транзакции</a>
-  <a href="https://jira.spring.io/browse/DATAJPA-601">readOnly и Propagation.SUPPORTS</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFNW0yVWhXcGNPU2M">Профили Maven и Spring</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVi1oWVRHRnpKTE0">3_ profiles_ connection_ pool.patch</a>**

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFTWJOdHduOWtNcTA">Пул коннектов</a>

-  Выбор реализации пула коннектов: <a href="http://jolbox.com/">BoneCP</a>, <a href="http://commons-dbcp.apache.org">Commons Database Connection Pooling</a>, <a href="https://github.com/brettwooldridge/HikariCP">HikariCP</a>
-  <a href="http://blog.trustiv.co.uk/2014/06/battle-connection-pools">Battle of the Connection Pools</a>
-  <a href="http://blog.ippon.fr/2013/03/13/improving-the-performance-of-the-spring-petclinic-sample-application-part-3-of-5">Tomcat pool</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFYVdyMFYxRUR6bWM">Spring Data JPA</a>
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFYjlfYUZydW93ZnM">4_ spring_ data_ jpa.patch</a>**

-  <a class="anchor" id="datajpa"></a><a href="http://projects.spring.io/spring-data-jpa/">Spring Data JPA</a>
-  Замена AbstractDAO: <a href="http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.repositories">JPA Repositories</a>
-  Разрешение зависимостей: <a href="http://howtodoinjava.com/2014/02/18/maven-bom-bill-of-materials-dependency/">Maven BOM [Bill Of Materials] Dependency</a>
-  <a href="http://habrahabr.ru/post/232381/">Делегирование. (Spring Data JPA)</a>
-  <a href="http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation">Query methods</a>
-  <a href="http://www.youtube.com/watch?v=c32Ly9mGVTA">Spring Data – новый взгляд на persistence (видео с JeeConf)</a>
    
-  Ресурсы:
   -  <a href="https://github.com/spring-projects?query=spring-data">Github repositories</a></li>
   -  <a href="http://www.petrikainulainen.net/spring-data-jpa-tutorial">Spring Data JPA Tutorial</a></li>
   -  <a href="https://blog.42.nl/articles/spring-data-jpa-with-querydsl-repositories-made-easy/">Spring Data JPA with QueryDSL</a></li>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFajd2Y2RLQVVJWUU">Spring кэш</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFcF9KdXVtTHBCNUk">5_ spring_ cache</a>**

-  <a href="http://habrahabr.ru/post/113945/">Кеширование в Spring Framework</a>
-  <a href="http://www.ehcache.org/">EHCACHE</a>

-  Ресурсы:
   -  <a href="http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/html/cache.html">Spring cache Abstraction</a>
   -  <a href="http://habrahabr.ru/post/25140/">Распределённая система кеша ehcache</a>
   -  Починка JUnit: <a href="http://stackoverflow.com/questions/10013288/another-unnamed-cachemanager-already-exists-in-the-same-vm-ehcache-2-5">один кэш на JVM</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFZFdWWFdwams0eGM">Домашнее задание HW05</a>
     Имплементировать и протестировать DataJpaUserMealRepositoryImpl 
     Разделить реализации Repository по профилям Spring: jdbc, jpa, datajpa 
            (общее в профилях можно объединять, например <beans profile="datajpa,jpa">)
     Сделать тесты всех реализаций (jdbc, jpa, datajpa) через наследование (без дублирования),
             общее из UserMealServiceTest.java и UserServiceTest.java - также вынеси в базовый класс.
     Запустить все тесты: mvn test
                          или в IDEA Maven Lifecycle- test (кнопку skipTest отжать)

Optional     
     
     Починить MealServlet (добавить профили)

     Сделать и протетсировать в сервисах методы 
                           (можно сделать разные варианты, достаточно только в реализации Jpa или DataJpa): 
     -  достать пользователя вместе с его едой
     -  достать еду вместе с пользователем
