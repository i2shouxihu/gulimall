package us.codecraft.webmagic.main;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.JsonPathSelector;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

//筛选出22天里最近一天最低的非机构持仓的轻度控盘或中度控盘的股票
public class EastMoneyQuan4 implements PageProcessor {

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
        System.out.print(new JsonPathSelector("$.data[0].STOCKNAME").selectList(jsonArray));
        System.out.print(new JsonPathSelector("$.data[0].TRADECODE").selectList(jsonArray));
        if(fsplit1[0]==min){
            System.out.print("今天的最小股票有了！！！    ");
            System.out.println(min);
        }
        if(fsplit1[0]==max){
            System.out.print("今天的最大股票有了！！！    ");
            System.out.println(max);
        }



//        if(fsplit1[3]==min){
//            System.out.println("3天后涨停");
//            System.out.println(min);
//        }
//        if(fsplit1[4]==min){
//            System.out.println("4天后涨停");
//            System.out.println(min);
//        }
//        if(fsplit1[5]==min){
//            System.out.println("5天后涨停");
//            System.out.println(min);
//        }
//        if(fsplit1[6]==max){
//            System.out.println("6天后涨停");
//            System.out.println(min);
//        }





    }


    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Request request = new Request();
        request.setMethod(HttpConstant.Method.GET);

        List<String> l = asList(



               // "688509","002453","300339","603171","600225","688787","300350","300682","300079","300687","300264","688568","600845","000938","600571","002649","000409","300290","600850","002642","000158","300288","300167","300496","300300","002368","688039","300287","300250","300419","300541","002609","600728","605398","603138","603869","300440","002421","300738","300020","300212","300277","603003","002771","600131","300895","300096","600271","600476","300150","002474","300532","300634","002195","603636","300231","002777","002657","002380","300170","002232","300245","600718","600797","603918","688316","002065","300248","300674","002401","300166","688500","300017","300609","300678","000555","000638","002331","600756","002530","688158","600446","300383","300872","002373","300448","603881","600410","300078","688004","300297","688228","000034","300523","300399","002417","003005","688258","000606","600536","688051","300168","603887","688088","688229","688365","300846","300044","301085"
//1养殖业27
                //2水产养殖6
                "300094","002086","002069","600275","600467","600257",
                //2海洋捕捞2
                "000798","600097",
                //2畜禽养殖19
                "300967","300761","300498","300313","002982","002746","002714","002458","002321","002299","002234","002157","002124","001201","000735","605296","603477","600975","600965"



                
        );

























        for (String t:l){
            StringBuilder s=new StringBuilder("http://dcfm.eastmoney.com/em_mutisvcexpandinterface/api/js/get?type=QGQP_LSJGCYD&token=70f12f2f4f091e459a279469fe49eca5&ps=22&filter=(TRADECODE=%27");
            s.append(t);
            s.append("%27)&st=TRADEDATE&sr=-1&callback=jQuery112307965527139220383_1617014060178&_=1617014060179");
            System.out.println(s);
            request.setUrl(s.toString());

            Spider.create(new EastMoneyQuan4())
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
