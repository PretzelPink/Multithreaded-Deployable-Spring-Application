/*
package edu.wgu.d387_sample_code;

import org.json.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@SpringBootApplication
public class SampleApplication {
    static ExecutorService messageExecutor=newFixedThreadPool(2);
    public static void main(String[] args) {


        System.out.println(generateWelcome(args)[0]);



    }

    public static String[] generateWelcome(String[] args){
        SpringApplication.run(SampleApplication.class, args);
        Properties properties=new Properties();
        String[] welcome = new String[]{"",""};
        messageExecutor.execute(()-> {
            try {
                InputStream stream = new ClassPathResource("translation_en_US.properties").getInputStream();
                properties.load(stream);
                if(welcome[0].equals("")){ welcome[0] = properties.getProperty("welcome");} else{  welcome[1] = properties.getProperty("welcome");}
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        messageExecutor.execute(()-> {
            try {
                InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
                properties.load(stream);
               if(welcome[0].equals("")){ welcome[0] = properties.getProperty("welcome");} else{  welcome[1] = properties.getProperty("welcome");}
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        while(true){
        if(welcome[0].length()>0 && welcome[1].length()>0){
            break;
        }
        }
        return welcome;
    }
}


*/
