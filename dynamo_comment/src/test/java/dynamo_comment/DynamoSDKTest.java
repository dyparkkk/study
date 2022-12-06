package dynamo_comment;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class DynamoSDKTest {
    private DynamoDbClient ddc;

    public void init() {
        ProfileCredentialsProvider profileCredentialsProvider = ProfileCredentialsProvider.create();

        ddc = DynamoDbClient.builder()
                .credentialsProvider(profileCredentialsProvider)
                .build();
    }

    void create

}
