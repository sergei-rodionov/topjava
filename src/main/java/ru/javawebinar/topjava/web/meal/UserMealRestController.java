package ru.javawebinar.topjava.web.meal;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.to.UserMealWithExceed;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
@RestController
@RequestMapping(UserMealRestController.REST_URL)
public class UserMealRestController extends AbstractUserMealController {
    static final String REST_URL = "/rest/meals";

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserMealWithExceed> getAll() {
        return super.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserMeal get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserMeal> createWithLocation(@RequestBody UserMeal userMeal) {
        UserMeal created = super.create(userMeal);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriOfNewResource);

        return new ResponseEntity<>(created, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    // for PUT need value="/"!!!
    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody UserMeal userMeal) {
        super.update(userMeal);
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
/*    public List<UserMealWithExceed>
    getFiltered(@RequestParam(value = "startDate", required = false, defaultValue = "1900-01-01")
              @DateTimeFormat(pattern = "yyyy-MM-dd")
              LocalDate startDate,
              @RequestParam(value = "endDate", required = false, defaultValue = "3000-01-01")
              @DateTimeFormat(pattern = "yyyy-MM-dd")
              LocalDate endDate,
              @RequestParam(value = "startTime", required = false, defaultValue = "00:00:00")
              @DateTimeFormat(pattern = "HH:mm:ss")
              LocalTime startTime,
              @RequestParam(value = "endTime", required = false, defaultValue = "23:59:59")
              @DateTimeFormat(pattern = "HH:mm:ss")
              LocalTime endTime) {
        return super.getBetween(startDate,startTime,endDate,endTime);
    }*/

    public List<UserMealWithExceed>
    getFiltered(@RequestParam(value = "startDateTime", defaultValue = "1900-01-01T00:00:00")
              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateTime,
              @RequestParam(value = "endDateTime",  defaultValue = "3000-12-31T23:59:59")
              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDateTime){
        return super.getBetween(startDateTime.toLocalDate(),startDateTime.toLocalTime(),
                endDateTime.toLocalDate(),endDateTime.toLocalTime());
    }

}