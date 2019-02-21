package genericTest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContext;

import java.util.Map;

public class GenericTest implements ApplicationContextAware {
   private ApplicationContext context;
    private Logger logger= LogManager.getLogger(GenericTest.class);
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
        this.context =applicationContext;
    }

    public <T> T getBean(Class<T> clazz){
        logger.info("getbean");
        return context.getBean(clazz);
    }

    static <K, V,T extends Map<K, V>> T test(Map<K, V> src, T dataSource){
         dataSource.getClass();

        return null;
    }
    public void test(){
        logger.info("test");
    }

    public static void main(String[] args){

        GenericTest genericTest = new GenericTest();
        GenericTest className= genericTest.getBean(GenericTest.class);
        genericTest.test();
        //System.out.println(className);





    }
}
