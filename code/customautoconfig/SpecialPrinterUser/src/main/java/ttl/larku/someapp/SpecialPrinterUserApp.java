package ttl.larku.someapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import ttl.larku.specialprinter.SpecialPrinter;

@SpringBootApplication//(exclude = {SpecialPrinterAutoConfig.class})//(excludeName = {"ttl.larku.specialprinter.SpecialPrinterAutoConfig"})
public class SpecialPrinterUserApp {

    public static void main(String[] args) {
        SpringApplication.run(SpecialPrinterUserApp.class, args);
    }

//    @Bean
//    public SpecialPrinter specialPrinter() {
//        SpecialPrinter sp = new SpecialPrinter();
//        sp.setPrefix("{");
//        sp.setSuffix("}");
//        return sp;
//    }
}

@Configuration
class OtherConfig
{
    @Bean
    public SpecialPrinter specialPrinter() {
        SpecialPrinter sp = new SpecialPrinter();
        sp.setPrefix("<");
        sp.setSuffix(">");
        return sp;
    }

}

@Component
class MyRunner implements CommandLineRunner
{

    @Autowired
    private SpecialPrinter specialPrinter;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(specialPrinter.log("boo"));
    }
}
