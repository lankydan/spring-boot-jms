package lankydan.tutorial.repositories;

import lankydan.tutorial.documents.OrderTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderTransactionRepository extends MongoRepository<OrderTransaction, String> {}
