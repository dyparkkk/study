package dynamo_comment;

import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.GetItemEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static java.lang.System.exit;

@Repository
public class DynamoDbRepository {
    private final DynamoDbEnhancedClient enhancedClient;

    public DynamoDbRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient){
        this.enhancedClient = dynamoDbEnhancedClient;
    }

    public String getCustomer(String id, String sortValue){
        Customer result = null;

        DynamoDbTable<Customer> table = enhancedClient.table("Customer", TableSchema.fromBean(Customer.class));
        Key key = Key.builder()
                .partitionValue(id).sortValue(sortValue)
                .build();

        // get the item by using the key
        result = table.getItem((GetItemEnhancedRequest.Builder req) -> req.key(key));
        System.out.println("************ description value is " + result.getName());

        return result.getName();
    }

    public void putCustomer(Customer customer){
        DynamoDbTable<Customer> table = enhancedClient.table("Customer", TableSchema.fromBean(Customer.class));

        // 현재 시간
        LocalDateTime localDateTime = LocalDateTime.now();
        Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
        customer.setCreatedDate(instant);

        // put data
        table.putItem(customer);
    }
}
