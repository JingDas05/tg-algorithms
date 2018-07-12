package top.treegrowth.lombok;

import lombok.*;

/**
 * @author wusi
 */
@ToString(exclude = {"id", "name"})
@EqualsAndHashCode()
@AllArgsConstructor()
@NoArgsConstructor()
public class LombokBean {

    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String name;

    @Synchronized
    public void c() {
        System.out.println("sync");
    }

}
