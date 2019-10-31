package top.treegrowth.springsource.beancopy;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author wusi
 * @version 2018/9/3.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Child extends Parent {

    private Integer age;
    private List<SubObject> subObjects;
}
