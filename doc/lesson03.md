# Занятие 3 онлайн проекта <a href="https://github.com/JavaWebinar/topjava04">Topjava</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFfllmQWR2cE90UGp5RERHaE95cnVDNmZTRFJCejVhM191NDZlREwzeDdXdmc">Материалы урока</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFWTdkTEhBNGQxRDA">HW2: делаем API еды</a>
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVk9LeGRRZVZMbms">1_ HW2.patch</a>**

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFZ1pzU0JBeldFdVU">HW2: Optional</a>
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFUmdMWEk0M2x2d0k">2_ HW2_ Optional.patch</a>**

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFOU8wWlpPVE05STA">Коротко о жизненном цикле Spring контекста.</a>
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFWDZwZ3NOYXgyc1E">3_ bean_ life_ cycle.patch</a>**
-  <a href="http://habrahabr.ru/post/222579/">Spring изнутри. Этапы инициализации контекста.</a>
-  Ресурсы:
   -  <a href="http://vk.com/javawebinar?z=video-58538268_169373158%2Fvideos-58538268">Евгений Борисов. Spring, часть 1</a>
   -  <a href="http://vk.com/javawebinar?z=video-58538268_169373162%2Fvideos-58538268">Евгений Борисов. Spring, часть 2</a>
   -  <a href="http://www.slideshare.net/taemonz/spring-framework-core-23721778">Презентация Spring framework core</a>

##  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFODlkU1B0QnNnSGs">Тестирование через JUnit.</a>
- ВНИМЕНИЕ: перед накаткой патча создайте каталог test (из корня проекта путь \src\test), иначе часть файлов попадет в src\main. **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFcnpGNHEydXo5NGc">4_ Add Junit.patch</a>** 

-  Перенос mock реализации в test.
-  <a href="http://junit.org/">JUnit 4</a>
-  <a href="http://habrahabr.ru/post/120101/">Тестирование в Java. JUnit</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFai1veG9qaFZlZ2s">Spring Test</a>
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFWl90eWticFZzZ1E">5_ Add_ spring_ test.patch</a>**
-  Интеграция Spring и JUnit.
-  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#testing">Spring Testing</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVlNYczhnSU9JdXc">Базы данных. Обзор NoSQL и Java persistence solution без ORM.</a>
-  <a href="https://ru.wikipedia.org/wiki/PostgreSQL">PostgreSQL</a>.
-  <a href="http://alexander.holbreich.org/2013/03/nosql-or-rdbms/">NoSQL or RDBMS.</a><a
                href="http://habrahabr.ru/post/77909/">Обзор NoSQL систем</a>. <a href="http://blog.nahurst.com/visual-guide-to-nosql-systems">CAP</a>
-  Обзор Java persistence solution без ORM: <a
                href="http://commons.apache.org/proper/commons-dbutils/">commons-dbutils</a>,
            <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/jdbc.html">Spring
                JdbcTemplate</a>, <a href="http://en.wikipedia.org/wiki/MyBatis">MyBatis</a>, <a href="http://www.jdbi.org/">JDBI</a>
- Ресурсы:
  - <a href="https://ru.wikipedia.org/wiki/Реляционная_СУБД">Реляционная СУБД</a>
  - <a href="http://habrahabr.ru/post/103021/">Реляционные базы</a>
  - <a href="http://ru.wikipedia.org/wiki/Java_Database_Connectivity">JDBC</a>
  - <a href="https://www.youtube.com/playlist?list=PLIU76b8Cjem5qdMQLXiIwGLTLyUHkTqi2">Обущающее видео по JDBC</a>
                
## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFQWtHYU1qTDlMWVE">Настройка Database в IDEA.</a>
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFZXhDZUphcGQ4NjA">6_ Add_ postgresql.patch</a>**
-  <a href="http://habrahabr.ru/company/JetBrains/blog/204064/">Настройка Database в IDEA</a> и запуск SQL.

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFMGNWUXhaVzdlU0k">Скрипты инициализации базы. Spring Jdbc Template.</a>
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFbjZ3eXBRWlNTQjg">7_ populate_ and_ init_ db.patch</a>**
-  Скрипты инициализация базы

- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFUElTdEs5a2M4ZDg">8_ impl_ JdbcUserRepository.patch</a>**
-  Подключение <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/jdbc.html">Spring Jdbc</a>.

-  Конфигурирование DataSource. <a href="http://www.mkyong.com/spring/spring-propertyplaceholderconfigurer-example/">property-placeholder</a>
   (проверьте, что в контекст Spring проекта включены оба файла конфигурации: https://drive.google.com/open?id=0B9Ye2auQ_NsFYThYOFNHbnNzd0E).
-  Имплементация UserRepository через Spring Jdbc Template.

## <a href="https://drive.google.com/open?id=0B4dIHS3wRAhhQUJMMFU0VnRrUUE">Подготовка тестовых данных и тестирование UserService.</a>
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFNTRqMlNUQ0hrWW8">9_ test_ UserService.patch</a>**
-  Подготовка тестовых данных в UserServiceTest. Добавление TestUser и ModelMatcher
-  Тестирование UserService.
-  Ресурсы:
   - <a href="http://www.youtube.com/watch?v=YzOTZTt-PR0">Николай Алименков — Босиком по граблям Hibernate</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVmZaSm9UMktXUnc">Логирование тестов.</a>
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFazhJU0gtMGY4WGs">10_ test_ logging.patch</a>**

- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFWFlYd0FkWTJtR3c">11_ prepare_ HW3.patch</a>**
## Домашнее задание HW03

Required 

    - Понять, почему перестали работать SpringMain/ AdminInMemoryTest/ SpringAdminInMemoryTest
    - Дополнить скрипты создания и инициализации базы таблицой MEALS. Запустить скрипты на вашу базу (через Run)
    - Реализовать через Spring JDBC Template JdbcUserMealRepositoryImpl 
      - сделать каждый метод за один SQL запрос
      - userId в класс UserMeal вставлять НЕ надо 
                                   (для UI и REST это лишние данные, userId это id залогиненного пользователя) 
      - JbdcTemplate работает через сеттеры. Нужно их добавить в UserMeal
      - Cписок еды должен быть отсортирован (тогда мы его сможем сравнивать с тестовыми данными). 
        Кроме того это требуется для UI и API: последняя еда наверху.
      - postgres драйвер не понимает LocalDateTime, использовать преобразования: 
                                    Timestamp.valueOf(ldt) / timestamp.toLocalDateTime()
      - где преобразовывать Timestamp <-> LocalDateTime? 
        Можно в геттерах/сеттерах UserMeal, но лучше сделать свой RowMapper
    - Проверить работу MealServelt, запустив приложение

Optional 

    - Сделать тестовые данные MealTestData, АНОЛОГИЧНЫЕ пропопулированным в populateDB.sql. 
      Тестовый класс-обертка к UserMeal не требуется, сравниваем данные через готовый MATCHER (toString),
      пока будем сравнивать без userId.
    - Сделать UserMealServiceTest из UserMealService (Ctrl+Shift+T и выбрать JUnit4) и реализовать тесты.
    - Запустить скрипт инициализации initDB.sql на базу и протестировать сервис UserMealService. 
    - Сделаеть тесты на чужих юзеров (delete, get, update) с тем чтобы получить NotFoundException
    - Предложить решение, как почнинить SpringMain/ AdminInMemoryTest/ SpringAdminInMemoryTest для реализации 
      in-memory тестов.
