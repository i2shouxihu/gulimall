package us.codecraft.webmagic.main;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.JsonPathSelector;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

//筛选出22天里最近一天最低的非机构持仓的轻度控盘或中度控盘的股票
public class Guba implements PageProcessor {

    List<String> url2s=new ArrayList<>();

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me()
            .addHeader("Connection","keep-alive")
            .addHeader("Accept","application/json, text/javascript, */*; q=0.01")
            .addHeader("X-Requested-With","XMLHttpRequest")
            .addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36")
            .addHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8")
            .addHeader("Origin","http://guba.eastmoney.com")
            .addHeader("Referer","http://guba.eastmoney.com/list,002176.html")
            .addHeader("Accept-Language","zh-CN,zh;q=0.9")
            .addHeader("Cookie","qgqp_b_id=d4bbe0a712fc86acecce6a7cc2e34fa0; em-quote-version=topspeed; ct=Q8ONbwqtueULoOMz_f61W6J6xx05r_tvS1oUVwLCkJPVMloJfOoD172YP-h6gxgTalYdajbqiEAOrCwnQb4v_wSyZSzhgZczwDf6SuELoPVdG2HjqkA71XrAPHZc3lueYZK4YxAyIt6TvEoW_KhiUnpzqKYJvA-0EiGSzhzXz5s; ut=FobyicMgeV4XKdbUhrvvY3CRSCVj31j0hZc6IU93UzjdVrWEWiyXhOJPKgb8c7r3fmMlpcxFOmSyIZEsikGAo086vWtMEjm5tgupKLv04aHfeW0VVaNZ14VJp2QtvG_xPCbxCTGxRo2GoBbpj4SMz7Q756_rMq1hOtlyooQD91LLh3eKQiAgComBMMKP-42tblUU8RHwFU4yBwXdkheutlRj2UTPtBgTE7D_vrahZ__sbAmKYH9V9bW5rqBmN7wAc7qpsLUgLJt_GAenCigg8Qp6zTeh4naA; pi=2559386167652270%3bu2559386167652270%3b%e5%a4%a7%e6%93%8d%e7%9b%98%e6%89%8b%e5%9b%9e%e5%bf%86%e9%b9%bf%3bDibtZkM9SGyO4v8FN8NpZQdXO3RVWnnhF0wIAxXl%2fy%2fYNMqVXexs6cFNigQdx%2fPze%2bgg343o%2bznxgq3vi94QVqtNCO455ZG%2fkskSSdkx0IN7clf0AxlnZiWR4lQqQKCOoSYMjrA9w7YpghZI9lQS%2bgSHbh2%2bcqYU6Ms80DK4pWvpN2VOXH939dC%2f3CKj8DWJdKdN0cx3%3bxsX30R7E9vff2gz7E49nw7BYf9plmicmcupEu1wE8LRABZXgMTY%2bt2uw57%2bWyNBwoqgyGzIR4X8uPrEJfNTHkhxjxI7MX4uUPhKVwVYAXZCeybMpfl1cdMx2WzKddGyjiNU3cMh2NGkWIkU6dY30u4y0ctO74g%3d%3d; uidal=2559386167652270%e5%a4%a7%e6%93%8d%e7%9b%98%e6%89%8b%e5%9b%9e%e5%bf%86%e9%b9%bf; sid=162435281; vtpst=|; em_hq_fls=js; AUTH_FUND.EASTMONEY.COM_GSJZ=AUTH*TTJJ*TOKEN; emshistory=%5B%22%E5%A4%AA%E9%92%A2%E4%B8%8D%E9%94%88(000825)%22%5D; cowminicookie=true; intellpositionL=1010.67px; rankpromt=1; cowCookie=true; st_si=07090081272600; intellpositionT=855px; st_asi=delete; HAList=a-sh-601218-%u5409%u946B%u79D1%u6280%2Ca-sz-300688-%u521B%u4E1A%u9ED1%u9A6C%2Ca-sz-301060-%u5170%u536B%u533B%u5B66%2Ca-sz-301089-%u62D3%u65B0%u836F%u4E1A%2Ca-sz-002815-%u5D07%u8FBE%u6280%u672F%2Ca-sz-002581-%u672A%u540D%u533B%u836F%2Ca-sz-300318-%u535A%u6656%u521B%u65B0%2Ca-sh-600351-%u4E9A%u5B9D%u836F%u4E1A; st_pvi=72436186479242; st_sp=2021-11-24%2012%3A49%3A29; st_inirUrl=http%3A%2F%2Fquote.eastmoney.com%2Fsh603458.html; st_sn=104; st_psi=20211201164952468-117001314792-1450695157")
            .setCharset("utf-8").setRetryTimes(3).setSleepTime(1000);

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {





        String raw = String.valueOf(new JsonPathSelector("$").selectList(page.getRawText()));
        //System.out.println(raw);
        String jsonArray="{\"data\":"+raw.toString()+"}";
        //System.out.println(jsonArray);
        String sn= String.valueOf(new JsonPathSelector("$.data[0].popular_rank").selectList(jsonArray));
        System.out.println("*******************"+sn+"              ");






    }


    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Request request = new Request();
        request.setMethod(HttpConstant.Method.POST);

        List<String> l = asList(

                "001317","002265","000665","002629","002682","600396","603169","000514","001267","600159","600192","600466","603216","000753","002253","002671","603071","000838","000918","001202","001288","002047","002173","002178","002432","003008","600220","600405","600605","603023","000008","000042","000151","000607","000732","000756","000757","000795","000897","000965","002082","002113","002147","002247","002333","002358","002560","002731","300534","600146","600202","600387","600695","600791","601996","603566","603729","605577","000014","000046","000150","000517","000552","000571","000608","000609","000620","000632","000667","000671","000673","000681","000721","000736","000797","000835","000859","000863","000972","001209","001211","002011","002012","002045","002059","002133","002188","002269","002305","002316","002348","002360","002366","002424","002431","002464","002495","002530","002537","002551","002621","002642","002647","002652","002684","002689","002692","002776","002822","002863","002906","002920","300081","300235","300237","300917","301178","600077","600112","600119","600122","600162","600167","600213","600322","600408","600533","600571","600622","600638","600657","600658","600665","600675","600683","600708","600718","600734","600743","600751","600807","600853","600890","600892","600980","601099","601588","601860","603030","603048","603085","603171","603268","603506","603680","603682","603800","605033","605138","688533"
        );

        for (String t:l){
            StringBuilder s=new StringBuilder("http://guba.eastmoney.com/interface/GetData.aspx");

            //System.out.println(s);
            request.setUrl(s.toString());

            byte[] bytes= ("param=code%3D"+t+"&path=webarticlelist%2Fapi%2Fguba%2Fgubainfo&env=2").getBytes();

            System.out.print(t);
            request.setRequestBody(HttpRequestBody.custom(bytes,"application/x-www-form-urlencoded; charset=UTF-8","UTF-8"));

            Spider.create(new Guba())
                    //从"https://github.com/code4craft"开始抓
                    .addRequest(request)
                    .addPipeline(new FilePipeline("D:/data"))
                    //.addPipeline(new ConsolePipeline())
                    //开启5个线程抓取
                    .thread(20)
                    //启动爬虫
                    .run();



        }
    }
}
