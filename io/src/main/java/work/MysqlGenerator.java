//package work;
//
//import com.baomidou.mybatisplus.annotation.DbType;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.config.PackageConfig;
//import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//
///**
// * 代码生成器
// *
// * @author    liu_qinglei
// * @date      2022年10月1日
// */
//public class MysqlGenerator {
//
//    private static String outputDir = "F:/generator";
//    // 数据库连接配置
//    private static String db_userName = "root";
//    private static String db_password = "";
//    private static String db_url = "jdbc:mysql://ip 端口/demo_test?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8";
//
//    public static void main(String[] args) {
//        generate("USER_ACCOUNT");
//    }
//
//    static void generate(String... tableNamesInclude) {
//        /* 获取 JDBC 配置文件 */
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        gc.setOutputDir(outputDir);
//        gc.setFileOverride(true);
//        // 开启 activeRecord 模式
//        gc.setActiveRecord(true);
//        // XML 二级缓存
//        gc.setEnableCache(false);
//        // XML ResultMap
//        gc.setBaseResultMap(true);
//        // XML columList
//        gc.setBaseColumnList(true);
//        gc.setAuthor("liu_qinglei");
//
//        // 自定义文件命名，注意 %s 会自动填充表实体属性！
//        gc.setMapperName("%sMapper");
//        gc.setXmlName("%sMapper");
//        gc.setServiceName("%sService");
//        gc.setServiceImplName("%sServiceImpl");
//        gc.setControllerName("%sController");
//        mpg.setGlobalConfig(gc);
//
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setDbType(DbType.MYSQL);
//        dsc.setTypeConvert(new MySqlTypeConvert());
//        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        dsc.setUsername(db_userName);
//        dsc.setPassword(db_password);
//        dsc.setUrl(db_url);
//        mpg.setDataSource(dsc);
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        // strategy.setCapitalMode(true);// 全局大写命名
//        // strategy.setDbColumnUnderline(true);//全局下划线命名
//        // 表前缀
////		strategy.setTablePrefix(new String[] { "p_"});
//        // 表名生成策略
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        // 需要生成的表
//        strategy.setInclude(tableNamesInclude);
//
//        mpg.setStrategy(strategy);
//
//        // 包配置
//        String moduleName ="module";
//        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(moduleName);
//        pc.setParent("com.lover");
//        pc.setController("controller");
//        pc.setEntity("domain");
//        pc.setXml("mapperXml");
//        pc.setMapper("mapping");
//        pc.setService("service");
//        pc.setServiceImpl("service.impl");
//        mpg.setPackageInfo(pc);
//
//        // 执行生成
//        mpg.execute();
//    }
//}