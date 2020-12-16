package ttl.larku.didemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

interface TrickInterface {
   public void doTrick();
}

@Component
//@Qualifier("East")
//@Primary
@Profile("dev")
class Trick1 implements TrickInterface
{
   @Override
   public void doTrick() {
      System.out.println("Handstand");
   }
}

@Component
//@Qualifier("West")
//@Order(2)
@Profile("prod")
class Trick2 implements TrickInterface
{
   @Override
   public void doTrick() {
      System.out.println("Card Trick");
   }
}

//@Component
//@Qualifier("West")
//@Order(1)
//class Trick3 implements TrickInterface
//{
//   @Override
//   public void doTrick() {
//      System.out.println("Somersault");
//   }
//}

@Component
class Circus
{
   //   @Resource//(name = "trick2")
   private final TrickInterface trick;

//   @Autowired
//   @Qualifier("West")
//   private TrickInterface trick3;


   //   @Resource//(name = "trick2")
   private final List<TrickInterface> allTricks;

   @Autowired
   public Circus(TrickInterface trick, List<TrickInterface> allTricks) {
      this.trick = trick;
      this.allTricks = allTricks;
   }

   public void startShow() {
//       allTricks.forEach(TrickInterface::doTrick);
      trick.doTrick();
   }

   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
      context.getEnvironment().setActiveProfiles("prod");
      context.scan("ttl.larku.didemo");
      context.refresh();

      Circus circus = context.getBean("circus", Circus.class);
      circus.startShow();
   }
}
