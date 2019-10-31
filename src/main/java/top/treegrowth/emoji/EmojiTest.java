package top.treegrowth.emoji;

import com.vdurmont.emoji.EmojiManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wusi
 * @since 2019-07-27 15:16
 */
public class EmojiTest {

    // emoji的正则
    private static Pattern eMojiPattern = Pattern.compile("\"(?:[\\uD83C\\uDF00-\\uD83D\\uDDFF]|[\\uD83E\\uDD00-\\uD83E\\uDDFF]|[\\uD83D\\uDE00-\\uD83D\\uDE4F]|[\\uD83D\\uDE80-\\uD83D\\uDEFF]|[\\u2600-\\u26FF]\\uFE0F?|[\\u2700-\\u27BF]\\uFE0F?|\\u24C2\\uFE0F?|[\\uD83C\\uDDE6-\\uD83C\\uDDFF]{1,2}|[\\uD83C\\uDD70\\uD83C\\uDD71\\uD83C\\uDD7E\\uD83C\\uDD7F\\uD83C\\uDD8E\\uD83C\\uDD91-\\uD83C\\uDD9A]\\uFE0F?|[\\u0023\\u002A\\u0030-\\u0039]\\uFE0F?\\u20E3|[\\u2194-\\u2199\\u21A9-\\u21AA]\\uFE0F?|[\\u2B05-\\u2B07\\u2B1B\\u2B1C\\u2B50\\u2B55]\\uFE0F?|[\\u2934\\u2935]\\uFE0F?|[\\u3030\\u303D]\\uFE0F?|[\\u3297\\u3299]\\uFE0F?|[\\uD83C\\uDE01\\uD83C\\uDE02\\uD83C\\uDE1A\\uD83C\\uDE2F\\uD83C\\uDE32-\\uD83C\\uDE3A\\uD83C\\uDE50\\uD83C\\uDE51]\\uFE0F?|[\\u203C\\u2049]\\uFE0F?|[\\u25AA\\u25AB\\u25B6\\u25C0\\u25FB-\\u25FE]\\uFE0F?|[\\u00A9\\u00AE]\\uFE0F?|[\\u2122\\u2139]\\uFE0F?|\\uD83C\\uDC04\\uFE0F?|\\uD83C\\uDCCF\\uFE0F?|[\\u231A\\u231B\\u2328\\u23CF\\u23E9-\\u23F3\\u23F8-\\u23FA]\\uFE0F?)\"");


    public static void main(String[] args) {
//        test();
//        String result = handleEmoji("\uD83D\uDE02奇葩的名字");
//        System.out.println(result);

        String regex = "[(/:)[@a-zA-Z0-9<>&#!?|$,~'+]]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("\uD83E\uDD28/:role");
//        Matcher matcher = pattern.matcher("Lin  小兜  ??? ?\n");
        System.out.println(matcher.find());
        System.out.println(matcher.group());
    }


    private static String handleEmoji(String userName) {
        // 去除自定义表情
//        String replacedUserName = userName.replaceAll("[(/:)[:@*a-zA-Z0-9<>&#()!?|$,~'+]{1,8}]{1,}", "");
        String replacedUserName = userName.replaceAll("[(/:)[:@*a-zA-Z0-9<>&#()!?|$,~'+]{1,8}]{1,}", "");

        // 寻找所有emoji的编码
        List<String> emojis = new ArrayList<>();
        Matcher matcher = eMojiPattern.matcher(userName);
        while (matcher.find()) {
            emojis.add(matcher.group());
        }
        Map<String, String> emojiHtml = new HashMap<>();
        emojis.forEach(each -> {
            emojiHtml.put(each, EmojiManager.getByUnicode(each).getAliases().get(0));
        });
        for (String emoji : emojis) {
            replacedUserName = replacedUserName.replaceAll(emoji, emojiHtml.getOrDefault(emoji, ""));
        }
        return replacedUserName;
    }


    public static void test() {
        Pattern weixinFacePattern = Pattern.compile("[(/:)[:@*a-zA-Z0-9<>&#()!?|$,~'+]{1,8}]{1,}");

        System.out.println(weixinFacePattern.matcher("/:jj/:rose").find());

        System.out.println(EmojiManager.isOnlyEmojis("\uD83D\uDE02\uD83D\uDE03文字"));
        System.out.println(EmojiManager.isOnlyEmojis("\uD83D\uDE02文字"));
        System.out.println(EmojiManager.isOnlyEmojis("\uD83D\uDE02\uD83D\uDE03"));
        System.out.println(EmojiManager.isOnlyEmojis("\uD83D\uDE02\uD83D\uDE03"));
        System.out.println(EmojiManager.getAllTags());
        System.out.println(EmojiManager.getAll());
//        EmojiManager.getForAlias();

        String s = "\uD83D\uDE00";
    }
}
