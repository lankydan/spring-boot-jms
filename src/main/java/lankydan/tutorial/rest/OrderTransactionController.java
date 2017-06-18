package lankydan.tutorial.rest;

import lankydan.tutorial.documents.OrderTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transaction")
public class OrderTransactionController {

  @Autowired private JmsTemplate jmsTemplate;

  @PostMapping("/send")
  public void send(@RequestBody OrderTransaction transaction) {
    System.out.println("Sending a transaction.");
    jmsTemplate.convertAndSend(
        "OrderTransactionQueue", transaction);
  }
}
