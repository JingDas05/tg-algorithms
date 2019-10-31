package top.treegrowth.springsource.beancopy;

import lombok.Data;

import java.util.List;

/**
 * @author wusi
 * @version 2018/9/3.
 */
@Data
public class CopyTarget {

    private String name;
    private Integer age;
    private Integer subAge;
    private List<SubObject> subObjects;
}
