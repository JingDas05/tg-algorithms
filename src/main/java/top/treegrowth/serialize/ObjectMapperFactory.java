package top.treegrowth.serialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

/**
 * @author wusi
 * @version 2018/8/9.
 */
public class ObjectMapperFactory {

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }


}
