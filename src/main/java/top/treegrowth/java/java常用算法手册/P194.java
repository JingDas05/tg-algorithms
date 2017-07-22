package top.treegrowth.java.java常用算法手册;

/**
 *
 * @author wusi
 * @version 2017/7/23 7:32.
 */
public class P194 {

    /**
     *
     * 计算出最可能的学生人数和已就业人数
     *
     * @param iNum 毕业人数300
     * @param iOff 上下波动数量20
     * @param fPercent 就业率0.8323f
     *
     */
    private void calcByEnum(int iNum, int iOff, float fPercent) {
        float fMinDiff = 1.0f, fTmp;
        int iRealNum = 300;
        for (int i = iNum - iOff + 1; i<= iNum + iOff; i++) {
            // 对281 到320 之间的数进行枚举，计算 就业率和 所给就业率最小的实际学生数
            fTmp = Math.abs(Math.round(i*fPercent)/(float)i - fPercent);
            if (fTmp < fMinDiff) {
                fMinDiff = fTmp;
                iRealNum = i;
            }
        }
        // 根据计算出的实际学生数计算 已结业的学生数
        int iJiuYe = Math.round(iRealNum * fPercent);
        System.out.println("通过枚举，计算出学生的总人数："+ iRealNum);
        System.out.println("已就业学生人数："+ iJiuYe);
        System.out.println("初始就业率条件："+ fPercent*100+"%");
        System.out.println("计算结果对应的就业率是："+ iJiuYe/(float)iRealNum*100 + "%");
    }

    public static void main(String[] args) {
        P194 studentEnum = new P194();
        studentEnum.calcByEnum(300, 20, 0.8323f);
    }
}
