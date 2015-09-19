# Занятие 2 онлайн проекта <a href="https://github.com/JavaWebinar/topjava04">Topjava</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFfkpsWE1uX19zV19IVHd0bTlDclc5QmhMMm4xa0Npek9DT18tdkwyLTBZdXM">Материалы урока</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFXzByNVF3VV9zM1k">HW1: отображения списка еды в JSP</a> 
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFNDByclJpbUJvVVE">1_ HW1.patch</a>**
- <a href="http://java-course.ru/student/book1/jsp/">JSP</a>
- <a href="http://devcolibri.com/1250">JSTL для написания JSP страниц</a>
- <a href="http://javatutor.net/articles/jstl-patterns-for-developing-web-application-1">JSTL: Шаблоны для разработки веб-приложений в java</a>
- <a href="http://design-pattern.ru/patterns/mvc.html">MVC - Model View Controller</a>
- <a href="http://codehelper.ru/questions/205/new/repository-и-dao-отличия-преимущества-недостатки">Паттерны Repository и DAO</a>
- <a href="http://habrahabr.ru/post/263033/">Забудьте о DAO, используйте Repository</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFQndBeWFOa3phRTg">HW1 (Optional): реализация CRUD</a> 
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFblp6SkNzMVhiVUk">2_ HW1_ Optional.patch</a>**
- <a href="http://java-course.ru/student/book1/servlet/">Интернет-приложения на JAVA</a>
- <a href="http://stackoverflow.com/questions/246859/http-1-0-vs-1-1">HTTP 1.0 vs 1.1</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVDJZVTktQzRYTWc">Библиотека vs Фреймворк. Стандартные библиотеки Apache Commons, Guava</a>
-  <a href="http://commons.apache.org/">Apache Commons</a>, <a href="https://code.google.com/p/guava-libraries/wiki/GuavaExplained">Guava</a>

## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFSFR1cDBIamIzQjA">Слои приложения. Создание каркаса приложения.</a>
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFUjZaMEVaRjNMNkU">3_ App_ layers.patch</a>**
-  <a href="https://www.genuitec.com/products/myeclipse/learning-center/spring/myeclipse-for-spring-reference-blueprints/">Архитектурные
            слои приложения в Spring</a>
-  <a href="https://ru.wikipedia.org/wiki/Инверсия_управления">Инверсия управления.</a><a href="http://image.slidesharecdn.com/springintroduction-130729220359-phpapp01/95/spring-introduction-3-638.jpg?cb=1375162442">DI/
            Service Locator</a>
-  <a href="http://habrahabr.ru/post/131993/">IoC, DI, IoC-контейнер — Просто о простом</a>   
-  <a href="http://en.wikipedia.org/wiki/Multilayered_architecture">Паттерн "Слои приложения"</a>
- Ресурсы:
  -  <a href="http://martinfowler.com/eaaCatalog/dataTransferObject.html">Паттерн DTO</a>. <a href="http://stackoverflow.com/questions/1612334/difference-between-dto-vo-pojo-javabeans">Value Object и Data Transfer Object</a>

##  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFWXA1b0pnMGlvU0U">Обзор  Spring Framework. Spring Context.</a>
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFbXhsWDlBYm10SEk">4_ Add_ spring_ context_ and_ main.patch</a>**
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFRDVOQ3dsQ202eFk">5_ Add_ dependency_ injection.patch</a>**
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFeThhWFozOU1DYmM">6_ Add_ annotation_ processing.patch</a>**

-  <a href="http://en.wikipedia.org/wiki/Spring_Framework">Spring Framework</a>
-  <a href="http://spring.io/projects">Проекты Spring</a>.
-  <a href=http://docs.spring.io/spring/docs/current/spring-framework-reference/html/overview.html>Обзор Spring Framework</a>
-  Ресурсы:
   -  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/beans.html">Introduction to the Spring IoC container
       and beans</a>
   -  <a href="http://springindepth.com/book/in-depth-ioc-constructor-setter-injection.html">Constructor & Setter Injection</a>
   -  <a href="http://stackoverflow.com/questions/6827752/whats-the-difference-between-component-repository-service-annotations-in">Difference
       between @Component, @Repository & @Service annotations in Spring</a>
   -  <a href="http://www.mkyong.com/spring/spring-auto-scanning-components/">Spring Auto Scanning Components</a>
   -  <a href="https://spring.io/guides">Getting Started</a>
   -  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/">Spring Framework Reference Documentation</a>
   -  <a href="https://github.com/spring-projects">Spring на GitHub</a>
  
## Домашнее задание HW02
    Сделать API и реализацию слоев приложения для функциональности "еда"
    - Каждая еда принадлежит пользователю
    - Пользователь может управлять ТОЛЬКО СВОЕЙ едой: id авторизованного пользователя LoggedUser.id()
    - Нельзя позволять модифицировать/смотреть чужую еду (бросать NotFoundException)
    - API должна удовлетворять все потребности демо приложения и ничего кроме этого.
      API останется, далее мы будет подменять только реализацию репозиториев.
       
    Включить в контекст Spring и вызвать в SpringMain методы UserMealRestController
    
Optional 

     Дополнить InMemoryUserMealRepository новой функциональностью (фильтрация и пользователи).    
     Внедрить UserMealRestController в MealServlet и работать через него.
     Добавить в UI фильтрацию еды и выбор текущего пользователя (например через html select).
     Доставать список пользователей через AdminRestController, добавив тестовые данные 
     в MockUserRepositoryImpl.getAll()
     

Примечания:

    - В UserMealRestController в save/update данные UserMeal приходят без User/userId.
    - В UserMealServiceImpl постараться сделать в каждом методе только одни запрос к UserMealRepository 
    - LoggedUser известен только на слое web (UserMealService можно тестировать без подмены логики авторизации)
    - Не надо в названиях методов повторять названия класса, например Meal.
    - Проект эволюционирует и немного отличается от видео. Можно проследить ход его развития.
