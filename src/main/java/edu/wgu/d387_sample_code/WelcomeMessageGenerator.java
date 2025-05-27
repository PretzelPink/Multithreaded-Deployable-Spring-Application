package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class WelcomeMessageGenerator {


    public static String[] generateWelcome(){
        ExecutorService messageExecutor = Executors.newFixedThreadPool(2);

        Properties properties=new Properties();
        String[] welcome = new String[]{"", ""};
        CountDownLatch countDownLatch=new CountDownLatch(2);
        messageExecutor.execute(()-> {
            try {
                InputStream stream = new ClassPathResource("translation_en_US.properties").getInputStream();
                properties.load(stream);
                if(welcome[0].equals("")){ welcome[0] = (properties.getProperty("welcome")).replace("\"", "");} else{  welcome[1] = properties.getProperty("welcome").replace("\"", "");}
            } catch (Exception e) {

            } finally {
                countDownLatch.countDown();
            }
        });
        messageExecutor.execute(()-> {
            try {
                InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
                properties.load(stream);
                if(welcome[0].equals("")){ welcome[0] = properties.getProperty("welcome").replace("\"", "");} else{  welcome[1] = properties.getProperty("welcome").replace("\"", "");}
            } catch (Exception e) {

            } finally {
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {

        }
        messageExecutor.shutdown();
        return welcome;
    }
}
