package dynamo_comment;

import org.springframework.stereotype.Component;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.awssdk.services.dynamodb.waiters.DynamoDbWaiter;

//  언제 호출해야 되는지 모르겠어...
@Component
public class CreateTable {

    private final DynamoDbClient client;

    public CreateTable(DynamoDbClient dynamoDbClient){
        this.client = dynamoDbClient;
    }

    public DescribeTableResponse createTable(String tableName) {
        DynamoDbWaiter dbWaiter = client.waiter();
        CreateTableRequest req = CreateTableRequest.builder()
                .attributeDefinitions(AttributeDefinition.builder()
                        .attributeName(key)
                        .attributeType(ScalarAttributeType.S)
                        .build())
                .keySchema(KeySchemaElement.builder()
                        .attributeName(key)
                        .keyType(KeyType.HASH)
                        .build())
                .provisionedThroughput(ProvisionedThroughput.builder()
                        .readCapacityUnits(1L)
                        .writeCapacityUnits(1L)
                        .build())
                .tableName("myTable")
                .build();

        CreateTableResponse createTableResponse = ddc.createTable(req);
    }
}
