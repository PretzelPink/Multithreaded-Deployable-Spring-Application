
package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.WelcomeMessageGenerator;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LiveTimeController {


    @RequestMapping(path = "/presentation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String showPresentation() {
        return getTimes();


    }

    private String getTimes() {


String generatedTime = "";
        ZoneId zEastern = ZoneId.of("America/New_York");
        ZoneId zMountain = ZoneId.of("-07:00");
        ZoneId zUTC = ZoneId.of("UTC");

        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.of(2025, 5, 1, 12, 15);  // April 8, 2025 at 10:30 AM
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");


        generatedTime += "May 1, 2025 at " + localDateTime.format(formatter) + "\n";
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        ZonedDateTime zonedDateTimeEastern = zonedDateTime.withZoneSameInstant(zEastern);
        LocalDateTime localDateTimeEastern = zonedDateTimeEastern.toLocalDateTime();

        generatedTime += "Eastern time ET " + localDateTimeEastern.format(formatter) + "\n";
        ZonedDateTime zonedDateTimeMountain = zonedDateTime.withZoneSameInstant(zMountain);
        LocalDateTime localDateTimeMountain = zonedDateTimeMountain.toLocalDateTime();

        generatedTime += "Mountain time MS " + localDateTimeMountain.format(formatter) + "\n";
        ZonedDateTime zonedDateTimeUTC = zonedDateTime.withZoneSameInstant(zUTC);
        LocalDateTime localDateTimeUTC = zonedDateTimeUTC.toLocalDateTime();

        generatedTime += "Universal time UTC " + localDateTimeUTC.format(formatter) + "\n";



        return generatedTime;
    }
}
