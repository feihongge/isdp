package edu.scau.mis;

import edu.scau.mis.view.Register;
import edu.scau.mis.view.SaleFrame;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication(scanBasePackages = {
        "edu.scau.mis",
        "edu.scau.mis_pos"
})
@MapperScan("edu.scau.mis_pos.mapper")
public class IsdpBootApplication {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            try {

                ApplicationContext context = SpringApplication.run(IsdpBootApplication.class, args);

                Register register = context.getBean(Register.class);
                SaleFrame saleFrame = new SaleFrame(register);
                saleFrame.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}