package dynamo_comment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.awssdk.services.dynamodb.waiters.DynamoDbWaiter;

import java.net.URI;
import java.util.HashMap;

import static org.assertj.core.api.BDDAssertions.then;

public class DynamoSDKTest {
    private DynamoDbClient ddc;
    private String key;

    @BeforeEach
    public void init() {
        ddc = DynamoDbClient.builder()
                .credentialsProvider(ProfileCredentialsProvider.create())
                .endpointOverride(URI.create("http://localhost:8000"))
                .region(Region.AP_NORTHEAST_2)
                .build();

        key = "key";
    }

    @Test
    void 테이블_생성(){
        DynamoDbWaiter dbWaiter = ddc.waiter();
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

        then(createTableResponse.tableDescription().tableName()).isEqualTo("myTable");
    }

    @Test
    void 아이템_삽입(){
        HashMap<String, AttributeValue> itemValues = new HashMap<>();

        itemValues.put(key, AttributeValue.builder().s("3").build());
        itemValues.put("name", AttributeValue.builder().s("doyoung").build());
        itemValues.put("hello", AttributeValue.builder().s("world").build());

        PutItemRequest req = PutItemRequest.builder()
                .tableName("myTable")
                .item(itemValues)
                .build();

        try {
            PutItemResponse putItemResponse = ddc.putItem(req);
            System.out.println("req is " + putItemResponse.responseMetadata().requestId());

        } catch (ResourceNotFoundException e) {
            System.err.println(" 존재하지 않음 ");
        }
    }


}
