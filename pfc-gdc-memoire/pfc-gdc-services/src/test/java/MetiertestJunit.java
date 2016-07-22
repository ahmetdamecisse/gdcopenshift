

import com.gdc.pfc.gdc.services.Imetier;
import com.gdc.test.dao.Idao;
import com.gdc.test.jpa.Users;
import java.util.List;
import javax.naming.NamingException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author a618092
 */
public class MetiertestJunit {

    private static Imetier metier;

    @BeforeClass
    public static void init() throws NamingException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-metier-dao.xml");
        metier = (Imetier) ctx.getBean("metier");
    }

    @Test
    public void test1() {
        // Couche métier affichage les utilisateurs
        List<Users> users = metier.getALLutilisateur();
        System.out.println("******************************************************************************");
        System.out.println("*********************Couche métier: Lies des utilisateurs******************************");
        System.out.println(users);
    }

}
