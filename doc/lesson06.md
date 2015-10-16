# Занятие 6 онлайн проекта <a href="https://github.com/JavaWebinar/topjava04">Topjava</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFfkF5c1hiWmstT0prODdtZkVuNFlMZmdtN3J0OUcyY0lkT2NlVzlUMXRUUlk">Материалы урока</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFUVZobXRzNWFzUW8">HW5: Spring Profiles. Spring Data JPA</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVWpWeFp3U3lPTTg">1_ HW5.patch</a>**

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFejhtNkI0RGpVd1E">HW5: Optional</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFOTFzMjFvNmZPNms">2_ HW5_ Optional_ add_ profiles.patch</a>**
-  <a href="http://javarticles.com/2013/12/spring-profiles.html">Spring Profiles</a>

-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFS040MmJXMFVmb2s">3_ HW5_ Optional_ fetch_ join.patch</a>**
-  <a href="http://stackoverflow.com/questions/11938253/jpa-joincolumn-vs-mappedby">JPA JoinColumn vs mappedBy</a>
-  <a href="https://en.wikibooks.org/wiki/Java_Persistence/OneToMany#Unidirectional_OneToMany.2C_No_Inverse_ManyToOne.2C_No_Join_Table_.28JPA_2.0_ONLY.29">Unidirectional OneToMany</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFeTV0SUFfblk5NE0">Кэш Hibernate</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFR2VYME1EWnBpaE0">4_ hibernate_ cache.patch</a>**
>  JdbcUserServiceTest поломася. Требуется починить в ДЗ

-  <a href="http://habrahabr.ru/post/135176/">Уровни кэширования Hibernate</a>
-  <a href="http://habrahabr.ru/post/136375/">Hibernate Cache. Практика</a>
-  Починка тестов: <a href="http://stackoverflow.com/questions/1603846/hibernate-2nd-level-cache-invalidation-when-another-process-modifies-the-databas">инвалидация кэша Hibernate</a>
-  Ресурсы:
   -  Подключение <a href="http://www.ehcache.org/generated/2.9.0/html/ehc-all/#page/Ehcache_Documentation_Set%2Fco-hib_about_using_ehcache_with_hibernate.html%23wwconnect_header">кэша Hibernate 2-го уровня</a>
   -  <a href="http://stackoverflow.com/questions/3663979/how-to-use-jpa2s-cacheable-instead-of-hibernates-cache">JPA2 @Cacheable vs Hibernate @Cache</a>
   -  <a href="http://habrahabr.ru/post/25140/">Распределённая система кеша ehcache</a>
   -  <a href="http://docs.jboss.org/hibernate/orm/4.3/manual/en-US/html_single/#performance-cache-mapping">Cache mappings</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVE1jWkRucm1UTjA">Spring Web</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFcHVFR0xsakgwQnc">5_ spring_ web.patch</a>**

-  Добавляем в проект веб зависимости
-  Поднятие контекста Spring в веб приложении. <a href="http://www.mkyong.com/servlet/what-is-listener-servletcontextlistener-example/">ServletContextListener</a>. Задание дефолтного профиля.
-  Получение контекста Spring в веб-контейнере
-  Имплементируем UserController. <a href="http://design-pattern.ru/patterns/mvc.html">Паттерн MVC</a>
-  Ресурсы:
   -  <a href="https://docs.oracle.com/javaee/6/tutorial/doc/bnafi.html">Servlet Lifecycle</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFN3k0ZVk1MnF5TjQ">JPS, JSTL, internationalization</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVGw1eTE1YTc4WUk">6_ jsp_ jstl_ i18n.patch</a>**
-  <a href="http://www.java2ee.ru/jsp/include.html">jsp:include</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFLTB3R3pKNFNEQmM">Динамическое изменение профиля при запуске.</a>
>  -Dspring.profiles.active="datajpa,postgres"

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFdkFRRFdYa0NoWkU">Конфигурирование Tomcat через maven plugin. Jndi-lookup.</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVWpSU2RyS3ZzWGM">7_ tomcat_ pool_ jndi.patch</a>**

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFQThUX2VyQXNiTHM">Spring Web MVC</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFNFJNV254c1VRNFU">8 spring webmvc.patch</a>**

-  <a class="anchor" id="mvc"></a><a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html">Spring Web MVC</a>
-  <a href="http://design-pattern.ru/patterns/front-controller.html">Паттерн Front Controller</a>
-  Добавляем DispatcherServlet и MVC application context. <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/images/mvc-contexts.gif">Иерархия контекстов в Spring Web MVC</a>
-  <a href="http://www.tutorialspoint.com/spring/spring_web_mvc_framework.htm">Сценарий обработки запроса</a>. <a href="http://www.studytrails.com/frameworks/spring/spring-mvc.jsp">HandlerMappings</a>
-  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-viewresolver-resolver">View resolving</a>: прячем jsp под WEB-INF.
-  HandlerMapping: <a href="http://www.mkyong.com/spring-mvc/spring-mvc-simpleurlhandlermapping-example/">SimpleUrlHandlerMapping</a>, <a href="http://www.mkyong.com/spring-mvc/spring-mvc-beannameurlhandlermapping-example/">BeanNameUrlHandlerMapping</a>
-  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-config-static-resources">Маппинг ресурсов.</a>
-  Ресурсы:
   -  <a href="http://www.jpalace.org/document/34/spring-mvc-tutorial">Spring MVC Tutorial</a>
   -  <a href="http://devcolibri.com/120">Spring MVC — Hello world</a>
   -  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html">Web MVC framework</a>
   -  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-webappctx-special-beans-tbl">Special bean types in the WebApplicationContext</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFUEctTkRSMWNvRjg">Spring Internationalization</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFOHFPMXdMMXVOam8">9 spring i18n.patch</a>**

-  <a href="http://simplespringtutorial.com/i18n.html">Spring Internationalization or i18n</a>
-  <a href="http://learningviacode.blogspot.ru/2012/07/reloadable-messagesources.html">Reloadable MessageSources</a>
-  <a href="http://nginx.com/resources/admin-guide/serving-static-content/">nginx: Serving Static Content</a>

## Домашнее задание HW06
    Починить InMemory и Jdbc тесты (разделить тесты для jdbc и jpa/datajpa) 
    Добавить локализацию и jsp:include в meal*.jsp
    Починить работу meals (перенести функциональность MealServlet в RootController/UserMealRestController) 

Optional

    Добавить еще одну роль к ADMIN (будет 2 роли: ROLE_USER, ROLE_ADMIN)
    Починить JpaUserServiceTest.testGetAll
    Добавить транзакционность (DataSourceTransactionManager) и доставание ролей в JdbcUserRepositoryImpl
    Добавить проверку ролей в тесты на User 
