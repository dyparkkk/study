package dynamo_comment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

@Configuration
public class DynamoDbConfig {

    // TODO : 나중에 중요정보로 관리해야함
    @Value("${AccessKeyId}")
    private String accessKey;

    @Value("${SecretAccessKey}")
    private String secretKey;

    @Bean
    public DynamoDbEnhancedClient dynamoDbEnhancedClient(DynamoDbClient dynamoDbClient){
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();
    }

    @Bean
    public DynamoDbClient DynamoClient(){
       return DynamoDbClient.builder()
                .region(Region.AP_NORTHEAST_2)
                .endpointOverride(URI.create("http://localhost:8000"))
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();
    }
}
