package co.nz.acc.icp.samples.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@SpringBootApplication
public class JavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaApplication.class, args);
    }

}

@ShellComponent
class ICPCommands {

    @ShellMethod("Create an ICP Referral Accept FHIR message.")
    public int createReferralAccept(int a, int b) {
        return a + b;
    }

}
