package us.codecraft.webmagic.main;

import com.atguigu.gulimall.stock.entity.StockEntity;
import com.atguigu.gulimall.stock.service.StockService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.JsonPathSelector;
import us.codecraft.webmagic.utils.HttpConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

//筛选出22天里最近一天最低的非机构持仓的轻度控盘或中度控盘的股票
public class YiMei implements PageProcessor {

    @Autowired
    StockService stockService;

    List<String> url2s=new ArrayList<>();

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setCharset("utf-8").setRetryTimes(3).setSleepTime(1000);

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        String raw = String.valueOf(new JsonPathSelector("$").selectList(page.getRawText()));
        //System.out.println(raw);
        String[] split = raw.split("\\[|\\]");
        String jsonArray="{\"data\":["+split[2].toString()+"]}";
        //System.out.println(jsonArray);

        List<String> sumJGCXD = new ArrayList<>();


        for (int i = 0; i < 22; i++) {


            List<String> strings = new JsonPathSelector("$.data["+i+"].JGCYD").selectList(jsonArray);
            sumJGCXD.addAll(strings);



        }

        String[] split1 = sumJGCXD.toString().split("\\[|\\]")[1].split(",");
        float[] fsplit1=new float[split1.length];
        for (int i = 0; i < split1.length; i++) {
            fsplit1[i]=Float.parseFloat(split1[i]);
        }


        float max=fsplit1[0];//将数组的第一个元素赋给max
        float min=fsplit1[0];//将数组的第一个元素赋给min
        for(int i=1;i<fsplit1.length;i++){//从数组的第二个元素开始赋值，依次比较
            if(fsplit1[i]>max){//如果arr[i]大于最大值，就将arr[i]赋给最大值
                max=fsplit1[i];
            }
            if(fsplit1[i]<min){//如果arr[i]小于最小值，就将arr[i]赋给最小值
                min=fsplit1[i];
            }
        }
        String sn= String.valueOf(new JsonPathSelector("$.data[0].STOCKNAME").selectList(jsonArray));
        System.out.print(sn);
        String tc= String.valueOf(new JsonPathSelector("$.data[0].TRADECODE").selectList(jsonArray));
        System.out.print(tc);
        if(fsplit1[0]==min) {
            System.out.print("今天的最小股票有了！！！    ");
            StockEntity stockEntity = new StockEntity();

       stockEntity.setStockname(sn);
        stockService.save(stockEntity);
        System.out.println("保存成功");



            System.out.print(min+"             ");
            System.out.print(tc+"             ");
            String code = tc.substring(1, tc.length() - 1);
        }
        if(fsplit1[0]==max){
            System.out.print("今天的最大股票有了！！！    ");
            System.out.print(max+"             ");
            System.out.print(tc+"             ");
            String code=tc.substring(1,tc.length() - 1);
        }


    }


    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) throws SQLException {
        Request request = new Request();
        request.setMethod(HttpConstant.Method.GET);

        List<String> l = asList(

                "301046","002916","002815","603386","002599","000695","600987","301129","300720","300354","301017","002432","603301","000629","600295","002847","001219","603719","300317","300139","002256","000862","603693","603105","601016","600905","600821","600163","600032","603665","605555","300684","300032","002885","002782","002369","002139","605277","603595","300933","002882","002879","002606","002300","001208","605196","603897","603606","600259","603836","002125","600367","600328","600110","003040","002491","000836","000586","601869","600522","300698","300134","002897","002796","300081","600804","001213","300318","001207","605183","300055","003039","603759","601199","000935","000546","002039","000993","000791","300987","300571","300364","000681","301012","300932","300670","300141","002706","002452","002350","002112","603861","605599","002597","603079","300839","002986","600688","000848","605198","300830","300608","300605","300598","300556","300377","300366","002405","002153","600602","605567","002015","605580","605162","605011","300435","300332","605169","603393","603318","603080","000751","000688","600961","600338","301072","300998","300969","300926","300863","300745","300681","300652","300507","300432","002870","002865","002510","002454","002283","000880","000816","000700","605333","605133","603982","603922","603917","603348","603286","603178","603048","600841","600742","600218","300461","301013","300813","300540","300499","300472","300471","002837","002529","002073","002006","603895","300970","002772","600540","000150","603399","600281","300320","603033","301083","301032","300992","300503","002598","603617","600243","300353","300321","002108","001215","300204","603978","603045","603038","300640","001216","300610","300437","002455","603948","603683","600727","600500","600273","300927","300082","001217","600955","600844","600423","301066","301031","300656","300184","002922","300820","300693","300376","300153","300105","002518","002366","300217","002011","002045","300261","605033","600389","002192","000762","300275","300084","002667","000852","601608","300179","002046","002096","300088","003019","605218","603703","000937","601101","601001","600348","002505","600725","002748","000635","603213","600618","600277","003038","002824","603115","601702","601388","002774","605286","300505","002895","000422","600470","600096","002852","300629","300474","300848","002165","603192","300985","300946","300828","300488","300421","300402","300092","002552","002164","002132","603969","603667","300688","300338","300192","300010","003032","002607","000526","600661","600636","600740","603938","002631","002489","300691","300588","300508","300672","300613","300327","300982","300712","002941","002060","601800","600039","002747","300809","300161","002943","002248","000837","603088","601882","001896","601991","600863","600021","600011","301081","300786","000551","301075","300573","300199","002411","000931","300209","301092","002395","605589","300900","300159","000697","300810","300600","300065","600764","600150","002155","301048","300351","300011","300336","000676","600556","002808","605588","600071","300842","300827","300393","002610","002309","000821","603628","603396","300854","300614","603283","301038","300746","603458","605305","600815","600548","002886","002539","002538","002170","300343","002915","002326","605020","603505","603379","600160","002762","002612","002193","301040","300772","300690","300443","002531","002487","002202","603985","603507","603063","601218","603688","603612","600170","300917","002647","000416","600783","300882","300514","300490","300360","601126","600268","000875","600995","600483","300660","002576","002249","002176","000922","603988","300648","300619","300438","300340","300173","300073","300035","002805","603026","600478","002206","300922","000576","600435","000912","000731","600691","603315","002056","600366","300967","301025","605577","600658","600293","603738","600237","300260","002565","003043","600861","600361","002254","300162","300752","300895","300350","300290","300277","300264","002453","002368","603138","600571","300774","300305","300831","300776","002131","002270","002717","002756","600499","601890","605222","002418","603916","300118","300943","301022","301079","300373","300552","300708","300799","301030","000628","002664","002920","600152","600860","301060","300975","300945","300907","300902","300866","300741","300659","300591","300224","300220","300076","002923","002860","000812","000795","603529","603416","603219","600843","600212","300337","300869","000838","002269","002317","600587","603398","603518","300127","300061","002264","605116","600479","600351","600318","300165","300412","300500","300678","301007","002374","002537","600935","300766","300464","300311","002935","002581","002243","603031","600847","300017","300022","300132","300602","300742","300948","001317","002322","002584","002803","600421","603499","301039","300765","300580","300406","300276","301099","300521","002600","002490","000503","603637","600356","600235","002970","002708","002232","002009","000860","603779","600807","000892","300860","600371","601798","605255","000595","000889","000962","002101","002813","002945","600148","601212","000599","002825","000736","002265","002725","600638","600698","603335","603701","000756","002609","605369","300675","300235","300291","300295","300479","300950","300960","300112","300707","300949","301011","301008","300299","300578","300771","300663","300805","300845","301010","301126","300865","301058","301167","300045","300603","301068","301118","300120","300250","300491","300650","300713","000049","000552","000753","002253","002783","300466","603071","603586","000409","000514","001267","002263","002587","002628","301213","600159","600188","600192","600466","600939","603216","603888","000767","003010","301111","000411","000665","002682","002991","300612","600396","601700","603466","603663","605050","605128","605151","002590","002629","002691","603598","300683","300237","301178","300844","300846","300026","300086","300254","300452","300233","300248","300075","600770","600668","603011","600444","601107","001296","002480","300436","601116","603230","603963","002775","600880","600927","002639","002750","600463","603197","605318","000632","000863","001211","002059","002316","002424","002495","002822","603171","605138","000008","000042","000151","000607","000757","000965","002082","002247","002333","002560","002731","300534","600202","600791","601996","603023","603566","000918","001202","001288","002173","002178","002357","002671","003008","600220","600405","600605","603169","603825","002746","600866","603803","300247","300562","301138","000620","002370","002482","600381","603616","000554","002486","600530","605388","000056","000819","000955","002107","002195","002721","002723","600077","603123","603536","000597","000953","000999","002118","002873","600085","600129","600272","600976","600996","603176","603368","300546","300939","300056","300111","300858","300043","300389","300094","300519","300585","300181","301043","301168","300213","000970","002246","002951","300818","600353","600981","603311","000530","002694","002883","002907","003017","600343","600986","600992"

        );


        for (String t:l){
            StringBuilder s=new StringBuilder("http://dcfm.eastmoney.com/em_mutisvcexpandinterface/api/js/get?type=QGQP_LSJGCYD&token=70f12f2f4f091e459a279469fe49eca5&ps=22&filter=(TRADECODE=%27");
            s.append(t);
            s.append("%27)&st=TRADEDATE&sr=-1&callback=jQuery112307965527139220383_1617014060178&_=1617014060179");
            System.out.println(s);
            request.setUrl(s.toString());





            Spider.create(new YiMei())
                    //从"https://github.com/code4craft"开始抓
                    .addRequest(request)
                    .addPipeline(new FilePipeline("D:/data"))
                    .addPipeline(new ConsolePipeline())
                    //开启5个线程抓取
                    .thread(20)
                    //启动爬虫
                    .run();

        }
    }
}
