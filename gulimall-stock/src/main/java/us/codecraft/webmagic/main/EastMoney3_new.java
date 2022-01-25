package us.codecraft.webmagic.main;

import java.util.ArrayList;
import java.util.List;

//筛选出非机构持仓的轻度控盘或中度控盘的股票
public class EastMoney3_new {

    public static void main(String[] args) {

        List<String> l=new ArrayList<>();

        String[] ths=
                {
                        "000042","000005","000068","000502","000520","000613","000626","000573","000622","000637","000633","000812","000809","000985","002094","002069","002098","002173","002264","002248","002263","002566","000020","002606","000153","002731","000010","000421","002762","000407","000530","002779","000545","002785","000593","000659","000635","000638","000692","000816","000821","000899","000929","000927","002871","002875","300004","300172","300062","300086","300069","300084","300089","300169","300141","300116","300167","300228","300278","300382","300234","300313","300411","300306","300350","300426","300486","300469","300534","002046","300505","300514","002040","300619","300652","002227","600182","002269","002199","600191","600187","600353","600333","600359","600355","600726","002652","600723","600769","600791","002767","002781","002813","600805","600983","600847","300008","601218","002848","300013","600896","002856","300025","300040","300032","300051","300093","300126","300094","300108","300187","300153","603088","603116","300178","300189","603165","603177","300195","300201","300239","603318","300265","300247","300329","603399","300340","300301","300283","300343","603861","300321","300345","603991","300407","300356","300466","300471","300472","300517","300540","300583","300656","600139","600237","600321","600381","600520","600537","600684","600695","600860","600830","600861","601500","601798","603006","603011","603031","603168","603268","603311","603333","603315","603628","603819","300665","000995","300405","300268","002898","603922","603499","300730","603917","603080","300644","002927","002931","603706","300752","300778","300826","300875","605128","300885","003008","300897","003017","300916","300923","003033","601963","003032","605228","605005","003035","300929","300930","300931","300932","300933","300935","300936","605398","300937","003036","605303","605368","605055","300938","300939","300940","003037","600916","605337","605077","300941","300942","300943","300945","003038","300946","605081","605133","300947","605268","300948","605298","605060","300949","300950","300951","603759","605208","605122","300952","300953","003040","605286","605389","300955","300956","300957","300958","300959","300960","300961","603324","003041","003042","300965","003043"};


        String[] huShi=
                {
                        "600000","600004","600006","600008","600009","600011","600015","600017","600018","600020","600021","600023","600025","600026","600027","600031","600033","600035","600037","600038","600039","600048","600050","600053","600054","600055","600056","600057","600058","600059","600060","600061","600062","600063","600064","600066","600067","600068","600070","600071","600072","600073","600075","600076","600078","600079","600080","600082","600085","600087","600088","600089","600090","600091","600093","600094","600095","600096","600098","600099","600100","600101","600103","600104","600105","600106","600107","600108","600109","600110","600112","600114","600116","600120","600121","600122","600123","600125","600126","600127","600129","600130","600131","600132","600133","600135","600136","600138","600139","600141","600143","600146","600150","600151","600153","600155","600158","600160","600161","600162","600163","600165","600166","600167","600168","600169","600170","600171","600172","600176","600177","600178","600179","600182","600183","600184","600185","600186","600187","600188","600189","600190","600191","600192","600193","600195","600196","600197","600198","600199","600200","600201","600203","600206","600207","600208","600210","600211","600212","600213","600215","600216","600217","600218","600220","600222","600225","600227","600228","600229","600230","600233","600234","600235","600236","600237","600239","600242","600246","600248","600251","600252","600255","600256","600257","600258","600259","600260","600261","600262","600266","600267","600268","600269","600271","600272","600273","600275","600276","600277","600278","600280","600282","600285","600288","600290","600291","600292","600293","600295","600297","600298","600299","600300","600301","600303","600305","600306","600308","600310","600311","600312","600313","600315","600316","600318","600320","600321","600322","600323","600325","600326","600328","600329","600330","600331","600332","600333","600335","600336","600337","600338","600339","600340","600343","600346","600348","600350","600351","600352","600353","600354","600355","600360","600361","600362","600363","600365","600366","600367","600368","600369","600370","600371","600372","600373","600375","600376","600377","600378","600379","600380","600382","600383","600387","600388","600390","600391","600392","600393","600395","600396","600397","600398","600403","600406","600409","600410","600415","600416","600418","600419","600420","600421","600422","600425","600426","600428","600429","600432","600433","600435","600438","600439","600446","600448","600449","600452","600455","600456","600458","600459","600460","600461","600466","600467","600469","600470","600475","600477","600478","600480","600481","600482","600483","600486","600487","600488","600489","600490","600491","600493","600495","600496","600497","600498","600499","600500","600501","600502","600503","600505","600506","600507","600508","600509","600510","600511","600512","600515","600516","600517","600518","600520","600521","600522","600523","600525","600526","600527","600528","600529","600530","600531","600532","600533","600535","600536","600537","600540","600543","600545","600546","600547","600549","600550","600552","600555","600556","600557","600558","600559","600560","600561","600562","600563","600565","600566","600567","600568","600570","600572","600575","600576","600577","600578","600579","600580","600582","600583","600584","600585","600586","600587","600588","600590","600592","600593","600594","600595","600596","600597","600598","600600","600601","600604","600606","600609","600610","600611","600613","600615","600616","600617","600618","600619","600621","600622","600623","600624","600629","600635","600637","600640","600641","600642","600643","600645","600648","600649","600651","600652","600653","600654","600655","600656","600657","600660","600662","600664","600665","600666","600667","600668","600673","600674","600676","600678","600679","600680","600681","600682","600684","600685","600686","600688","600689","600690","600691","600693","600695","600696","600698","600699","600703","600704","600705","600707","600708","600710","600711","600713","600714","600715","600716","600717","600718","600719","600720","600721","600722","600723","600724","600725","600726","600727","600728","600729","600730","600731","600732","600734","600735","600736","600737","600738","600739","600740","600741","600742","600743","600744","600745","600746","600748","600750","600751","600753","600754","600755","600757","600758","600759","600760","600761","600764","600765","600766","600767","600769","600770","600771","600773","600775","600776","600779","600780","600782","600783","600784","600787","600789","600790","600791","600792","600793","600794","600795","600797","600798","600800","600801","600802","600803","600804","600805","600806","600807","600808","600810","600811","600812","600815","600816","600817","600818","600820","600821","600822","600823","600824","600825","600826","600827","600831","600832","600835","600836","600837","600838","600839","600843","600844","600845","600846","600848","600850","600851","600854","600856","600857","600858","600859","600860","600861","600862","600863","600864","600865","600866","600867","600868","600870","600871","600872","600873","600874","600875","600877","600879","600880","600881","600882","600884","600885","600886","600888","600890","600893","600894","600895","600896","600897","600898","600900","600901","600903","600908","600909","600916","600917","600918","600926","600928","600958","600959","600960","600961","600963","600966","600967","600968","600970","600971","600973","600975","600976","600977","600979","600980","600981","600982","600983","600984","600985","600986","600987","600988","600989","600990","600992","600993","600995","600997","600999","601000","601001","601002","601003","601006","601008","601009","601010","601011","601015","601016","601018","601020","601021","601028","601038","601058","601066","601068","601069","601077","601086","601088","601100","601101","601106","601108","601111","601117","601118","601126","601128","601137","601138","601139","601155","601158","601162","601163","601168","601179","601186","601187","601198","601199","601200","601208","601212","601216","601218","601222","601225","601226","601228","601229","601231","601233","601236","601238","601268","601298","601311","601319","601326","601330","601333","601336","601339","601360","601366","601369","601375","601377","601388","601399","601456","601500","601512","601515","601518","601519","601555","601567","601568","601577","601579","601588","601598","601599","601601","601607","601608","601609","601611","601615","601618","601619","601628","601633","601636","601666","601677","601686","601688","601689","601696","601698","601699","601700","601702","601717","601718","601727","601766","601777","601778","601788","601789","601799","601800","601801","601808","601816","601827","601828","601838","601858","601860","601865","601866","601869","601872","601877","601878","601881","601886","601890","601898","601901","601908","601916","601918","601928","601929","601933","601939","601949","601952","601956","601958","601963","601965","601966","601968","601969","601975","601985","601989","601990","601991","601992","601995","601996","601997","603000","603001","603002","603003","603005","603008","603010","603012","603016","603017","603018","603019","603023","603025","603026","603027","603030","603031","603032","603033","603035","603036","603045","603055","603059","603060","603063","603067","603068","603069","603076","603079","603080","603083","603085","603087","603093","603095","603098","603101","603103","603105","603108","603110","603112","603113","603115","603118","603121","603123","603126","603127","603128","603129","603131","603133","603136","603155","603156","603160","603167","603169","603177","603185","603186","603187","603188","603189","603195","603197","603198","603199","603200","603208","603214","603221","603222","603223","603225","603227","603228","603229","603233","603236","603239","603256","603260","603267","603268","603277","603279","603288","603290","603297","603298","603299","603300","603301","603303","603306","603308","603311","603313","603315","603317","603319","603320","603321","603322","603323","603330","603333","603337","603338","603339","603345","603348","603351","603353","603355","603357","603358","603359","603363","603365","603367","603368","603369","603377","603378","603383","603385","603386","603387","603390","603392","603393","603399","603429","603444","603456","603466","603477","603486","603489","603505","603508","603515","603517","603519","603520","603528","603533","603538","603557","603558","603559","603565","603567","603568","603579","603587","603588","603589","603590","603596","603598","603599","603601","603605","603606","603607","603610","603612","603613","603617","603619","603629","603630","603636","603638","603639","603650","603655","603656","603658","603659","603660","603662","603666","603669","603678","603679","603680","603681","603682","603686","603688","603690","603693","603697","603698","603700","603703","603707","603708","603709","603712","603713","603716","603717","603718","603719","603722","603730","603733","603737","603738","603757","603758","603766","603773","603776","603777","603778","603779","603786","603789","603799","603801","603806","603808","603811","603816","603818","603819","603823","603825","603826","603828","603829","603833","603839","603843","603855","603858","603866","603869","603876","603878","603881","603882","603883","603885","603888","603890","603893","603895","603896","603899","603906","603915","603916","603918","603919","603927","603931","603936","603937","603938","603939","603959","603966","603969","603976","603977","603979","603982","603983","603985","603986","603987","603988","603989","603990","603991","603995","603997","603998","605003","605005","605006","605007","605008","605009","605018","605050","605055","605066","605068","605077","605081","605099","605108","605111","605116","605122","605123","605128","605133","605136","605151","605155","605158","605166","605168","605169","605177","605178","605179","605186","605188","605199","605208","605228","605255","605258","605266","605268","605277","605286","605298","605299","605303","605318","605337","605338","605358","605366","605368","605369","605376","605377","605388","605389","605398","605500"};


        String[] shenShi=
                {
                        "000005","000006","000007","000008","000009","000010","000011","000012","000014","000016","000019","000020","000021","000023","000025","000026","000027","000028","000029","000030","000031","000032","000033","000034","000035","000036","000037","000038","000039","000040","000045","000046","000048","000049","000050","000055","000061","000062","000063","000065","000066","000068","000070","000078","000088","000089","000090","000099","000150","000151","000153","000155","000156","000157","000158","000159","000333","000338","000400","000401","000402","000403","000404","000407","000409","000410","000411","000413","000415","000416","000417","000418","000419","000420","000421","000423","000425","000426","000428","000429","000430","000488","000501","000503","000504","000505","000506","000507","000509","000510","000511","000513","000514","000516","000517","000518","000519","000520","000521","000523","000524","000525","000526","000528","000529","000530","000531","000532","000533","000534","000536","000537","000538","000539","000540","000541","000543","000544","000545","000546","000547","000548","000550","000551","000554","000555","000557","000558","000559","000561","000563","000564","000565","000566","000570","000571","000573","000576","000581","000582","000584","000585","000586","000587","000589","000591","000592","000593","000595","000596","000597","000598","000599","000600","000601","000603","000605","000606","000607","000608","000609","000610","000611","000612","000613","000615","000616","000617","000619","000620","000622","000623","000625","000626","000627","000628","000631","000632","000633","000635","000636","000637","000639","000651","000652","000655","000656","000657","000659","000663","000665","000666","000668","000669","000671","000672","000673","000676","000677","000678","000680","000681","000682","000685","000686","000687","000688","000690","000691","000692","000695","000697","000698","000700","000701","000702","000703","000705","000707","000708","000710","000711","000712","000713","000715","000716","000718","000719","000720","000721","000722","000726","000727","000729","000731","000732","000733","000735","000736","000737","000738","000739","000748","000751","000753","000755","000756","000757","000758","000759","000762","000766","000767","000768","000777","000782","000783","000785","000786","000788","000789","000790","000791","000795","000796","000797","000798","000800","000801","000802","000803","000806","000810","000811","000812","000813","000815","000816","000820","000821","000822","000823","000826","000828","000829","000830","000831","000836","000837","000838","000839","000848","000850","000851","000852","000859","000860","000863","000868","000869","000875","000876","000877","000878","000880","000881","000882","000883","000885","000886","000887","000889","000890","000892","000893","000895","000897","000898","000899","000900","000901","000902","000903","000905","000906","000908","000909","000910","000911","000912","000913","000915","000916","000917","000918","000919","000921","000922","000923","000925","000926","000927","000928","000930","000931","000935","000936","000937","000938","000948","000949","000950","000951","000952","000953","000955","000957","000958","000959","000961","000962","000965","000967","000968","000969","000970","000971","000972","000973","000975","000976","000977","000978","000980","000981","000985","000987","000988","000989","000990","000993","000995","000996","000997","000998","000999","001696","001872","001896","001914","001965","001979","002001","002002","002003","002004","002006","002008","002009","002010","002011","002012","002013","002014","002015","002017","002019","002020","002021","002022","002023","002024","002025","002026","002028","002029","002030","002031","002032","002033","002034","002035","002036","002037","002038","002039","002040","002041","002043","002045","002046","002047","002048","002049","002050","002051","002054","002055","002056","002057","002058","002059","002060","002061","002062","002063","002064","002065","002066","002067","002068","002069","002072","002073","002075","002076","002077","002078","002079","002080","002081","002082","002083","002084","002085","002086","002087","002088","002089","002090","002091","002093","002094","002095","002096","002097","002100","002102","002103","002104","002105","002106","002107","002108","002109","002111","002112","002113","002114","002115","002117","002118","002119","002120","002121","002122","002123","002124","002125","002126","002127","002128","002130","002131","002132","002133","002135","002136","002137","002138","002139","002140","002141","002142","002145","002146","002147","002148","002149","002151","002152","002153","002154","002155","002156","002157","002158","002160","002162","002163","002164","002165","002166","002167","002168","002169","002170","002171","002172","002173","002174","002175","002177","002178","002179","002180","002182","002183","002184","002185","002186","002188","002189","002190","002191","002194","002196","002197","002198","002200","002201","002202","002203","002204","002205","002206","002207","002208","002209","002210","002213","002214","002215","002216","002217","002218","002219","002221","002222","002223","002225","002226","002227","002228","002229","002232","002233","002234","002235","002237","002239","002241","002242","002243","002244","002245","002246","002247","002248","002249","002250","002251","002252","002253","002254","002255","002256","002258","002259","002261","002262","002263","002265","002266","002267","002268","002269","002270","002271","002272","002273","002274","002275","002276","002277","002278","002279","002280","002281","002282","002283","002284","002286","002287","002288","002289","002290","002291","002292","002293","002294","002297","002298","002299","002300","002301","002302","002303","002304","002305","002306","002307","002308","002309","002310","002311","002312","002313","002314","002315","002316","002317","002318","002319","002320","002321","002322","002323","002324","002325","002326","002327","002328","002331","002332","002333","002334","002335","002337","002338","002339","002340","002341","002342","002343","002344","002345","002346","002348","002349","002350","002351","002352","002353","002354","002355","002356","002357","002358","002360","002361","002362","002363","002364","002365","002366","002367","002368","002369","002370","002371","002372","002373","002374","002375","002376","002377","002378","002379","002380","002381","002382","002383","002384","002385","002386","002387","002389","002390","002391","002392","002394","002395","002396","002397","002398","002399","002400","002401","002402","002404","002405","002407","002408","002409","002410","002411","002412","002413","002414","002416","002417","002418","002419","002420","002421","002422","002423","002424","002425","002426","002427","002428","002429","002430","002431","002432","002433","002434","002435","002436","002437","002438","002439","002440","002441","002442","002443","002444","002445","002446","002447","002448","002449","002451","002452","002453","002455","002456","002457","002458","002459","002461","002462","002463","002464","002465","002467","002468","002469","002470","002471","002473","002474","002475","002476","002478","002479","002480","002481","002482","002483","002484","002485","002486","002487","002488","002489","002490","002491","002492","002494","002495","002496","002497","002498","002500","002501","002503","002504","002505","002506","002507","002508","002510","002511","002512","002513","002514","002515","002516","002517","002518","002519","002520","002521","002522","002523","002524","002526","002529","002530","002531","002532","002533","002534","002536","002537","002538","002539","002540","002541","002542","002543","002544","002545","002546","002547","002548","002549","002551","002552","002553","002554","002555","002556","002557","002558","002559","002560","002561","002562","002563","002564","002565","002566","002567","002568","002569","002570","002571","002572","002573","002574","002575","002576","002577","002578","002579","002580","002581","002582","002583","002584","002585","002586","002587","002588","002589","002590","002593","002595","002596","002597","002598","002600","002601","002602","002603","002605","002606","002607","002608","002609","002611","002612","002613","002614","002615","002616","002617","002620","002621","002622","002623","002625","002626","002627","002628","002629","002630","002632","002635","002636","002637","002638","002640","002641","002642","002643","002644","002645","002646","002647","002648","002649","002650","002651","002652","002653","002654","002655","002656","002657","002658","002659","002660","002661","002662","002663","002664","002665","002666","002667","002668","002669","002670","002671","002672","002673","002674","002675","002676","002677","002679","002680","002681","002682","002683","002684","002685","002686","002687","002688","002689","002690","002691","002693","002694","002696","002697","002698","002699","002700","002701","002702","002703","002705","002706","002707","002708","002709","002712","002715","002716","002717","002719","002721","002722","002724","002725","002726","002727","002729","002730","002731","002732","002733","002734","002735","002736","002737","002738","002739","002740","002741","002742","002743","002745","002746","002747","002748","002749","002750","002751","002752","002753","002755","002756","002758","002759","002760","002761","002763","002765","002766","002767","002768","002769","002770","002771","002772","002773","002774","002775","002777","002778","002779","002781","002782","002783","002785","002786","002787","002788","002789","002791","002795","002796","002797","002798","002799","002800","002801","002803","002805","002807","002808","002810","002812","002813","002815","002816","002817","002819","002820","002822","002823","002825","002826","002827","002828","002829","002830","002831","002832","002833","002836","002837","002838","002839","002840","002841","002842","002843","002845","002846","002847","002849","002851","002852","002853","002857","002858","002859","002860","002862","002863","002864","002865","002866","002867","002868","002869","002870","002872","002873","002875","002876","002878","002880","002882","002883","002884","002885","002886","002887","002890","002891","002893","002895","002896","002897","002900","002901","002902","002903","002905","002906","002907","002908","002909","002910","002911","002912","002913","002915","002916","002918","002919","002920","002921","002922","002923","002925","002926","002928","002929","002930","002932","002933","002935","002936","002938","002939","002940","002941","002945","002946","002948","002949","002950","002953","002955","002956","002957","002959","002960","002961","002962","002965","002966","002967","002968","002970","002971","002972","002975","002977","002978","002979","002980","002982","002984","002985","002986","002987","002988","002989","002990","002991","002992","002993","002995","002996","002997","002998","002999","003000","003001","003002","003003","003004","003005","003006","003007","003008","003009","003010","003011","003012","003015","003017","003018","003019","003020","003021","003022","003023","003025","003026","003027","003028","003029","003030","003031","003032","003035","003037","003038","003816"};



        String[] chuangYeBan=
                {
                        "300001","300002","300003","300004","300005","300006","300007","300008","300009","300010","300011","300012","300013","300015","300016","300017","300018","300019","300020","300021","300022","300023","300024","300025","300026","300027","300029","300030","300031","300032","300033","300034","300035","300036","300037","300038","300039","300040","300041","300042","300043","300044","300045","300046","300047","300048","300050","300051","300052","300053","300054","300055","300057","300058","300061","300062","300063","300064","300065","300066","300067","300068","300070","300071","300072","300073","300075","300077","300078","300079","300080","300081","300082","300083","300084","300085","300086","300087","300088","300089","300091","300092","300093","300094","300095","300096","300097","300098","300099","300100","300101","300102","300103","300105","300106","300107","300108","300109","300110","300111","300112","300113","300114","300115","300116","300117","300118","300119","300120","300121","300123","300124","300125","300126","300127","300128","300129","300130","300131","300132","300133","300134","300135","300136","300137","300138","300139","300140","300141","300143","300144","300145","300146","300147","300148","300149","300151","300152","300153","300154","300155","300157","300158","300159","300160","300161","300163","300164","300165","300166","300168","300169","300170","300171","300172","300173","300174","300175","300177","300178","300179","300180","300181","300182","300183","300184","300185","300187","300188","300189","300190","300191","300192","300193","300194","300196","300197","300198","300199","300200","300201","300202","300203","300204","300205","300206","300207","300208","300209","300210","300211","300212","300213","300214","300215","300216","300217","300218","300219","300221","300222","300223","300224","300225","300226","300227","300228","300229","300230","300231","300232","300233","300234","300235","300236","300237","300238","300239","300240","300241","300242","300243","300244","300245","300246","300247","300248","300249","300250","300251","300252","300253","300254","300255","300256","300257","300258","300259","300260","300261","300262","300263","300265","300266","300267","300268","300269","300272","300273","300275","300276","300277","300278","300279","300280","300281","300282","300283","300284","300285","300286","300287","300290","300291","300292","300293","300295","300296","300297","300298","300299","300300","300301","300303","300304","300305","300307","300308","300309","300310","300311","300312","300313","300314","300315","300316","300317","300318","300319","300320","300321","300322","300323","300324","300325","300326","300327","300328","300330","300331","300332","300333","300335","300336","300337","300338","300339","300340","300341","300342","300343","300344","300345","300346","300347","300348","300349","300350","300352","300353","300354","300355","300356","300357","300358","300359","300360","300363","300364","300365","300366","300367","300368","300369","300370","300371","300372","300373","300374","300375","300376","300377","300378","300379","300380","300381","300382","300383","300384","300385","300386","300388","300389","300391","300392","300393","300394","300395","300396","300397","300398","300399","300400","300401","300402","300403","300404","300405","300406","300408","300409","300410","300411","300412","300413","300415","300416","300417","300418","300419","300420","300421","300422","300423","300424","300425","300426","300427","300428","300429","300432","300433","300434","300435","300436","300438","300439","300440","300441","300442","300443","300444","300446","300447","300448","300449","300450","300451","300452","300453","300454","300455","300456","300457","300458","300459","300460","300461","300463","300464","300465","300467","300468","300469","300470","300471","300472","300473","300474","300475","300476","300477","300480","300481","300482","300483","300484","300485","300486","300487","300489","300492","300493","300494","300495","300496","300497","300498","300499","300500","300502","300503","300505","300506","300507","300510","300511","300513","300516","300517","300518","300520","300521","300522","300523","300525","300526","300527","300528","300529","300530","300531","300533","300534","300535","300536","300537","300540","300541","300542","300543","300545","300546","300547","300548","300549","300551","300552","300553","300555","300557","300558","300559","300560","300561","300563","300565","300566","300567","300568","300569","300570","300572","300573","300575","300576","300577","300578","300579","300581","300582","300584","300585","300586","300587","300588","300589","300590","300591","300592","300593","300594","300595","300596","300598","300599","300600","300601","300602","300603","300604","300606","300607","300608","300610","300611","300612","300613","300616","300617","300618","300620","300622","300623","300624","300625","300626","300627","300628","300629","300630","300631","300632","300633","300636","300637","300638","300639","300641","300642","300643","300644","300645","300647","300648","300650","300651","300653","300654","300655","300656","300657","300658","300660","300661","300662","300663","300664","300665","300666","300667","300669","300670","300671","300672","300673","300674","300675","300676","300678","300679","300680","300681","300682","300683","300684","300685","300686","300687","300689","300690","300691","300692","300693","300694","300695","300696","300697","300698","300699","300700","300701","300702","300703","300705","300707","300708","300709","300710","300711","300712","300713","300715","300717","300718","300721","300722","300723","300724","300726","300727","300729","300731","300733","300735","300737","300738","300739","300740","300741","300742","300747","300748","300751","300752","300753","300755","300757","300758","300761","300762","300763","300765","300766","300767","300768","300769","300770","300771","300772","300773","300775","300776","300777","300779","300780","300781","300783","300786","300787","300790","300791","300792","300795","300797","300798","300799","300800","300801","300802","300803","300806","300807","300809","300811","300812","300813","300815","300816","300818","300819","300820","300821","300822","300823","300824","300825","300826","300827","300828","300829","300830","300831","300832","300835","300836","300837","300839","300840","300841","300842","300843","300845","300846","300847","300848","300849","300850","300852","300853","300855","300856","300857","300858","300859","300860","300861","300862","300863","300864","300865","300866","300867","300868","300869","300870","300871","300872","300873","300875","300876","300877","300878","300879","300880","300881","300882","300883","300884","300885","300886","300887","300888","300889","300890","300891","300892","300893","300894","300895","300897","300898","300899","300900","300901","300902","300903","300906","300907","300908","300909","300910","300911","300912","300913","300915","300916","300917","300918","300919","300920","300921","300922","300923","300925","300926","300927","300928","300929","300930","300931","300932","300933","300935","300936","300937","300938","300939","300940","300941","300942","300943","300945","300946","300947","300948","300949","300950","300951","300952","300953","300955","300956","300957","300958","300959","300960","300961","300965"};






        for (int i = 0; i < huShi.length; i++) {
            for (int j = 0; j < ths.length; j++) {
                if (huShi[i]==ths[j]){
                    System.out.println(huShi[i]);
                    l.add(huShi[i]);
                }
            }
        }

        for (int i = 0; i < shenShi.length; i++) {
            for (int j = 0; j < ths.length; j++) {
                if (shenShi[i]==ths[j]){
                    System.out.println(shenShi[i]);
                    l.add(shenShi[i]);
                }
            }
        }


        for (int i = 0; i < chuangYeBan.length; i++) {
            for (int j = 0; j < ths.length; j++) {
                if (chuangYeBan[i]==ths[j]){
                    System.out.println(chuangYeBan[i]);
                    l.add(chuangYeBan[i]);
                }
            }
        }

        System.out.println(l);

        for (String t:l){
            System.out.print("\""+t+"\",");
        }

//        for (String t:l){
//            StringBuilder stringBuilder=new StringBuilder("http://data.eastmoney.com/stockcomment/stock/");
//            stringBuilder.append(t);
//            stringBuilder.append(".html#zlkp");
//            System.out.println(stringBuilder);
//        }









    }


}
