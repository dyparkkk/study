package dynamo_comment;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

import java.time.Instant;

@DynamoDbBean
public class Customer {
    private String id;
    private int subId;
    private String name;
    private Instant createdDate;

    @DynamoDbPartitionKey
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDbSortKey
    public int getSubId() {
        return this.subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    @DynamoDbSecondaryPartitionKey(indexNames = "customers_by_name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDbSecondarySortKey(indexNames = {"customers_by_date", "customers_by_name"})
    public Instant getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }
}
