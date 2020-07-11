package lankydan.tutorial.rest;

import lankydan.tutorial.documents.OrderTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class OrderTransactionController {

  private static final Logger log = LoggerFactory.getLogger(OrderTransactionController.class);

  private final JmsTemplate jmsTemplate;

  public OrderTransactionController(JmsTemplate jmsTemplate) {
    this.jmsTemplate = jmsTemplate;
  }

  @PostMapping("/send")
  public void send(@RequestBody OrderTransaction transaction) {
    log.info("Sending a transaction.");
    jmsTemplate.convertAndSend(
        "OrderTransactionQueue", transaction);
  }
}
