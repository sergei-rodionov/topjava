package ru.javawebinar.topjava.web.meal;

import org.junit.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.javawebinar.topjava.web.AbstractControllerTest;

import static org.hamcrest.Matchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ru.javawebinar.topjava.MealTestData.MEAL1;
import static ru.javawebinar.topjava.MealTestData.MEAL1_ID;

/**
 * GKislin
 * 10.04.2015.
 */
public class UserMealControllerTest extends AbstractControllerTest {

    @Test
    public void testMealList() throws Exception {
        // Login as viewer
        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken("user@yandex.ru", "password"));

        mockMvc.perform(get("/meals"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("mealList"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/mealList.jsp"))
                .andExpect(model().attribute("mealList", hasSize(6)))
                .andExpect(model().attribute("mealList", hasItem(
                        allOf(
                                hasProperty("id", is(MEAL1_ID)),
                                hasProperty("description", is(MEAL1.getDescription()))
                        )
                )));

        SecurityContextHolder.clearContext();
    }

    @Test
    public void testLogin() throws Exception {
        mockMvc.perform(formLogin("/spring_security_check").user("user@yandex.ru").password("password"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(redirectedUrl("/meals"));
    }
}