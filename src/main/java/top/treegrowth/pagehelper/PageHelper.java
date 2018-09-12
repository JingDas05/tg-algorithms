package top.treegrowth.pagehelper;

import java.util.LinkedList;
import java.util.List;


/**
 * @author wusi
 * @version 2018/9/12.
 */
public class PageHelper {

    public static void main(String[] args) {
        List<RangePair> rangeBy = getRangeBy(1000, 34);

    }

    // 根据总页数 和 每页数量 返回总页数
    public static int getPageSize(int totalSize, int pageNum) {
        return totalSize % pageNum > 0 ?
                totalSize / pageNum + 1 : totalSize / pageNum;
    }

    // 根据总页数 和 每页数量 返回分批操作区间
    public static List<RangePair> getRangeBy(int totalSize, int pageNum) {
        List<RangePair> rangePairs = new LinkedList<>();
        int pageSize = getPageSize(totalSize, pageNum);
        int fromIndex;
        int toIndex;
        for (int i = 1; i <= pageSize; i++) {
            fromIndex = (i - 1) * pageNum;
            toIndex = i == pageSize ? totalSize : i * pageNum;
            rangePairs.add(new RangePair(fromIndex, toIndex));
        }
        return rangePairs;
    }

    public static class RangePair {
        private int from;
        private int end;

        public RangePair() {
        }

        public RangePair(int from, int end) {
            this.from = from;
            this.end = end;
        }

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }
}
