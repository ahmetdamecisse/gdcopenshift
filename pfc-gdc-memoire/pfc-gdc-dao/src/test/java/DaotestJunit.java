import com.gdc.test.dao.Idao;
import com.gdc.test.jpa.Users;
import java.util.List;
import javax.naming.NamingException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 import com.gdc.test.dao.Idao;
 import com.gdc.test.jpa.Users;
 import java.util.List;
 import javax.naming.NamingException;
 import junit.framework.TestCase;
 import org.junit.BeforeClass;
 import org.springframework.context.ApplicationContext;
 import org.springframework.context.support.ClassPathXmlApplicationContext;

 /**
 *
 * @author a618092
 */
public class DaotestJunit {

    private static Idao dao;

    @BeforeClass
    public static void init() throws NamingException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-dao.xml");
        dao=(Idao) ctx.getBean("dao");
    }

    @Test
    public void test1() {
        // affichage les utilisateurs
        List<Users> users = dao.getALLutilisateur();
        System.out.println("******************************************************************************");
         System.out.println("*********************Lies des utilisateurs******************************");
        System.out.println(users);
    }

}
