package ru.javawebinar.topjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.service.UserService;
import ru.javawebinar.topjava.to.UserTo;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * User: gkislin
 * Date: 23.09.2014
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {
    private static final LoggerWrapper LOG = LoggerWrapper.get(GlobalControllerExceptionHandler.class);
    public static final String LOCALE_REQUEST_ATTRIBUTE_NAME = CookieLocaleResolver.class.getName() + ".LOCALE";

    @Autowired
    private ReloadableResourceBundleMessageSource messageSource;
    @Autowired
    private UserService userService;

    @ExceptionHandler(DataIntegrityViolationException.class)
    @Order(Ordered.HIGHEST_PRECEDENCE)
    ModelAndView sqlErrorHandler(HttpServletRequest req, DataIntegrityViolationException e) throws Exception {
        if (req.getServletPath().equals("/register") || req.getServletPath().equals("/profile")) {
            LOG.error("SQL exception at request " + req.getRequestURL());
            ModelAndView mav = new ModelAndView("profile");
            UserTo userTo = new UserTo();
            userTo.setName(req.getParameter("name"));
            userTo.setEmail(req.getParameter("email"));
            userTo.setCaloriesPerDay(Integer.parseInt(req.getParameter("caloriesPerDay")));

            mav.addObject("register", true);
            mav.addObject("userTo", new UserTo());
            BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(userTo, "userTo");
            bindingResult.addError(new FieldError("userTo", "email", req.getParameter("email"),false,null,null,
                    messageSource.getMessage("register.dublicate.email", null,
                            (Locale) req.getAttribute(LOCALE_REQUEST_ATTRIBUTE_NAME) )));
            mav.addObject("org.springframework.validation.BindingResult.userTo", bindingResult);

            LoggedUser loggedUser = LoggedUser.safeGet();
            // correct email after binding
            // Interceptor is not invoked, put userTo
            if (loggedUser != null) {
                // User spring
                loggedUser.getUserTo().setEmail(
                        userService.getByEmail(
                                ((org.springframework.security.core.userdetails.User) loggedUser).getUsername())
                                .getEmail());
            }
            return mav;
        }
        return defaultErrorHandler(req, e);
    }

    @ExceptionHandler(Exception.class)
    @Order(Ordered.LOWEST_PRECEDENCE)
    ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        LOG.error("Exception at request " + req.getRequestURL());
        ModelAndView mav = new ModelAndView("exception/exception");
        mav.addObject("exception", e);
        LoggedUser loggedUser = LoggedUser.safeGet();

        // Interceptor is not invoked, put userTo
        if (loggedUser != null) {
            mav.addObject("userTo", loggedUser.getUserTo());
        }
        return mav;
    }
}
