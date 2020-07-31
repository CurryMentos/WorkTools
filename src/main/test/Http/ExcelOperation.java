package Http;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.yaml.snakeyaml.util.UriEncoder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andy on 2019/1/9.
 * <p>
 * Excel操作
 * 1.登录人sheet操作
 * 2.活动基本信息sheet操作
 */
public class ExcelOperation {
    //读取数据源excel方法
    public static XSSFWorkbook workbook() throws IOException {

        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String mFile = new File(UriEncoder.decode(path), "testdata.xlsx").toString();
        //引入文件
        //InputStream inputStream = new FileInputStream("D:\\2019\\January\\testdata.xlsx");
        //定义工作簿
        XSSFWorkbook workbook = new XSSFWorkbook(mFile);

        return workbook;
    }

    //对于空单元格判断
    public static String dealRowNull(Row row, int index) {
        if (null == row.getCell(index)) {
            return "";
        } else {
            return row.getCell(index).getRichStringCellValue().getString();
        }
    }

    //读取Excel,sheet1，登录人信息
    public static List excelLogin(String title) throws IOException {
        List<String> list = new ArrayList();
        XSSFWorkbook workbook = ExcelOperation.workbook();
        //设定sheet
        Sheet sheet = workbook.getSheetAt(0);
        try {
            //遍历表单
            for (Row row : sheet) {
                //职务,账号,密码
                String post = row.getCell(0).getRichStringCellValue().getString();
                String name = row.getCell(1).getRichStringCellValue().getString();
                String pwd = row.getCell(2).getRichStringCellValue().getString();
                //首行不读取,row.getRowNum() == 0
                if (post.equals(title) && row.getRowNum() != 0) {
                    //将name,password添加到List,跳出遍历
                    list.add(post);
                    list.add(name);
                    list.add(pwd);
                    System.out.println("用户信息:" + list);
                    break;
                }
            }
            //关闭工作簿进程
            workbook.close();
        } catch (IOException e) {
            System.out.println("读取excel异常!");
        }
        //返回List
        return list;
    }

    //读取Excel,sheet2，活动基本信息
    public static List<String> excelApplyData(String type) throws IOException {
        List<String> list = new ArrayList();
        XSSFWorkbook workbook = ExcelOperation.workbook();
        Sheet sheet = workbook.getSheetAt(1);
        try {
            for (Row row : sheet) {

                String typeName = ExcelOperation.dealRowNull(row, 0);
                String marketCfgType = ExcelOperation.dealRowNull(row, 1);
                String totalMarketAmt = ExcelOperation.dealRowNull(row, 2);
                String marketDateType = ExcelOperation.dealRowNull(row, 3);
                String marketRange = ExcelOperation.dealRowNull(row, 4);
                String activityType = ExcelOperation.dealRowNull(row, 5);
                String otherRuleLimit = ExcelOperation.dealRowNull(row, 6);
                String bindCard = ExcelOperation.dealRowNull(row, 7);
                String roster = ExcelOperation.dealRowNull(row, 8);
                String clmListNo = ExcelOperation.dealRowNull(row, 9);
                String activityPurpose = ExcelOperation.dealRowNull(row, 10);
                String cycNum = ExcelOperation.dealRowNull(row, 11);
                String calculateTotalAmtType = ExcelOperation.dealRowNull(row, 12);
                //首行不读取,row.getRowNum() == 0
                if (typeName.equals(type) && row.getRowNum() != 0) {
                    //将字段添加到List,跳出遍历
                    list.add(typeName);
                    list.add(marketCfgType);
                    list.add(totalMarketAmt);
                    list.add(marketDateType);
                    list.add(marketRange);
                    list.add(activityType);
                    list.add(otherRuleLimit);
                    list.add(bindCard);
                    list.add(roster);
                    list.add(clmListNo);
                    list.add(activityPurpose);
                    list.add(cycNum);
                    list.add(calculateTotalAmtType);

                    System.out.println("基础数据:" + list);
                    break;
                }
            }
            //关闭工作簿进程
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    //读取Excel,sheet3，规则基本信息
    public static List<String> excelRules(String rule) throws IOException {
        List<String> list = new ArrayList();
        XSSFWorkbook workbook = ExcelOperation.workbook();
        Sheet sheet = workbook.getSheetAt(2);
        try {
            //行遍历,sheet.getLastRowNum()最大行数
            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                //从表格中取出需要的行数据
                Row row = sheet.getRow(rowNum);
                //如果行内容为空,继续遍历
                if (row == null) {
                    continue;
                }
                //列遍历
                for (int cellNum = 0; cellNum < sheet.getRow(0).getLastCellNum(); cellNum++) {
                    //从行中取出需要的列数据
                    Cell cell = row.getCell(cellNum);
                    //如果列内容为空,继续遍历
                    if (cell == null) {
                        continue;
                    }

                    String ruleName = ExcelOperation.dealRowNull(row, 0);
                    String calcType = ExcelOperation.dealRowNull(row, 1);
                    String thresholdAmt = ExcelOperation.dealRowNull(row, 2);
                    String fixedAmt = ExcelOperation.dealRowNull(row, 3);
                    String rebatePercentage = ExcelOperation.dealRowNull(row, 4);
                    String lowerAmt = ExcelOperation.dealRowNull(row, 5);
                    String upperAmt = ExcelOperation.dealRowNull(row, 6);
                    String rebateLevel = ExcelOperation.dealRowNull(row, 7);

                    if (ruleName.equals(rule) && row.getRowNum() != 0) {
                        list.add(ruleName);
                        list.add(calcType);
                        list.add(thresholdAmt);
                        list.add(fixedAmt);
                        list.add(rebatePercentage);
                        list.add(lowerAmt);
                        list.add(upperAmt);
                        list.add(rebateLevel);

                        System.out.println("规则数据:" + list);
                        break;
                    }
                }
            }
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    //读取Excel,sheet4，限额基本信息
    public static List<String> excelLimit(String limit) throws IOException {
        List<String> list = new ArrayList();
        XSSFWorkbook workbook = ExcelOperation.workbook();
        Sheet sheet = workbook.getSheetAt(3);
        try {
            for (Row row : sheet) {

                String limitName = ExcelOperation.dealRowNull(row, 0);
                String marketLimitDimension = ExcelOperation.dealRowNull(row, 1);
                String productDayNum = ExcelOperation.dealRowNull(row, 2);
                String productDayAmt = ExcelOperation.dealRowNull(row, 3);
                String productMonNum = ExcelOperation.dealRowNull(row, 4);
                String productMonAmt = ExcelOperation.dealRowNull(row, 5);
                String productCycNum = ExcelOperation.dealRowNull(row, 6);
                String productCycAmt = ExcelOperation.dealRowNull(row, 7);
                String dayNum = ExcelOperation.dealRowNull(row, 8);
                String dayAmt = ExcelOperation.dealRowNull(row, 10);
                String monNum = ExcelOperation.dealRowNull(row, 11);
                String monAmt = ExcelOperation.dealRowNull(row, 12);
                String cycNum = ExcelOperation.dealRowNull(row, 13);

                if (limitName.equals(limit) && row.getRowNum() != 0) {
                    list.add(limitName);
                    list.add(marketLimitDimension);
                    list.add(productDayNum);
                    list.add(productDayAmt);
                    list.add(productMonNum);
                    list.add(productMonAmt);
                    list.add(productCycNum);
                    list.add(productCycAmt);
                    list.add(dayNum);
                    list.add(dayAmt);
                    list.add(monNum);
                    list.add(monAmt);
                    list.add(cycNum);

                    System.out.println("限额数据:" + list);
                    break;
                }
                workbook.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    //读取Excel,sheet5，成本分摊基本信息
    public static List<String> excelCost(String costPtcptName) throws IOException {
        List<String> list = new ArrayList();
        XSSFWorkbook workbook = ExcelOperation.workbook();
        Sheet sheet = workbook.getSheetAt(4);
        try {
            for (Row row : sheet) {
                String costPtcpt = ExcelOperation.dealRowNull(row, 0);
                String costType = ExcelOperation.dealRowNull(row, 1);
                String costPercentage = ExcelOperation.dealRowNull(row, 2);
                String costMerchantCode = ExcelOperation.dealRowNull(row, 3);
                String costAccount = ExcelOperation.dealRowNull(row, 4);

                if (costPtcpt.equals(costPtcptName) && row.getRowNum() != 0) {
                    list.add(costPtcpt);
                    list.add(costType);
                    list.add(costPercentage);
                    list.add(costMerchantCode);
                    list.add(costAccount);

                    System.out.println("成本分摊方式:" + list);
                    break;
                }
                workbook.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //读取Excel,sheet6，申请人基本信息
    public static List<String> excelApplyInfo() throws IOException {
        List<String> list = new ArrayList();
        XSSFWorkbook workbook = ExcelOperation.workbook();
        Sheet sheet = workbook.getSheetAt(5);
        try {
            for (Row row : sheet) {
                String email = ExcelOperation.dealRowNull(row, 0);
                String teleNum = ExcelOperation.dealRowNull(row, 1);
                String departmentIds = ExcelOperation.dealRowNull(row, 2);
                String tms = ExcelOperation.dealRowNull(row, 3);

                if (row.getRowNum() != 0) {
                    list.add(email);
                    list.add(teleNum);
                    list.add(departmentIds);
                    list.add(tms);

                    System.out.println("申请人信息:" + list);
                    break;
                }
                workbook.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    //读取Excel,sheet7，代金券批次信息
    public static List<String> excelRebateVoucherInfo(String voucherTypeName) throws IOException {
        List<String> list = new ArrayList();
        XSSFWorkbook workbook = ExcelOperation.workbook();
        Sheet sheet = workbook.getSheetAt(6);
        try {
            for (Row row : sheet) {
                String voucherName = ExcelOperation.dealRowNull(row, 0);
                String voucherType = ExcelOperation.dealRowNull(row, 1);
                String businessType = ExcelOperation.dealRowNull(row, 2);
                String channel = ExcelOperation.dealRowNull(row, 3);
                String denomination = ExcelOperation.dealRowNull(row, 4);
                String toUrl = ExcelOperation.dealRowNull(row, 5);//跳转应用。商户联名券和业务券有
                String effectType = ExcelOperation.dealRowNull(row, 6);
                String effectInterval = ExcelOperation.dealRowNull(row, 7);
                String effectCircle = ExcelOperation.dealRowNull(row, 8);
                String spendingLimit = ExcelOperation.dealRowNull(row, 9);
                String spendingUpLimit = ExcelOperation.dealRowNull(row, 10);
                String averageNumber = ExcelOperation.dealRowNull(row, 11);
                String accountStar = ExcelOperation.dealRowNull(row, 12);
                String bindCard = ExcelOperation.dealRowNull(row, 13);
                String businessGoup = ExcelOperation.dealRowNull(row, 14);

                if (voucherName.equals(voucherTypeName) && row.getRowNum() != 0) {
                    list.add(voucherName);
                    list.add(voucherType);
                    list.add(businessType);
                    list.add(channel);
                    list.add(denomination);
                    list.add(toUrl);
                    list.add(effectType);
                    list.add(effectInterval);
                    list.add(effectCircle);
                    list.add(spendingLimit);
                    list.add(spendingUpLimit);
                    list.add(averageNumber);
                    list.add(accountStar);
                    list.add(bindCard);
                    list.add(businessGoup);

                    System.out.println("代金券批次信息:" + list);
                    break;
                }
                workbook.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //读取Excel,sheet8，红包金基本信息
    public static List<String> excelCouponBasicInfo(String couponType) throws IOException {
        List<String> list = new ArrayList();
        XSSFWorkbook workbook = ExcelOperation.workbook();
        Sheet sheet = workbook.getSheetAt(7);
        try {
            for (Row row : sheet) {
                String batchName = ExcelOperation.dealRowNull(row, 0);
                String batchType = ExcelOperation.dealRowNull(row, 1);
                String channel = ExcelOperation.dealRowNull(row, 2);
                String effectType = ExcelOperation.dealRowNull(row, 3);
                String effectInterval = ExcelOperation.dealRowNull(row, 4);
                String effectCircle = ExcelOperation.dealRowNull(row, 5);
                String denominationType = ExcelOperation.dealRowNull(row, 6);
                String denomination = ExcelOperation.dealRowNull(row, 7);
                String maxDenomination = ExcelOperation.dealRowNull(row, 8);
                String minDenomination = ExcelOperation.dealRowNull(row, 9);
                String thresholdAmt = ExcelOperation.dealRowNull(row, 10);
                String perCapitaCount = ExcelOperation.dealRowNull(row, 11);
                String customerLevelList = ExcelOperation.dealRowNull(row, 12);
                String needBindCard = ExcelOperation.dealRowNull(row, 13);
                String department = ExcelOperation.dealRowNull(row, 14);

                if (batchName.equals(couponType) && row.getRowNum() != 0) {
                    list.add(batchName);
                    list.add(batchType);
                    list.add(channel);
                    list.add(effectType);
                    list.add(effectInterval);
                    list.add(effectCircle);
                    list.add(denominationType);
                    list.add(denomination);
                    list.add(maxDenomination);
                    list.add(minDenomination);
                    list.add(thresholdAmt);
                    list.add(perCapitaCount);
                    list.add(customerLevelList);
                    list.add(needBindCard);
                    list.add(department);

                    System.out.println("红包金信息:" + list);
                    break;
                }
                workbook.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
