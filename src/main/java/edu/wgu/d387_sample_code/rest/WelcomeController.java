
package edu.wgu.d387_sample_code.rest;
import com.mysql.cj.xdevapi.JsonArray;
import edu.wgu.d387_sample_code.WelcomeMessageGenerator;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
@RequestMapping("/api")
public class WelcomeController {



    @RequestMapping(path ="", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String showPresentation() {
        return genWelcome();


    }

   private String genWelcome(){

       String[] message;
       WelcomeMessageGenerator generator=new WelcomeMessageGenerator();
       message =  generator.generateWelcome();

       return message[0] + ", " + message[1];
    }

    }