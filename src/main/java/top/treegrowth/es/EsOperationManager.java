package top.treegrowth.es;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.geo.GeoDistance;
import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.GeoDistanceSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * es增删改查服务
 *
 * @author wusi
 */
//@Service
public class EsOperationManager {

    @Resource
    private TransportClient client;
    private Logger logger = LoggerFactory.getLogger(getClass());

    // es序列化工具
    private static com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    static {
        objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        // 反序列化有未知属性时不失败
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public Boolean createStation(String index, String type, String id, Object source) throws Exception {
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        bulkRequest.add(client
                .prepareIndex(index, type, id)
                .setSource(objectMapper.writeValueAsString(source), XContentType.JSON));

        BulkResponse bulkResponse = bulkRequest.get();
        if (bulkResponse.hasFailures()) {
            logger.error("es 创建索引失败，错误原因={}", bulkResponse.buildFailureMessage());
            return false;
        }
        return true;
    }

    public Boolean updateStationById(String index, String type, String id, Object source) throws Exception {
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        XContentBuilder xContentBuilder = jsonBuilder().startObject();
        xContentBuilder.field("field", new GeoPoint(1, 2));
        xContentBuilder.endObject();
        bulkRequest.add(client
                .prepareUpdate(index, type, id).setDoc(xContentBuilder));
        bulkRequest.get();
        return true;
    }

    public void getStationsByIds(String index, String type, List<String> stationIds) {
        List<String> stationStrIds = stationIds.stream().map(String::valueOf).collect(Collectors.toList());
        QueryBuilder idQuery = idsQuery().addIds("1", "2");
        SearchHits searchHits = client.prepareSearch(index)
                .setTypes(type)
                .setQuery(idQuery)
                .get()
                .getHits();
        for (SearchHit searchHit : searchHits.getHits()) {
            System.out.println(searchHit.getSourceAsString());
        }
    }

    public void distanceSearch(GeoPoint geoPoint,
                               Integer[] typeIds,
                               Integer status,
                               Integer distance,
                               String unit,
                               Integer from,
                               Integer size) {
        DistanceUnit distanceUnit;

        // 距离查询
        QueryBuilder geoDistanceQuery = geoDistanceQuery("lacation")
                .point(geoPoint.getLat(), geoPoint.getLon())
                .distance(distance, DistanceUnit.KILOMETERS);
        // bool 查询
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder
                .must(termsQuery("typeIds", typeIds))
                .must(termQuery("status", status))
                .must(geoDistanceQuery);
        // 结果按距离排序
        GeoDistanceSortBuilder sortBuilder = new GeoDistanceSortBuilder("location", geoPoint)
                .unit(DistanceUnit.METERS)
                .order(SortOrder.ASC)
                .geoDistance(GeoDistance.PLANE);
        // 执行查询
        SearchHits searchHits = client.prepareSearch("index")
                .setTypes("type")
                .setQuery(boolQueryBuilder)
                .setFrom(from)
                .setSize(size)
                .addSort(sortBuilder)
                .get()
                .getHits();
        for (SearchHit searchHit : searchHits.getHits()) {
            System.out.println(searchHit.getSourceAsString());
        }
    }

    // 范围查询
    public void boxSearch(double currentLat,
                          double currentLon,
                          double top,
                          double left,
                          double bottom,
                          double right,
                          Integer[] typeIds,
                          Integer status,
                          int from,
                          int size) {
        // 区域查询 location 在ES中是GEO类型
        QueryBuilder getBoundingQuery = geoBoundingBoxQuery("location").
                setCorners(top, left, bottom, right);
        // bool 查询
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder
                .must(termsQuery("typeId", typeIds))
                .must(termQuery("status", status))
                .must(getBoundingQuery);
        SearchHits searchHits = client
                .prepareSearch("index")
                .setTypes("type")
                .setFrom(from)
                .setSize(size)
                .setQuery(boolQueryBuilder)
                .get()
                .getHits();
        logger.info(boolQueryBuilder.toString());
        for (SearchHit searchHit : searchHits.getHits()) {
            System.out.println(searchHit.getSourceAsString());
        }
    }
}
