package top.treegrowth.java.pagesplit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class PageSpilt {

    private static final int RPC_ROW = 50;

    public void pageSplit() {
        List list = new ArrayList();
        int size = list.size();
        if (size > 0) {
            // 确定总页数
            int page = size % RPC_ROW > 0 ? size / RPC_ROW + 1 : size / RPC_ROW;
            for (int i = 1; i <= page; i++) {
                int fromIndex = (i - 1) * RPC_ROW;
                // 如果最有一页取上限，前面的都是各种乘
                int toIndex = i == page ? size : i * RPC_ROW;
            }
        }
    }
}
