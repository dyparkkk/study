package dynamo_comment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import software.amazon.awssdk.services.dynamodb.model.DescribeTableResponse;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DynamoDbRepositoryTest {

    @Autowired
    private DynamoDbRepository dynamoDbRepository;

    @Autowired
    private CreateTable createTable;

    @Test
    void 테이블_생성(){
        DescribeTableResponse res = createTable.createTable("Customer");

        assertThat(res.table().tableName()).isEqualTo("Customer");
        System.out.println(res.table().toString());
    }


    @Test
    void 아이템_등록(){

    }

}