import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by zengyouzu on 2020-06-22.
 */
public class Test {
    public static void main(String[] args) {
        Average.average(Score.score());
    }
}

class Score {
    public static List<String> score() {
        //计数器记录无效分数个数
        int count = 0;
        //计数器记录当前评委
        int no = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入选手姓名:");
            String name = scanner.next();
            System.out.println("请输入选手学号:");
            String id = scanner.next();
            try {
                System.out.println("请输入选手评分:");
                double score = scanner.nextDouble();
                DecimalFormat df = new DecimalFormat("#.00");
                if (score < 0 || score > 10) {
                    System.out.println("分数必须在0-10分之间");
                    throw new Exception();
                } else {
                    list.add(df.format(score));
                    System.out.println("************************");
                    System.out.println("选手姓名:" + name);
                    System.out.println("选手学号:" + id);
                    System.out.println("选手评分:" + score);
                }
            } catch (Exception e) {
                System.out.println("输入错误,评分无效");
                count++;
                if (count > 8) {
                    System.out.println("有效分数少于2个");
                    break;
                }
            } finally {
                no++;
                System.out.println("************************");
                System.out.println("第" + no + "名评委打分完毕");
            }
        }
        return list;
    }
}

abstract class Average implements Calculate{
    public static void average(List<String> list) {
        List<Double> scoreList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            scoreList.add(Double.valueOf(list.get(i)));
        }
        //排序
        Collections.sort(scoreList);
        //计算总分(去掉最低分和最高分)
        Double sum = 0.00;
        for (int i = 1; i < scoreList.size() - 1; i++) {
            sum += scoreList.get(i);
        }
        System.out.println("***********计算平均分***********");
        System.out.println("选手最终得分:" + new DecimalFormat("#.00").format(sum / (scoreList.size() - 2)));
    }
}

interface Calculate{
    void average();
}