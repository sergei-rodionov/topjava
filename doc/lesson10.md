# Занятие 10 онлайн проекта <a href="https://github.com/JavaWebinar/topjava04">Topjava</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFfk43cG91Yk9pM3JxUHVhNFVVdHlxSlJtZm5oY3A4YXRtNk1KWEZxRlFNeW8">Материалы урока</a>

##  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFNGc0OE5hNVdnM00">HW9</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFTHc5Si1PZnA3T1k">1_ HW9_ ajax.patch</a>**
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFSFpxbDV6eGJpdXM">2_ HW9_ test.patch</a>**
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVHY5STc1NkFvZjA">3_ HW9_ datetimepicker.patch</a>**
- <a href="http://xdsoft.net/jqplugins/datetimepicker/">DateTimePicker jQuery plugin</a>
- <a href="https://github.com/xdan/datetimepicker/issues/216">Datetimepicker and ISO-8601</a>

##  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFTVZyQnBlYUtkNms">Spring Security Taglib. Method Security Expressions.</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFTHVYcjdOcTNNRlU">04_ secure_ tag_ annotation.patch</a>**
-  <a href="http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#declaring-the-taglib">Spring Security Taglib.</a>
-  <a href="http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#jc-method">Method Security</a> и <a href="http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#method-security-expressions">Method Security Expressions</a>. Зависимость от контекста mvc/parent.

##  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFc1JMTE4xVG0zN0U">Interceptors. Редактирование профиля. JSP tag files.</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFSXlFY2t6aU8tUGc">05_ interceptor.patch</a>**
-  Добавляем профиль. <a href="http://www.mkyong.com/spring-mvc/spring-mvc-handler-interceptors-example/">Spring interceptors</a>.
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFeVZCNGk2MG10UTA">06_ profile_ jsptag.patch</a>**

>  ProfileRestController.update(user) изменился на userTo (нельзя, например, изменять себе роли).

>  Заметьте, что в ProfileRestControllerTest.testUpdate getByEmail вызываем с mail.toLowerCase().

-  <a href="http://www.techrepublic.com/article/an-introduction-to-jsp-20s-tag-files/">Делаем jsp tag для ввода поля формы</a>.
-  <a href="http://www.codejava.net/frameworks/spring/spring-mvc-form-validation-example-with-bean-validation-api">Spring MVC Form Validation</a>

##  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFNWpUNktMeGJURmM">Форма регистрации.</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFNWhqMUJ4ZEVHZUU">07_ registration.patch</a>**
##  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFODlhSTZnLXZzaHc">Обработка исключений в Spring.</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFOXNyczJQbVQ2Vjg">08_ not_ found_ 404.patch</a>**
-  <a href="http://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc#using-http-status-codes">Используем HTTP status code</a>
-  <a href="http://stackoverflow.com/questions/2195639/restful-resource-not-found-404-or-204-jersey-returns-204-on-null-being-returne">RESTful resource not found</a>
-  <a href="http://stackoverflow.com/questions/9930695/rest-api-404-bad-uri-or-missing-resource">REST API 404</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFbW9DeHNkZzRQZGM">9_ global_ exception.patch</a>**
-  <a href="http://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc#global-exception-handling">Global Exception Handling</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFMm5vTk9SVGc0YWM">10_ controller_ based_ exception.patch</a>**

>  Т.к Rest и Ajax контроллеры уже отнаследованы от абстрактных контроллеров, сделал "подмешивание" в них ExceptionInfoHandler с помощью default методов интерфейса.

-  <a href="https://ru.wikipedia.org/wiki/Примесь_(программирование)">Примесь (mixin)</a>
-  <a href="https://kerflyn.wordpress.com/2012/07/09/java-8-now-you-have-mixins/">Mixin в Java 8</a>
-  <a href="http://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc#errors-and-rest">Сериализация Exception в JSON</a>
-  <a href="http://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc#controller-based-exception-handling">Exception Handling на уровне контроллера</a>


##  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFUHNiYzNMbkF6ajQ">Encoding password</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFWE5kVFRzR0lxOUk">11_ password_ encoding.patch</a>**
- <a href="http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#core-services-password-encoding">Password Encoding</a>

##  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFNDlPZGdUNThzNUU">Межсайтовая подделка запроса (CSRF).</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVEV1LWRTRVNTRlk">12_ csrf.patch</a>**
-  <a class="anchor" id="csrf"></a><a href="https://ru.wikipedia.org/wiki/Межсайтовая_подделка_запроса">Межсайтовая подделка запроса (CSRF)</a>
-  <a href="http://docs.spring.io/spring-security/site/docs/current/reference/html/csrf.html#csrf-using/">Using Spring Security CSRF Protection</a>
-  <a href="http://docs.spring.io/spring-security/site/docs/current/reference/html/csrf.html#csrf-include-csrf-token-ajax">Ajax and JSON Requests</a>
-  <a href="http://blog.jdriven.com/2014/10/stateless-spring-security-part-1-stateless-csrf-protection/">Stateless CSRF protection</a>
-  Ресурсы:
    -  <a href="http://habrahabr.ru/post/264641/">Spring Security 4 + CSRF</a>
    -  <a href="http://stackoverflow.com/questions/11008469/are-json-web-services-vulnerable-to-csrf-attacks">Are JSON web services vulnerable to CSRF attacks</a>
    -  <a href="https://ru.wikipedia.org/wiki/Правило_ограничения_домена">Правило ограничения домена (SOP)</a>
    -  <a href="https://ru.wikipedia.org/wiki/Cross-origin_resource_sharing">Cross-origin resource sharing (CORS)</a>

## Домашнее задание HW10
    Сделать валидацию в AdminAjaxController/UserMealAjaxController через ValidationException 
    (вернуть клиенту ErrorInfo и статус HttpStatus.UNPROCESSABLE_ENTITY)

    Сделать обработку ошибки: регистрация пользователя с уже имеющимся email
    (User with this email already present in application.)

Optional.

    Сделать в приложении выбор локали
