package com.example.yazlmrenmeatlas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerView1: RecyclerView
    private lateinit var recyclerView2: RecyclerView
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView1 = findViewById(R.id.recyclerView1)
        recyclerView2 = findViewById(R.id.recyclerView2)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView1.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView2.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val productList = listOf(
            Product(R.drawable.flutter, "Flutter","Flutter, Google tarafından geliştirilen ve desteklenen bir açık kaynak çerçevedir. Ön uç ve tam yığın geliştiriciler, bir uygulamanın kullanıcı arabirimini tek bir kod tabanıyla birden fazla platform için derlemek üzere Flutter'ı kullanır.\n" +
                    "\n" +
                    "Flutter, 2018 yılında kullanıma sunulduğunda esasen mobil uygulama geliştirmeyi destekliyordu. Flutter artık altı platformda uygulama geliştirmeyi desteklemektedir: iOS, Android, web, Windows, MacOS ve Linux.\n" +
                    "Flutter, desteklediği altı platform genelinde bir uygulama için tutarlı ve cazip kullanıcı arabirimleri oluşturma sürecini basitleştirir.\n" +
                    "\n" +
                    "Flutter, platformlar arası bir geliştirme çerçevesi olduğundan, öncelikle yerel geliştirme ile karşılaştıracağız. Ardından, Flutter'ın benzersiz özelliklerini vurgulayabiliriz.\n" +
                    "\n" +
                    "Platformlar arası uygulama geliştirmeye kıyasla yerel uygulama geliştirme\n" +
                    "iOS gibi tek bir belirli platform için bir uygulama kodu geliştirme süreci, yerel uygulama geliştirme olarak adlandırılır. Buna karşın, platformlar arası uygulama geliştirme tek bir kod tabanı içeren birden çok platform için bir uygulama oluşturma sürecidir.\n" +
                    "\n" +
                    "Yerel uygulama geliştirme\n" +
                    "Geliştiriciler yerel uygulama geliştirmede belirli bir platform için kod ürettiğinden, yerel cihaz işlevselliğine tam erişimleri bulunur. Bu genellikle, platformlar arası uygulama geliştirmeye kıyasla daha yüksek performans ve hıza imkan tanır.\n" +
                    "\n" +
                    "Öte yandan, birden fazla platformda bir uygulama başlatmak istiyorsanız yerel uygulama geliştirme daha fazla kod ve daha fazla geliştirici gerektirir. Bu harcamalara ek olarak, yerel uygulama geliştirme, tutarlı bir kullanıcı deneyimiyle aynı anda farklı platformlarda lansmanı daha zor bir hale getirir. Bu, Flutter gibi platformlar arası uygulama geliştirme çerçevelerinin kullanışlı olduğu bir noktadır.\n" +
                    "\n" +
                    "Platformlar arası uygulama geliştirme\n" +
                    "Platformlar arası uygulama geliştirme, geliştiricilerin birden çok platform için bir uygulama oluşturmak üzere bir programlama dili ve bir kod tabanı kullanmasına imkan tanır. Birden çok platform için bir uygulama yayınlıyorsanız platformlar arası uygulama geliştirme, yerel uygulama geliştirmeye kıyasla daha düşük maliyetlidir ve daha az zaman alır.\n" +
                    "\n" +
                    "Bu süreç ayrıca, geliştiricilerin kullanıcılar için platformlar arasında daha tutarlı bir deneyim oluşturmasını sağlar.\n" +
                    "\n" +
                    "Bu yaklaşım, yerel uygulama geliştirmeye kıyasla, yerel cihaz işlevselliğine sınırlı erişim de dahil bazı dezavantajlar içerebilir. Ancak, Flutter platformlar arası uygulama geliştirmeyi daha pürüzsüz ve yüksek performanslı hale getirecek özelliklere sahiptir.\n" +
                    "\n" +
                    "Flutter'ın avantajları\n" +
                    "Flutter'ın platformlar arası bir geliştirme çerçevesi olarak öne çıktığı bazı yönler aşağıdaki gibidir:\n" +
                    "\n" +
                    "Yerele yakın performans. Flutter, Dart programlama dilini kullanır ve makine koduna derler. Ana sunucu cihazları, hızlı ve etkili bir performans sağlayan bu kodu anlar.\n" +
                    "Hızlı, tutarlı ve özelleştirilebilir işleme. Platforma özgü işleme araçlarına güvenmek yerine Flutter, kullanıcı arabirimi oluşturmak için Google'ın açık kaynak Skia grafik kitaplığını kullanır. Bu, bir uygulamaya erişmek için hangi platformu kullanırlarsa kullansınlar kullanıcılara tutarlı görseller sunar. \n" +
                    "Geliştirici dostu araçlar. Google, Flutter'ı kullanım kolaylığına öncelik vererek tasarladı. Hot reload gibi araçlarla, geliştiriciler mevcut durumu kaybetmeden kod değişikliklerinin nasıl görüneceğine ilişkin önizleme yapabiliyor. Widget inspector gibi diğer araçlar, sorunları kullanıcı arabirimi düzenleriyle görselleştirip çözmeyi kolaylaştırıyor.Flutter hangi programlama dilini kullanır?\n" +
                    "Flutter, yine Google tarafından geliştirilmiş bir açık kaynak programlama dili olan Dart'ı kullanır. Dart, kullanıcı arabirimleri oluşturmak için optimize edilmiştir ve Dart'ın pek çok güçlü yönü Flutter'da kullanılmaktadır.\n" +
                    "\n" +
                    "Örneğin, Flutter'da kullanılan Dart özelliklerinden biri sound null safety'dir. Dart'ın sound null safety özelliği, null hatalar olarak adlandırılan yaygın hataları saptamayı kolaylaştırır. Bu özellik, geliştiricilerin kod bakımı için harcadıkları zamanı azaltarak uygulamalarını oluşturmaya odaklanmak için daha çok zaman ayırmalarını sağlar."),
            Product(R.drawable.java, "Java","Java, web uygulamalarını kodlamada yaygın olarak kullanılan bir programlama dilidir. Yirmi yıldan uzun bir süredir geliştiriciler tarafından tercih edilen popüler bir dil olması nedeniyle günümüzde kullanımda olan milyonlarca Java uygulaması bulunmaktadır. Java çok platformlu, nesne odaklı ve ağ merkezli bir dil olup kendisi de bir platform olarak kullanılabilir. Mobil uygulamalar ve kurumsal yazılımlardan büyük veri uygulamalarına ve sunucu tarafı teknolojilere kadar her türlü yazılımı kodlamada kullanılabilecek hızlı, güvenli ve güvenilir bir programlama dilidir.\n" +
                    "\n" +
                    "Java programlama dili ne için kullanılır?\n" +
                    "Java programlama dili ne için kullanılır? \n" +
                    "Kullanımı ücretsiz ve çok yönlü bir dil olması nedeniyle Java, yerelleştirilmiş ve dağıtılmış yazılımlar oluşturmada kullanılmaktadır. Java'nın yaygın kullanım alanları aşağıdakileri içerir:\n" +
                    "\n" +
                    "1.     Oyun Geliştirme\n" +
                    "Mobil oyunlar ve bilgisayar oyunları dâhil birçok popüler video oyunu Java'da oluşturulmaktadır. Makine öğrenimi veya sanal gerçeklik gibi gelişmiş teknolojilerin kullanıldığı modern oyunlar bile Java teknolojisiyle oluşturulmaktadır.\n" +
                    "\n" +
                    "2.     Bulut bilgi işlem\n" +
                    "Java, WORA [Write Once and Run Anywhere (Bir Kez Yazın ve Her Yerde Çalıştırın)] felsefesine uygun yapısı sayesinde, merkezi olmayan bulut tabanlı uygulamalar için ideal seçimdir. Bulut sağlayıcıları, programlarını çok çeşitli platformlarda çalıştırmak için Java dilini seçmektedir.\n" +
                    "\n" +
                    "3.     Büyük Veri\n" +
                    "Java, karmaşık veri kümeleri ve devasa miktarda gerçek zamanlı veri ile birlikte çalışabilecek veri işleme altyapıları için kullanılır.\n" +
                    "\n" +
                    "4.     Yapay Zekâ\n" +
                    "Java, geniş kapsamlı makine öğrenimi kitaplıkları sunar. Kararlı ve hızlı bir programlama dili olması nedeniyle doğal dil işleme ve derin öğrenme gibi yapay zekâ uygulaması geliştirme çalışmaları için ideal seçimdir.\n" +
                    "\n" +
                    "5.     Nesnelerin İnterneti\n" +
                    "Java, bağımsız olarak internete bağlanabilen uç cihazlardaki sensörleri ve donanımları programlamak için kullanılmaktadır.\n" +
                    "\n" +
                    "Java, modern yazılım geliştiriciler arasında neden bu kadar popüler?\n" +
                    "Java, popülerliğini kullanım kolaylığına borçludur. Geliştiricilerin diğer programlama dilleri yerine Java'yı seçmeye devam etmesinin altında yatan bazı nedenler:\n" +
                    "\n" +
                    "Yüksek kaliteli öğrenme kaynakları\n" +
                    "Java uzun zamandır piyasada, dolayısıyla yeni programcıların başvurabileceği birçok öğrenme kaynağı mevcut. Ayrıntılı belgeler, kapsamlı kitaplar ve kurslar, tüm öğrenme eğrisi boyunca geliştiricilere destek olmaktadır. Ek olarak, yeni başlayanlar Advanced Java'ya geçmeden önce Core Java'da kod yazarak işe başlayabilir.\n" +
                    "\n" +
                    "Entegre fonksiyonlar ve kitaplıklar\n" +
                    "Geliştiriciler Java'yı kullanırken her yeni fonksiyonu sıfırdan yazmak zorunda kalmaz. Çok çeşitli uygulamalar geliştirmek için Java'nın sunduğu zengin entegre fonksiyon ve kitaplık ekosisteminden yararlanabilirler. \n" +
                    "\n" +
                    "Etkin topluluk desteği\n" +
                    "Java çok sayıda etkin kullanıcının yanı sıra kodlama sırasında zorlukla karşılaşan geliştiricilere destek olabilecek bir topluluğa sahiptir. Ayrıca, Java platform yazılımının bakım ve güncellemeleri düzenli olarak yapılmaktadır.\n" +
                    "\n" +
                    "Yüksek kaliteli geliştirme araçları\n" +
                    "Java otomatik düzenleme, hata ayıklama, test, dağıtım ve değişiklik yönetimi süreçlerini destekleyen çeşitli araçlar sunmaktadır. Bu araçlar Java ile programlamayı hem zaman hem de maliyet açısından verimli kılmaktadır.\n" +
                    "\n" +
                    "Platformdan Bağımsız\n" +
                    "Java kodu, yeniden yazma gerekmeksizin Windows, Linux, iOS veya Android gibi altta yatan herhangi bir platformda çalışabilir. Bu durum Java'yı, uygulamaların birden çok cihazda çalışabilmesi istenilen günümüz ortamında özellikle güçlü kılmaktadır.\n" +
                    "\n" +
                    "Güvenlik\n" +
                    "Kullanıcılar güvenilmeyen Java kodunu ağ üzerinden indirebilir ve zarara yol açamayacağı güvenli bir ortamda çalıştırabilir. Güvenilmeyen kod bir virüs yoluyla ana sisteme bulaşamaz ya da sabit diskte dosyaları okuyamaz veya dosya oluşturamaz. Java'daki güvenlik düzeyleri ve kısıtlamaları da son derece yapılandırılabilir niteliktedir."),
            Product(R.drawable.kotlin, "Kotlin","Kotlin, Java sanal makinesi (JVM) üzerinde çalışan ve ayrıca JavaScript kaynak koduna derlenebilir, statik tipli bir programlama dilidir. İlk geliştirme Sankt-Peterburg, Rusya merkezli JetBrains programcıları tarafından yapılmıştır.[1] İsmi Kotlin Adası'ndan gelmektedir. Java ile uyumlu sözdizimi olmasa da, Kotlin Java kodu ile birlikte çalışmak üzere tasarlanmıştır. Kotlin, Apple'ın Swift diline benzemektedir.[2]|\n" +
                    "JetBrains şirketi tarafından statik olarak yazılmış, modern bir programlama olan Kotlin, Google tarafından 2017 yılında resmi olarak kabul edilmiştir. Java ile tamamen uyumlu çalışacak şekilde tasarlanmıştır. Java’dan daha iyi kod yazabilen ve güvenliği sorunsuz olan bir programlama dili tasarlamak isteyen mühendisler, Kotlin’i tasarlamıştır. \n" +
                    "\n" +
                    "Kotlin, kodları daha güvenli ve daha az kod satırı yazacak şekilde tasarlanmış bir programlama dili olarak da bilinir. Kotlin, Java ile birlikte çalışır ve bu sebeple birbiri ile kıyaslanması doğru bulunmaz. \n" +
                    "\n" +
                    "Kotlin Dilinin Özellikleri\n" +
                    "Kotlin, Apache 2.0 lisansı altında geliştirilmiş, ücretsiz ve açık kaynak kod yapısına sahip bir programlama dilidir.\n" +
                    "JavaScript kodları ile birlikte çalışabilir. HTML sayfalarında da kullanılabilir.\n" +
                    "Kotlin, Android ve Java ile kusursuz çalışabilir. Hatta Java ile Kotlin, birbirini tamamlayan iki kodlama dili olarak da bilinir.\n" +
                    "Kotlin, Java’ya göre çok daha kısa ve özgün bir biçimde kodlama yapar. Sadeliği ve özgünlüğü sayesinde birçok yazılımcı tarafından tercih edilir.\n" +
                    "Unix/Linux ve Perl script stilinde diziye ekleme yapma olanağı sunar.\n" +
                    "Kotlin, özellikle Java’ya oranla çok daha güvenilir bir program dilidir. Sektörün en büyük korkulu rüyası olan null uyarısı olarak bilinir. Kotlin ile null uyarısı alınması neredeyse imkansız bir hale gelmiştir.\n" +
                    "Kotlin, sunucu ve istemci tabanlı web uygulamalarını destekler ve geliştirilmesine olanak tanır.\n" +
                    "Kotlin, nesne yönelimli ve obje odaklı bir programlama dilidir. \n" +
                    "Kotlin Nerede Kullanılır?\n" +
                    "Kotlin, kullanım alanının genişliği ile bilinir. Fakat en çok Android uygulamalarının geliştirilmesinde kullanılır. Bunun yanı sıra sunucu ve istemci taraflı geliştirmelerde de sıklıkla kullanılır. \n" +
                    "\n" +
                    "Google’ın açık bir şekilde desteğini de alan Kotlin, son yıllarda en popüler yazılım dillerinden biri olarak kabul edilir. Öğrenmesi diğer yazılım dillerine oranla çok daha kısa sürede olur ve daha kolaydır. Bu sayede de popüler hale gelmiştir ve birçok alanda güvenle kullanılır. \n" +
                    "\n" +
                    "Dünyaca bilinen ve son derece popüler olan birçok büyük şirket de Kotlin programlama dilini kullanmaktadır. Netflix, Uber, Trello, Google, Tinder, Airbnb, Slack, Corda, Pinterest bunlardan yalnızca birkaçıdır.\n" +
                    "\n" +
                    "Kotlin Avantajları\n" +
                    "Kotlin, son derece kolay anlaşılabilir ve insan diline yatkın bir dile sahiptir. Bu sayede de çok kısa süre içerisinde öğrenme imkanı sunar.\n" +
                    "Java programlama diline oranla çok daha güvenilir şartlar sunar.\n" +
                    "Swift dili ile çok benzer yapıya sahiptir.\n" +
                    "Kotlin, çok daha az kod satırı ile çok daha kısa sürede gerçekleşmesi istenen eylemleri gerçekleştirme olanağı sunar.\n" +
                    "Google tarafından geleceğin programlama dili olarak tanımlanır.\n" +
                    "Android işletim sistemli cihazlar ile entegre çalışır ve uygulamalar geliştirilmesini sağlar.\n" +
                    "Kısa, düzenli ve anlaşılabilir bir kod dizilimine sahiptir."),
            Product(R.drawable.swift, "iOS","Swift; iOS, Mac, Apple TV ve Apple Watch uygulamaları geliştirmek için Apple tarafından oluşturulmuş güçlü ve kullanıcı dostu bir programlama dili. Geliştiricilere, her zamankinden daha fazla özgürlük sağlamak için tasarlandı. Swift, kullanımı kolay ve açık kaynaklı bir dil. Bu yüzden, bir fikri olan herkes, şimdi inanılmaz şeyler yaratabilir.\n" +
                    "\n" +
                    "Geliştiriciler, Swift ile\n" +
                    "olağanüstü şeyler yapıyorlar.\n" +
                    "Swift, gerçek zamanlı geri bildirim sağlayan ve mevcut Objective-C koduna sorunsuz bir şekilde entegre edilebilen hızlı ve verimli bir dil. Böylece, geliştiriciler sadece daha güvenli ve güvenilir kodlar yazmakla kalmıyor, aynı zamanda zamandan tasarruf edebiliyor ve daha zengin bir uygulama deneyimi yaratabiliyorlar.\n" +
                    "\n" +
                    "Swift ile geliştirilen muhteşem bir uygulama. VSCO, Swift’in kullanım kolaylığı\nSwift’le Neler Yapılabilir?\n" +
                    "Apple muhteşem taktiğini Swift programlama dilinde de kullanmıştır. Yani Swift dili ile yalnızca Apple uygulamaları geliştirilebiliyor. Swift diliyle, macOS, tvOS, iPadOS, watchOS ve iOS için, uygulama geliştirilebilir.\n" +
                    "\n" +
                    "Swift’in temellerinde açık kaynak kod olduğu için, açık kaynak kodlu işletim sistemleri çekirdeklerinde de çalışabiliyor. Yani Linux işletim sistemi için Swift dilini kullanarak uygulama geliştirilebilir. Yine de unutmamak gerekiyor ki Swift dilinin geliştirilmesinin sebebi Apple ürünleri içindir. Her ne kadar Linux için de uygun olsa da asıl var oluş sebebi Apple uygulamalarını geliştirmektir.\n" +
                    "\n" +
                    "swift ne ise yarar,\n" +
                    "\n" +
                    "Swift Nereden Öğrenilebilir?\n" +
                    "Swift dilini temelden öğrenmek için, iPad’lerde ücretsiz olarak bulunan Swift Playgrounds uygulaması geliştirildi. Aslında bu uygulama çocuklar için yapılmış olsa da 0’dan başlayanlar için de keyifli bir öğrenim sağlayabilir.\n" +
                    "\n" +
                    "Kendini programlama alanında geliştirmiş programcılar için ise, App Store’da yaklaşık 500 sayfalık kullanma kılavuzu yerine geçen bir e-kitap mevcuttur.\n" +
                    "\n" +
                    "Sadece Apple cihazlarına özel üretilmiş olan , macOS üzerinde çalışan, Xcode adında bir Apple  (IDE) si kullanılıyor.\n" +
                    "\n" +
                    "Swift’in Olumlu Yönleri\n" +
                    "Uygulama geliştirme sürecinin hızlı olması\n" +
                    "Güvenilir bir programlama dili olması\n" +
                    "Otomatik Bellek Sayma özelliğinin bulunması. Diğer dillerde çöp toplayıcıları kullanılmaktadır.\n" +
                    "Swift’in Olumsuz Yönleri\n" +
                    "Yeni bir dil olması.\n" +
                    "Az kullanıcıya sahip olması\n" +
                    "Eski iOS sürümleriyle uyumluluğunun düşük olması.")
        )

        val otherProductList = listOf(
            Product(R.drawable.html, "HTML","Hiper Metin İşaretleme Dili (HTML, İngilizce HyperText Markup Language kelimelerinin baş harflerinin kısaltılmasıdır) web sayfalarını oluşturmak için kullanılan standart metin işaretleme dilidir. Dilin son sürümü HTML5'tir.\n" +
                    "\n" +
                    "HTML, bir programlama dili olarak tanımlanamaz. Zira HTML kodlarıyla kendi başına çalışan bir program yazılamaz. Ancak bu dili yorumlayabilen programlar aracılığıyla çalışabilen programlar yazılabilir. Programlama dili denilememesinin nedeni tam olarak budur. Temel gereği yazı, görüntü, video gibi değişik verileri ve bunları içeren sayfaları birbirine basitçe bağlamak, buna ek olarak söz konusu sayfaların web tarayıcısı yazılımları tarafından düzgün olarak görüntülenmesi için gerekli kuralları belirlemektir. HTML kodunu web tarayıcıları okur, yorumlar ve görsel hale dönüştürürler, dolayısıyla aynı HTML kodunun farklı tarayıcılarda farklı sonuç vermesi olasıdır. CSS ve JavaScript ile beraber kullanıldığında HTML vasıtasıyla görsel ve dinamik web siteleri yaratılabilir.\n" +
                    "\n" +
                    "HTML, küçüktür ve büyüktür işaretleri arasına girilen HTML etiketleri kullanılarak yazılır (ör: <html>). İşaretlenen metnin başını ve sonunu belirtmek için çoğunlukla çift olarak kullanılırlar (Örnek: <h1>Selam</h1>) ancak, işaretlemek yerine metnin bir yerine bir işaret konacaksa tek olarak da kullanılabilirler (Ör: <img>).\n"),
            Product(R.drawable.css, "CSS","CSS, (Cascading Style Sheets) yani, basamaklı stil şablonları anlamına gelmektedir. CSS bir biçimlendirme dilidir. Web site sayfalarını kendi stil kurallarına göre şekillendirebilme olanağı verir.  Kendine özgü kuralları bulunan CSS, javascript ve HTML ile üst düzey web sayfaları hazırlanabilir.\n" +
                    "\n" +
                    "Web tasarım alanında yoğun olarak kullanılan CSS, html kavramından sonra karşınıza çıkan ilk biçimlendirme dilidir. HTML (HyperText Markup Language) ile birlikte entegre şekilde çalışan CSS, oluşturduğunuz web sayfalarında yapacağınız özellikleri geliştirmenize olanak sağlar.\n" +
                    "\n" +
                    "Web sayfalarının renklerini, fontlarını, görsel efektlerini, mizanpajını ve tüm öğeleri CSS stil şablonlarıyla biçimlendirebilirsiniz. Css Nedir Sorunua cevap verdik. Şimdi nasıl yapılır inceleyelim.\n" +
                    "Esnekliği ile ön plana çıkan CSS, web sayfalarının daha kolay tasarlanmasını sağlar. İster tüm sayfalara ister tek bir sayfa üzerinde görsel özellik değiştirme işlemini yapabilirsiniz.\n" +
                    "\n" +
                    "CSS kodlamaları genel olarak iki türde uygulanabilir. Birinci tür direkt olarak HTML kodlarının içerisinde yer alan head bölümüne ya da body bölümüne, yani direkt tag alanının içerisine dahil edilebilir. İkinci tür ise harici bir CSS dosyası oluşturmak ve bu dosyayı HTML dokümanının içerisine yerleştirmektir.\n" +
                    "\n" +
                    "CSS ayrıca 3 farklı şekilde kullanım sunan ve oldukça esnek bir yazılım imkanı sunan bir stil dilidir. Harici stil sayfası, dahili stil sayfası ve etiket biçimlendirme olarak web sayfalarınıza gelişmiş kodlar ekleyebilirsiniz.\n" +
                    "\n" +
                    "Örneğin; harici bir CSS stil sayfası ile dilediğiniz tüm web sayfalarına erişebilir ve düzenleyebilir, tek bir web sayfasına ulaşmak için dahili stil eklemesi yapabilir ya da herhangi bir etiket içine ulaşabilmek için de etiket biçimlendirme yöntemlerini kullanabilirsiniz.\n" +
                    "\n" +
                    "Bunlar; İnternal (iç), External (dış), İnline (satıriçi) olarak adlandırılır. Web sitenizin stil kurallarını belirlemek için her 3 yöntemi de ayrı ayrı kullanabilirsiniz. Tek bir özellik için aynı anda kullanamazsınız. Aynı anda kullandığınızda biri bir diğerini etkisiz bırakacaktır.\n" +
                    "\nCSS Kodları Ne İşe Yarar?  Neler Yapılabilir?\n" +
                    "CSS kodlarıyla sadece biçimlendirme yapılacağı düşünülür. Ancak CSS oldukça geniş bir kullanım alanına sahiptir. HTML, CSS ve JAVASCRİPT birlikte kullanıldığında üst düzey görsel ve estetik web sayfaları tasarlanabilir.\n" +
                    "\n" +
                    "CSS kodları web sayfalarının tüm elemanlarını dilediğiniz özelliklerle şekillendirebilmenize ve özelleştirebilmenize imkan sağlar. Bu da doğrudan sıradan bir web sayfasını özelleştirilmiş bir görünüme ulaştırır.\n" +
                    "\n" +
                    "CSS Kodlama İle Neler Yapılabilir?\n" +
                    "\n" +
                    "Font boyutlandırma.\n" +
                    "Font renklendirme.\n" +
                    "Başlık stilleri.\n" +
                    "Yatay ve dikey menüler.\n" +
                    "Geçiş efektleri.\n" +
                    "Gölgelendirme.\n" +
                    "Kenar süsleri.\n" +
                    "Animasyonlar.\n" +
                    "Sayfa arka plan rengi ya da görseli.\n" +
                    "En Popüler CSS Kütüphaneleri\n" +
                    "CSS kütüphaneleri, CSS Framework olarak isimlendirilir. Son derece gelişmiş bir araç olan CSS Framework, css kodlama işlemlerinizi daha kolay ve daha fonksiyonel uygulamanızı sağlamaktadır.\n" +
                    "\n" +
                    "Genel olarak CSS bilgisine sahip kişilerin ve web geliştiricilerinin en sık kullandığı yöntem kütüphanelerdir. Zamandan tasarruf etmek ve birden çok kişinin aynı proje üzerinde çalışmasını sağlayan CSS framework, açık kaynak kodlu ve birçoğu ücretsiz şekilde servis edilmektedir.\n" +
                    "\n" +
                    "CSS Kütüphaneleri ile birlikte kullanabileceğiniz JavaScript kütüphaneleri ile son derece modern ve fonksiyonel web sayfaları oluşturabilirsiniz.\n" +
                    "\n" +
                    "CSS kütüphanelerinden en popüler olanları ve en sık kullanılanları şunlardır;\n" +
                    "\n" +
                    "Bootstrap\n" +
                    "Bootstrap, çok gelişmiş responsive tasarımlar elde etmenize olanak tanır. Cep telefonundan, diz üstü bilgisayarına kadar her cihaz da profesyonel görünüm sağlamanıza yardımcı olan bir CSS kütüphanesi aracıdır.\n" +
                    "\n" +
                    "Foundation\n" +
                    "Dünyada en yaygın kullanılan CSS kütüphanelerinden birisidir. Duyarlı ve gelişmiş web siteleri tasarlamanıza imkan verir. Oldukça esnek ve özelleştirebilir bir yapısı vardır.\n" +
                    "\n" +
                    "Ulkit\n" +
                    "Web arayüz geliştirmek için kullanılan Ulkit, front-end CSS kütüphanelerinden birisidir. Modüler arayüz ile hızlıca web arayüzleri geliştirilebilir."),
            Product(R.drawable.js, "JavaScript","JavaScript[10] (genellikle JS olarak kısaltılır), HTML ve CSS ile birlikte World Wide Web'in temel teknolojilerinden biri olan programlama dilidir.[11] Web sitelerinin %97'sinden fazlası, web sayfası hareketleri için istemci tarafında JavaScript kullanırlar [12] ve kullanılan kodlar genellikle üçüncü taraf kitaplıkları içerir.[13] Tüm büyük web tarayıcılarında, kaynak kodunu kullanıcıların cihazlarında yürütebilmek için özel bir JavaScript motoru bulunur.\n" +
                    "\n" +
                    "JavaScript, ECMAScript standardına uyan, genellikle eş zamanlı olarak derlenmiş, üst düzey bir dildir.[14] Dinamik yazma, prototip tabanlı obje yönelimi ve birinci sınıf işlevlere sahiptir. Olay odaklı, işlevsel ve zorunlu programlama stillerini destekleyen çoklu paradigmadır. Metin, tarihler, düzenli ifadeler, standart veri yapıları ve Belge Obje Modeli (DOM) ile çalışmak için uygulama programlama arayüzlerine (API'ler) sahiptir.\n" +
                    "\n" +
                    "ECMAScript standardı, ağ oluşturma, depolama veya grafik olanakları gibi herhangi bir giriş/çıkış (I/O) içermez. Pratikte, web tarayıcısı veya diğer çalıştırma ortamları, I/O için JavaScript API'leri sağlarlar.\n" +
                    "\n" +
                    "JavaScript motorları başlangıçta yalnızca web tarayıcılarında kullanılıyordu, ancak günümüzde bazı sunucuların ve çeşitli uygulamaların da temel bileşenleridir. Bu kullanım için en yaygın çalışma zamanı sistemi Node.js'dir.\n" +
                    "\n" +
                    "Java ve JavaScript'in ad, sözdizimi ve ilgili standart kitaplıklar açısından benzerlikleri olsa da, iki dil birbirinden farklıdır ve tasarım açısından da büyük farklılıklar gösterir.\n" +
                    "JavaScript ne için kullanılır?\n" +
                    "Tarihsel olarak web sayfaları bir kitaptaki sayfalara benzer şekilde statikti. Statik bir sayfa bilgileri çoğunlukla sabit bir düzende görüntülüyordu ve şimdi modern bir web sitesinden beklediğimiz her şeyi yapmıyordu. JavaScript, web uygulamalarını daha dinamik hale getirmek için tarayıcı bazlı bir teknoloji olarak ortaya çıktı. Tarayıcılar JavaScript kullanarak kullanıcı etkileşimine yanıt verebilir ve web sayfasındaki içerik düzenini değiştirebilir.\n" +
                    "\n" +
                    "Dil olgunlaştıkça JavaScript geliştiricileri kitaplıklar, çerçeveler ve programlama uygulamaları oluşturdu ve bunları web tarayıcılarının dışında kullanmaya başladı. Bugün JavaScript'i hem istemci tarafı hem de sunucu tarafı geliştirme için kullanabilirsiniz. Aşağıdaki alt bölümlerde bazı yaygın kullanım durumları sunuyoruz:\n" +
                    "\n" +
                    "Tarihsel olarak web sayfaları bir kitaptaki sayfalara benzer şekilde statikti. Statik bir sayfa bilgileri çoğunlukla sabit bir düzende görüntülüyordu ve şimdi modern bir web sitesinden beklediğimiz her şeyi yapmıyordu. JavaScript, web uygulamalarını daha dinamik hale getirmek için tarayıcı bazlı bir teknoloji olarak ortaya çıktı. Tarayıcılar JavaScript kullanarak kullanıcı etkileşimine yanıt verebilir ve web sayfasındaki içerik düzenini değiştirebilir.\n" +
                    "\n" +
                    "Dil olgunlaştıkça JavaScript geliştiricileri kitaplıklar, çerçeveler ve programlama uygulamaları oluşturdu ve bunları web tarayıcılarının dışında kullanmaya başladı. Bugün JavaScript'i hem istemci tarafı hem de sunucu tarafı geliştirme için kullanabilirsiniz. Aşağıdaki alt bölümlerde bazı yaygın kullanım durumları sunuyoruz:"),
            Product(R.drawable.php, "PHP","PHP : Hypertext Preprocessor (Türkçe: Üstünyazı Önişlemcisi [1]) (Aslen: Personal Home Page - Kişisel Ana Sayfa), internet için üretilmiş, sunucu taraflı, çok geniş kullanımlı, genel amaçlı, içerisine HTML gömülebilen betik ve programlama dilidir[1]. İlk kez 1995 yılında Rasmus Lerdorf tarafından yaratılan PHP'nin geliştirilmesi bugün PHP topluluğu tarafından sürdürülmektedir. Ocak 2013 itibarıyla 244 milyondan fazla web sitesi PHP ile çalışırken 2.1 milyon web sunucusunda PHP kurulumu bulunmaktadır.[2]\n" +
                    "\n" +
                    "PHP kodları PHP işleme modülü bulunan bir web sunucusu tarafından yorumlanır ve çıktı olarak web sayfası üretilir. Bu kodlar veriyi işlemek üzere harici bir dosyaya kaydedilerek çağırılabildiği gibi doğrudan HTML kodunun içine de gömülebilir. PHP zaman içinde bir komut satırı arayüzü sunacak şekilde evrilmiştir, PHP-GTK yardımıyla grafiksel masaüstü uygulaması geliştirmek de mümkündür.[3]\n" +
                    "\n" +
                    "PHP özgür bir yazılım olup PHP Lisansı ile dağıtılmaktadır. Bu lisans kullanım şartları kısmında GNU Genel Kamu Lisansı ile örtüşmese de, PHP tüm web sunuculara ve hemen hemen tüm işletim sistemi ve platforma ücretsiz olarak yüklenebilir.[4]")
        )

        val thirdProductList = listOf(
            Product(R.drawable.react, "React","Terimler Sözlüğü\n" +
                    "JavaScript\n" +
                    "Ağu 26, 2022\n" +
                    "\n" +
                    "Gökhan O.\n" +
                    "\n" +
                    "3dk. Okuma Süresi\n" +
                    "\n" +
                    "React Nedir? Nasıl Çalışır?\n" +
                    "React, kullanıcı arayüzü (UI) oluşturmak için kullanılan en popüler JavaScript kütüphanesidir. Web siteleri işlemek için kullanıcı çıktısına harika yanıt sunan bir yöntemi kullanır.\n" +
                    "\n" +
                    "Bu aracın bileşenleri Facebook tarafından geliştirilmiştir. 2013’de açık kaynaklı bir JavaScript olarak piyasaya sürülmüştür. Şu anda, çok satan listesinin en üstünde yer alan Angular ve Bootstrap gibi ana rakiplerinin önündedir.\n" +
                    "\n" +
                    "Bu makalede React nedir ve bir front-end geliştiricisi olarak işinize nasıl yarar anlamanıza yardımcı olacağız.\n1. Kullanımı kolay\n" +
                    "Açık kaynaklı bir JavaScript GUI kütüphanesi olan React’in en büyük odak noktası vardır; UI görevlerini verimli bir şekilde tamamlamaktır. MVC kalıbındaki (Model-View-Controller – Model Görünüm Kontrolcüsü) “V” olarak sınıflandırılabilir.\n" +
                    "\n" +
                    "Bir JavaScript geliştiricisi olarak React’in temellerini anlamakta zorluk çekmeyeceksiniz. Hatta birkaç günlük kullanım ile web bazlı uygulamalar geliştirmeye bile başlayabilirsiniz.\n" +
                    "\n" +
                    "Bilginizi artırmak için React hakkında birçok makale okuyabilirsiniz. Bu aracı kullanmaya dair pek çok bilgi içermektedirler: kavrayışınızı zenginleştirecek videolar, rehberler ve veriler.\n" +
                    "\n" +
                    "2. Java’da Yeniden Kullanılabilir Bileşenleri Destekler\n" +
                    "React aynı fonksiyonu kullanan başka uygulamalara geliştirilen bileşenleri yeniden kullanmanıza izin verir. Bileşen yeniden kullanabilme özelliği geliştiriciler için sıradışı bir özelliktir.\n" +
                    "\n" +
                    "3. Daha Kolay Bileşen Yazma\n" +
                    "React bileşeni, HTML ile JavaScript’i birleştirmenizi sağlayan tercihe bağlı bir sözdizimi uzantısı olan JSX kullandığından yazması daha kolaydır.\n" +
                    "\n" +
                    "JSX JavaScript ile HTML‘in mükemmel bir karışımıdır. Bütün web site yapı yazma sürecini açıklar. Ek olarak, kullanılan uzantı birden çok fonksiyonu işlemeyi daha kolay hale getirir.\n" +
                    "\n" +
                    "JSX en popüler sözdizimi uzantısı olmasa da özel bileşenler veya yüksek hacimli uygulamalar geliştirmekte oldukça verimli olduğunu kanıtlamıştır.\n" +
                    "\n" +
                    "4. Sanal DOM ile Daha İyi Performans\n" +
                    "React DOM (Document Object Model – Belge Nesne Modeli) işlemini verimli biçimde güncelleyecektir. Tahmin edebileceğiniz gibi bu işlem web bazlı uygulamalarda birçok sorun çıkartabilir. Şanslısınız ki React sanal DOM’lar kullanır, böylece bu sorunu yaşamanıza gerek kalmaz.\n" +
                    "\n" +
                    "Bu araç sanal DOM’lar oluşturmanıza ve onları bir hafıza barındırmanıza izin verir. Sonuç olarak, gerçek DOM’da her değişiklik olduğunda sanal olanı da anında değişir.\n" +
                    "\n" +
                    "Sistem gerçek DOM’un devamlı güncellemeleri zorlamasını önleyecektir. Böylece uygulamanızın hızı aksamayacaktır.\n" +
                    "\n" +
                    "5. SEO Dostu\n" +
                    "React çeşitli arama motorlarında erişilebilen bir kullanıcı arayüzü oluşturmanıza izin verir. Bu özellik çok avantajlıdır çünkü bütün JavaScript frameworkleri SEO dostu değildir.\n" +
                    "\n" +
                    "Üstelik, React’in uygulama sürecini hızlandırabileceğinden SEO sıralamalarınızı da yükseltebilir. Ne de olsa SEO optimizasyonunda web site hızının rolü çok önemlidir.\n" +
                    "Terimler Sözlüğü\n" +
                    "JavaScript\n" +
                    "Ağu 26, 2022\n" +
                    "\n" +
                    "Gökhan O.\n" +
                    "\n" +
                    "3dk. Okuma Süresi\n" +
                    "\n" +
                    "React Nedir? Nasıl Çalışır?\n" +
                    "React, kullanıcı arayüzü (UI) oluşturmak için kullanılan en popüler JavaScript kütüphanesidir. Web siteleri işlemek için kullanıcı çıktısına harika yanıt sunan bir yöntemi kullanır.\n" +
                    "\n" +
                    "Bu aracın bileşenleri Facebook tarafından geliştirilmiştir. 2013’de açık kaynaklı bir JavaScript olarak piyasaya sürülmüştür. Şu anda, çok satan listesinin en üstünde yer alan Angular ve Bootstrap gibi ana rakiplerinin önündedir.\n" +
                    "\n" +
                    "Bu makalede React nedir ve bir front-end geliştiricisi olarak işinize nasıl yarar anlamanıza yardımcı olacağız.\n" +
                    "\n" +
                    "Neden React’i Kullanmalısınız?\n" +
                    "1. Kullanımı kolay\n" +
                    "2. Java’da Yeniden Kullanılabilir Bileşenleri Destekler\n" +
                    "3. Daha Kolay Bileşen Yazma\n" +
                    "4. Sanal DOM ile Daha İyi Performans\n" +
                    "5. SEO Dostu\n" +
                    "React Nasıl Çalışır?\n" +
                    "Sonuç\n" +
                    "Neden React’i Kullanmalısınız?\n" +
                    "React nedir: react ana sayfası\n" +
                    "React Netflix, Airbnb, American Express, Facebook, WhatsApp, eBay, ve Instagram dahil olmak üzere yüzlerce büyük şirket tarafından kullanılmıştır. Bu, bu aracın rakip sağladığı avantajların rakipsiz olduğunun kanıtıdır.\n" +
                    "\n" +
                    "İşte React nedir sorusuna olan cevabı daha da kapsamlı olarak anlamanıza yardımcı olacak React’i kullanmanızı gerektiren bazı sebepler:\n" +
                    "\n" +
                    "Ucuz Premium Web Hosting fırsatını kaçırmayın! Üstelik 12 ay ve üstü planlarda ücretsiz domain ve her planla ücretsiz SSL alarak, en düşük maliyetlerle site kurabilir, işletmenizi veya portfolyonuzu dünyaya sergileyebilirsiniz!\n" +
                    "Web Hosting Fırsatı\n" +
                    "1. Kullanımı kolay\n" +
                    "Açık kaynaklı bir JavaScript GUI kütüphanesi olan React’in en büyük odak noktası vardır; UI görevlerini verimli bir şekilde tamamlamaktır. MVC kalıbındaki (Model-View-Controller – Model Görünüm Kontrolcüsü) “V” olarak sınıflandırılabilir.\n" +
                    "\n" +
                    "Bir JavaScript geliştiricisi olarak React’in temellerini anlamakta zorluk çekmeyeceksiniz. Hatta birkaç günlük kullanım ile web bazlı uygulamalar geliştirmeye bile başlayabilirsiniz.\n" +
                    "\n" +
                    "Bilginizi artırmak için React hakkında birçok makale okuyabilirsiniz. Bu aracı kullanmaya dair pek çok bilgi içermektedirler: kavrayışınızı zenginleştirecek videolar, rehberler ve veriler.\n" +
                    "\n" +
                    "2. Java’da Yeniden Kullanılabilir Bileşenleri Destekler\n" +
                    "React aynı fonksiyonu kullanan başka uygulamalara geliştirilen bileşenleri yeniden kullanmanıza izin verir. Bileşen yeniden kullanabilme özelliği geliştiriciler için sıradışı bir özelliktir.\n" +
                    "\n" +
                    "3. Daha Kolay Bileşen Yazma\n" +
                    "React bileşeni, HTML ile JavaScript’i birleştirmenizi sağlayan tercihe bağlı bir sözdizimi uzantısı olan JSX kullandığından yazması daha kolaydır.\n" +
                    "\n" +
                    "JSX JavaScript ile HTML‘in mükemmel bir karışımıdır. Bütün web site yapı yazma sürecini açıklar. Ek olarak, kullanılan uzantı birden çok fonksiyonu işlemeyi daha kolay hale getirir.\n" +
                    "\n" +
                    "JSX en popüler sözdizimi uzantısı olmasa da özel bileşenler veya yüksek hacimli uygulamalar geliştirmekte oldukça verimli olduğunu kanıtlamıştır.\n" +
                    "\n" +
                    "4. Sanal DOM ile Daha İyi Performans\n" +
                    "React DOM (Document Object Model – Belge Nesne Modeli) işlemini verimli biçimde güncelleyecektir. Tahmin edebileceğiniz gibi bu işlem web bazlı uygulamalarda birçok sorun çıkartabilir. Şanslısınız ki React sanal DOM’lar kullanır, böylece bu sorunu yaşamanıza gerek kalmaz.\n" +
                    "\n" +
                    "Bu araç sanal DOM’lar oluşturmanıza ve onları bir hafıza barındırmanıza izin verir. Sonuç olarak, gerçek DOM’da her değişiklik olduğunda sanal olanı da anında değişir.\n" +
                    "\n" +
                    "Sistem gerçek DOM’un devamlı güncellemeleri zorlamasını önleyecektir. Böylece uygulamanızın hızı aksamayacaktır.\n" +
                    "\n" +
                    "5. SEO Dostu\n" +
                    "React çeşitli arama motorlarında erişilebilen bir kullanıcı arayüzü oluşturmanıza izin verir. Bu özellik çok avantajlıdır çünkü bütün JavaScript frameworkleri SEO dostu değildir.\n" +
                    "\n" +
                    "Üstelik, React’in uygulama sürecini hızlandırabileceğinden SEO sıralamalarınızı da yükseltebilir. Ne de olsa SEO optimizasyonunda web site hızının rolü çok önemlidir.\n" +
                    "\n" +
                    "Ucuz Premium Web Hosting fırsatını kaçırmayın! Üstelik 12 ay ve üstü planlarda ücretsiz domain ve her planla ücretsiz SSL alarak, en düşük maliyetlerle site kurabilir, işletmenizi veya portfolyonuzu dünyaya sergileyebilirsiniz!\n" +
                    "Web Hosting Fırsatı\n" +
                    "Ancak React’in sadece bir JavaScript kütüphanesi olduğunu unutmayın. Bu demektir ki her şeyi kendi başına yapamaz. Ek kütüphanelerin kullanımı durum kontrolü, yönlendirme ve etkileşim için gerekebilir.\n" +
                    "\n" +
                    "React Nasıl Çalışır?\n" +
                    "React nedir öğrendiğinize göre sırada React’in nasıl çalıştığı var. HTML kodlarını JavaScript’te yazabileceğinizi öğrendiğinize şaşırabilirsiniz. Ancak React de tam olarak böyle çalışır.\n" +
                    "\n" +
                    "Bir DOM node’unun temcilsini oluşturmak React’de Element fonksiyonunu oluşturmakla yapılabilir. İşte bunun bir örneği:\n" +
                    "\n" +
                    "React.createElement(\"div\", { className: \"red\" }, \"Children Text\");\n" +
                    "React.createElement(MyCounter, { count: 3 + 5 });\n" +
                    "Fark ettiyseniz yukarıdaki HTML kodundaki sözdizimi XML bileşenlerine oldukça benzerdir. Ancaki geleneksel DOM sınıfını kullanmak yerine React className‘i kullanır.\n" +
                    "\n" +
                    "JSX etiketleri bir etiket adına, çocuklara ve niteliklere sahiptir. JSX niteliklerindeki tırnak işaretleri dizileri temsil eder. Bu element JavaScript’e benzerdir.\n" +
                    "\n" +
                    "Ek olarak sayısal değerler ve ifadeler küme parantezleri içinde yazılmalıdır.\n" +
                    "\n" +
                    "Yukarıdaki örnek, JSX uzantısı kullanıldığından React’deki sözdizimini muhteşem biçimde tasvir etmektedir. Basitçe, HTML ve JavaScript’in karışımıdır.\n" +
                    "\n" +
                    "İşte JSX kullanılarak yazılmış bir React örneği:\n" +
                    "\n" +
                    "<div className=\"red\">Children Text</div>;\n" +
                    "<MyCounter count={3 + 5} />;\n" +
                    "var GameScores = {player1: 2,player2: 5};\n" +
                    "<DashboardUnit data-index=\"2\">\n" +
                    "<h1>Scores</h1><Scoreboard className=\"results\" scores={GameScores} />\n" +
                    "</DashboardUnit>;\n" +
                    "Özetlemek gerekirse işte yukarıdaki HTML etiketine dair bazı notlar:\n" +
                    "\n" +
                    "<MyCounter> değeri olarak, bu durumda rakamsal bir değer gösteren bir sayıdır “count”.\n" +
                    "GameScores iki adet prop değeri çiftine sahip bir nesne gerçeğidir.\n" +
                    "<DashboardUnit> sayfada işlenen XML bloğudur.\n" +
                    "scores={GameScores}: scores niteliği GameScores’dan daha önce de tanımlanmış bir değer alır.\n" +
                    "Genellikle React standart JavaScript (JS) yerine JSX (JavaScript XML) kullanılarak yazılır. Ancak bunun amacının React bileşenlerini daha kolay oluşturmak için olduğunu unutmayın.\n" +
                    "\n" +
                    "Standart JavaScript bileşeni ile React bileşeni oluşturabilirsiniz ancak çok dağınık olacağından neredeyse yüzde yüz eminiz.\n" +
                    "\n" +
                    "Üstelik React’de JSX kullanımının arkasındaki fikirse Facebook’un geliştiriciler için temiz ve açık yapılandırmalı tek türden bir sözdizimi uzantısı sağlamak istemesidir."),
            Product(R.drawable.matlab, "Matlab","MATLAB (matrix laboratory), çok paradigmalı sayısal hesaplama yazılımı ve dördüncü nesil programlama dilidir. Sahipli bir programlama dili olan MATLAB, MathWorks tarafından geliştirilmektedir. MATLAB kullanıcıya, matris işleme, fonksiyon ve veri çizme, algoritma uygulama, kullanıcı arayüzü oluşturma, C, C++, Java, ve Fortran gibi diğer dillerde yazılmış programlarla arabağlama imkânı tanır.\n" +
                    "\n" +
                    "MATLAB, öncelikli olarak sayısal işleme yönelik üretilmiş olmasına rağmen, isteğe bağlı olarak sembolik hesaplama yapabilen MuPAD sembolik motorunu kullanır. Ek paket, dinamik ve gömülü sistemler için Simulink'i, grafiksel çoklu alan simülasyonunu ve model tabanlı tasarımı ekler.\n" +
                    "\n" +
                    "2004'te, MATLAB akademik ve endüstriyel alandaki kullanıcı sayısı bir milyon civarındaydı.[20] MATLAB kullanıcıları mühendislik, bilim, ve ekonomi gibi çeşitli alanlardan gelmektedir. MATLAB, yaygın olarak akademik ve araştırma kurumlarında olduğu kadar endüstriyel işletmelerde de çok kullanılmaktadır."),
            Product(R.drawable.csharp, "C#","C# (\"See Sharp\" olarak okunur), modern, nesne odaklı ve türe uygun bir programlama dilidir. C#, geliştiricilerin .NET'te çalıştıran birçok tür güvenli ve sağlam uygulama oluşturmalarına olanak sağlar. C# dilinin kökleri C dil ailesindedir ve C, C++, Java ve JavaScript programcılarına hemen tanıdık gelecektir. Bu tur, C# 8 ve önceki sürümlerde dilin ana bileşenlerine genel bir bakış sağlar. Dili etkileşimli örneklerle keşfetmek için C# öğreticilerini incelemeyi deneyin.\n" +
                    "\n" +
                    "C# nesne odaklı, bileşen odaklı bir programlama dilidir. C# bu kavramları doğrudan desteklemek için dil yapıları sağlar ve bu da C# dilini yazılım bileşenlerinin oluşturularak kullanıla bir doğal dil olması sağlar. C# kaynağından bu yana yeni iş yüklerini ve yeni ortaya çıkan yazılım tasarımı uygulamalarını desteklemek için özellikler eklemektedir. C# temel olarak nesne odaklı bir dildir . Türleri ve bunların davranışlarını siz tanımlarsiniz.\n" +
                    "\n" +
                    "Çeşitli C# özellikleri sağlam ve dayanıklı uygulamalar oluşturmanıza yardımcı olur. Atık toplama , erişilemez durumdaki nesneler tarafından kapladığı belleği otomatik olarak geri verir. Null değere sahip türler, ayrılan nesnelere başvurul olmayan değişkenlere karşı koruma sağlar. Özel durum işleme, hata algılama ve kurtarma için yapılandırılmış ve genişletilebilir bir yaklaşım sağlar. Lambda ifadeleri işlevsel programlama tekniklerini destekler. Language Integrated Query (LINQ) söz dizimi, herhangi bir kaynaktan gelen verilerle çalışmak için ortak bir desen oluşturur. Zaman uyumsuz işlemler için dil desteği, dağıtılmış sistemler için söz dizimi sağlar. C# birleşik bir tür sistemine sahiptir. ve gibi ilkel türler de dahil olmak üzere tüm int C# türleri doubletek bir kök türünden devralınabilir object . Tüm türler bir dizi ortak işlem paylaşır. Herhangi bir türe sahip değerler tutarlı bir şekilde depolanmış, taşımalı ve üzerinde işletilebilir. Ayrıca, C# hem kullanıcı tanımlı başvuru türlerini hem de değertürlerini destekler. C#, nesnelerin dinamik olarak ayırmaya ve basit yapıların satır içinde depolanmasına olanak sağlar. C#, daha fazla tür güvenliği ve performansı sağlayan genel yöntemleri ve türleri destekler. C#, koleksiyon sınıflarını uygulayanların istemci kodu için özel davranışlar tanımlamalarını sağlayan bir yenidenlayıcı sağlar.\n" +
                    "\n" +
                    "C#, programların ve kitaplıkların zaman içinde uyumlu bir şekilde gelişene kadar devam etmek için sürüm geliştirmeyi vurgular. C# tasarımının virtualoverride sürümle ilgili önemli noktalardan doğrudan etkileniyor olan yönleri ayrı ve değiştiriciler, yöntem aşırı yükleme çözümlemesi kuralları ve açık arabirim üyesi bildirimleri için destek içerir.\n" +
                    "\n" +
                    ".NET mimarisi\n" +
                    "C# programları .NET üzerinde, ortak dil çalışma zamanı (CLR) adlı bir sanal yürütme sistemi ve bir sınıf kitaplıkları kümesi üzerinde çalışır. CLR, microsoft tarafından uluslararası bir standart olan ortak dil altyapısının (CLI) uygulanmasıdır. CLI, dillerin ve kitaplıkların birlikte sorunsuz bir şekilde birlikte çalışıp çalışmalarına izin verilemayacak yürütme ve geliştirme ortamları oluşturmanın temelini oluşturuyor.\n" +
                    "\n" +
                    "C# dilinde yazılan kaynak kodu, CLI belirtimine uygun bir ara dil (IL) olarak derlenmiş. IL kodu ve bit eşlemler ve dizeler gibi kaynaklar genellikle bir derlemede depolanır ve genellikle bir .dll. Derleme, derlemenin türleri, sürümü ve kültürü hakkında bilgi sağlayan bir bildirim içerir.\n" +
                    "\n" +
                    "C# programı yürütülürken derleme CLR'ye yüklenir. CLR, IL kodunu yerel makine yönergelerine dönüştürmek için Tam Zamanında (JIT) derleme gerçekleştirir. CLR otomatik çöp toplama, özel durum işleme ve kaynak yönetimi ile ilgili diğer hizmetleri sağlar. CLR tarafından yürütülen kodlar bazen \"yönetilen kod\" olarak adlandırılır. \"Unmanaged code\", belirli bir platformu hedef alan yerel makine diline derlenmiş.\n" +
                    "\n" +
                    "Dil birlikte çalışabilirliği, .NET'in önemli bir özelliğidir. C# derleyicisi tarafından üretilen IL kodu Ortak Tür Belirtimine (CTS) uygun. C# ile oluşturulan IL kodu, F#, Visual Basic, C++ .NET sürümlerinden oluşturulan kodla etkileşime olabilir. 20'den fazla CTS uyumlu dil daha vardır. Tek bir derleme, farklı .NET dillerinde yazılmış birden çok modül içerebilir. Türler aynı dilde yazılmış gibi birbirine başvurur.\n" +
                    "\n" +
                    ".NET, çalışma zamanı hizmetlerine ek olarak kapsamlı kitaplıklar da içerir. Bu kitaplıklar birçok farklı iş yükünü destekler. Bunlar çok çeşitli yararlı işlevler sağlayan ad alanları olarak düzenlenmiştir. Kitaplıklar, dosya girişi ve çıkışından dize işlemeye, XML ayrıştırmaya, web uygulaması çerçevelerine ve Windows Forms denetimlerini içerir. Tipik C# uygulaması yaygın \"su işleri\" işlerini işlemek için .NET sınıf kitaplığını yaygın olarak kullanır.\n" +
                    "\n" +
                    ".NET hakkında daha fazla bilgi için bkz. .NET'e Genel Bakış.\n" +
                    "\n" +
                    "Merhaba dünya\n" +
                    "\"Hello, World\" programı geleneksel olarak bir programlama dilini tanıtmak için kullanılır. Burada C# içindedir:\n" +
                    "\n" +
                    "C#\n" +
                    "\n" +
                    "Kopyala\n" +
                    "\n" +
                    "Çalıştır\n" +
                    "using System;\n" +
                    "\n" +
                    "class Hello\n" +
                    "{\n" +
                    "    static void Main()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Hello, World\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\"Hello, World\" programı ad alanına başvurulan using bir yönergeyle System başlar. Ad alanları, C# programlarını ve kitaplıklarını düzenlemek için hiyerarşik bir hizmet sağlar. Ad alanları türleri ve diğer ad alanlarını içerir; örneğin ad alanı, SystemConsole programda başvurulan sınıf gibi bir dizi tür ve ve gibi diğer ad alanlarını IO içerir Collections. Verilen using ad alanına başvurulan bir yönerge, bu ad alanının üyesi olan türlerin tam olmayan kullanımını sağlar. yönergesi using nedeniyle, program için shorthand Console.WriteLine olarak kullanabilir System.Console.WriteLine.\n" +
                    "\n" +
                    "Hello\"Hello, World\" programı tarafından bildirilen sınıfın adlı tek bir üyesi vardırMain. yöntemi Main değiştiricisi ile static bildirildi. Örnek yöntemleri anahtar sözcüğünü kullanarak belirli bir kapsayan thisnesne örneğine başvurarken, statik yöntemler belirli bir nesneye başvuru olmadan çalışır. Kural gereği, adlı statik bir yöntem Main C# programının giriş noktası olarak görev gösterir.\n" +
                    "\n" +
                    "Programın çıktısı, ad alanı içinde WriteLine sınıfının yöntemi Console tarafından System üretir. Bu sınıf, varsayılan olarak derleyici tarafından otomatik olarak başvurulan standart sınıf kitaplıkları tarafından sağlanır.\n" +
                    "\n" +
                    "Türler ve değişkenler\n" +
                    "Tür , C# içinde herhangi bir verinin yapısını ve davranışını tanımlar. Bir türün bildirimi üyelerini, temel türünü, uygulayan arabirimleri ve bu tür için izin verilen işlemleri içerebilir. Değişken , belirli bir tür örneğine başvuran bir etikettir.\n" +
                    "\n" +
                    "C# içinde iki tür türü vardır: değer türleri vebaşvuru türleri. Değer türlerinin değişkenleri doğrudan verilerini içerir. Başvuru türlerinin değişkenleri, verilerine yapılan başvuruları depolar; ikincisi nesne olarak bilinir. Başvuru türleriyle, iki değişkenin aynı nesneye başvurarak bir değişkendeki işlemlerin diğer değişken tarafından başvurulan nesneyi etkilemesi mümkündür. Değer türleriyle, değişkenlerin her birinin kendi veri kopyası vardır ve birteki işlemlerin birbirini etkilemesi mümkün değildir ( refout ve parametre değişkenleri hariç).\n" +
                    "\n" +
                    "Tanımlayıcı bir değişken adıdır. Tanımlayıcı, boşluk olmadan unicode karakter dizisidir. Tanımlayıcı, ön eke sahipse C# ayrılmış sözcüğü olabilir @. Tanımlayıcı olarak ayrılmış bir sözcük kullanmak, diğer dillerle etkileşimde bulunmak için yararlı olabilir.\n" +
                    "\n" +
                    "C# değerinin değer türleri basit türlere ,enum türlerine , yapı türlerine, null değer türlerine ve tuple değer türlerine bölündü. C# başvuru türleri sınıf türlerine, arabirim türlerine, dizi türlerine ve temsilcitürlerine daha fazla bölündü.\n    " +
                    "C# programları, yeni türler oluşturmak için tür bildirimlerini kullanır. Tür bildirimi, yeni türün adını ve üyelerini belirtir. C# kategorisinin altı türü kullanıcı tarafından tanımlanabilir: sınıf türleri, yapı türleri, arabirim türleri, enum türleri, temsilci türleri ve tuple değer türleri. Ayrıca, veya record türlerini bildiresinizrecord structrecord class. Kayıt türlerinin derleyici sentezlenmiş üyeleri vardır. Kayıtları en az ilişkili davranışla değerleri depolamak için kullanırsınız.\n" +
                    "\n" +
                    "Tür class , veri üyelerini (alanlar) ve işlev üyelerini (yöntemler, özellikler ve diğerleri) içeren bir veri yapısını tanımlar. Sınıf türleri tek devralmayı ve çok biçimliliği destekler; türetilmiş sınıfların temel sınıfları genişleterek ve özelleyebilinir mekanizmalar.\n" +
                    "Tür struct , veri üyeleri ve işlev üyelerine sahip bir yapıyı temsil eden sınıf türüne benzer. Ancak, sınıfların aksine, yapılar değer türleridir ve genellikle yığın ayırma gerektirmez. Yapı türleri kullanıcı tarafından belirtilen devralmayı desteklemez ve tüm yapı türleri türünden örtülü olarak devralın.object\n" +
                    "Tür interface , bir sözleşmeyi adlandırılmış ortak üye kümesi olarak tanımlar. uygulayan class veya, arabirimin interface üyelerinin uygulamalarını sağlay struct gerekir. Bir interface , birden çok temel arabirimden devralabilir ve bir veya class birden struct çok arabirim kullanabilir.\n" +
                    "Tür delegate , belirli bir parametre listesi ve dönüş türüne sahip yöntemlere yapılan başvuruları temsil eder. Temsilciler, yöntemleri değişkenlere atanabilir ve parametre olarak geçirilen varlıklar olarak kabul edilebilir. Temsilciler, işlev dilleri tarafından sağlanan işlev türlerine benzer. Bunlar, diğer bazı dillerde bulunan işlev işaretçileri kavramına da benzer. İşlev işaretçileri aksine, temsilciler nesne odaklı ve tür güvenlidir.\n" +
                    ", class, structinterfaceve türleridelegate, diğer türlerle parametreli hale getirildiklerinden tüm genel türleri destekler.\n" +
                    "\n" +
                    "C# herhangi bir türde tek boyutlu ve çok boyutlu dizileri destekler. Yukarıda listelenen türlerin aksine, dizi türlerinin kullanılamadan önce bildirilene gerek yok. Bunun yerine, dizi türleri köşeli ayraç içeren bir tür adı takip tarafından oluşturulur. Örneğin, tek int[]intboyutlu bir dizisidir, intint[,]int[][] iki boyutlu bir dizisidir ve tek boyutlu dizilerden veya \"jagged\" dizisinin tek boyutlu bir dizisidirint.\n" +
                    "\n" +
                    "Null değere sahip türler için ayrı bir tanım gerekli değildir. Null değere sahip olmayan her tür Tiçin, ek T?bir değere sahip olan karşılık gelen null değere değiştirilebilir bir tür vardır null. Örneğin, herhangi int? bir 32 bit nullstring? tamsayıyı veya değerini tuta bir tür ve herhangi birini veya değerini tutan string bir tür.null\n" +
                    "\n" +
                    "C#'nin tür sistemi, herhangi bir türün değeri olarak kabul edilebilir şekilde birleştirilmiştir object. C# içinde her tür doğrudan veya dolaylı olarak object sınıf türünden türetir ve object tüm türlerin nihai temel sınıfıdır. Başvuru türlerinin değerleri, değerleri türünde görüntüılarak nesne olarak kabul edilir object. Değer türlerinin değerleri, kutulama ve kutudan açma işlemleri gerçekleştirereknesne olarak kabul edilir. Aşağıdaki örnekte, bir değer int değerine dönüştürülür ve object tekrar değerine dönüştürülür int.\n" +
                    "\n" +
                    "C#\n" +
                    "\n" +
                    "Kopyala\n" +
                    "int i = 123;\n" +
                    "object o = i;    // Boxing\n" +
                    "int j = (int)o;  // Unboxing\n" +
                    "Bir başvuruya bir değer türü değeri atandığı zaman object , değeri tutmak için bir \"kutu\" ayrılır. Bu kutu bir başvuru türünün örneğidir ve değer bu kutuya kopyalanır. Buna karşılık, bir başvuru object bir değer türüne object türe göre başvurulan bir kutu olduğunu onaylar. Onay başarılı olursa, kutu içinde yer alan değer değer türüne kopyalanır.\n" +
                    "\n" +
                    "C#'nin birleşik tür sistemi, değer türlerinin \"isteğe bağlı\" başvuru object olarak kabul edilen bir sistem olduğu anlamına gelir. Birleştirme nedeniyle, türünü kullanan objectobjectgenel amaçlı kitaplıklar, hem başvuru türleri hem de değer türleri dahil olmak üzere ' den türeten tüm türlerle kullanılabilir.\n" +
                    "\n" +
                    "C# içinde alanlar , dizi öğeleri, yerel değişkenler ve parametreler gibi çeşitli değişken türleri vardır. Değişkenler depolama konumlarını temsil eder. Her değişkenin, aşağıda gösterildiği gibi değişkende depolanmış olan değerleri belirleyen bir türü vardır.\n" +
                    "\n" +
                    "Null değere sahip olmayan değer türü\n" +
                    "Tam türün değeri\n" +
                    "Null değer değer türü\n" +
                    "Tam null türe sahip bir değer veya değer\n" +
                    "object\n" +
                    "Başvuru null , herhangi bir başvuru türüne sahip bir nesneye başvuru veya herhangi bir değer türünün kutu değerli değerine başvuru\n" +
                    "Sınıf türü\n" +
                    "Bir null başvuru, bu sınıf türünün bir örneğine başvuru veya bu sınıf türünden türetilen bir sınıfın örneğine başvuru\n" +
                    "Arabirim türü\n" +
                    "Başvuru null , bu arabirim türünü uygulayan bir sınıf türünün örneğine başvuru veya bu arabirim türünü uygulayan bir değer türünün kutusal değerine başvuru\n" +
                    "Dizi türü\n" +
                    "Bir null başvuru, bu dizi türünün bir örneğine başvuru veya uyumlu bir dizi türünün örneğine başvuru\n" +
                    "Temsilci türü\n" +
                    "Uyumlu null bir temsilci türünün örneğine başvuru veya başvuru\n" +
                    "Program yapısı\n" +
                    "C# içinde temel kurumsal kavramlar programlar, ad alanları, türler, üyeler ve derlemelerdir. Programlar, üyeleri içeren ve ad alanları olarak düzenlen içeren türleri bildirmektedir. Sınıflar, yapılar ve arabirimler türlere örnektir. Alanlar, yöntemler, özellikler ve olaylar üyelerin örnekleridir. C# programları derlenmiş olduğunda, fiziksel olarak derlemeler içine paketlenmiş olur. Derlemeler, sırasıyla uygulama veya .exe.dllkitaplık uygulamalarına bağlı olarak genellikle .exeuzantısına veya 'ye sahiptir.\n" +
                    "\n" +
                    "Küçük bir örnek olarak, aşağıdaki kodu içeren bir derlemeyi göz önünde bulundurabilirsiniz:\n" +
                    "\n" +
                    "C#\n" +
                    "\n" +
                    "Kopyala\n" +
                    "namespace Acme.Collections;\n" +
                    "\n" +
                    "public class Stack<T>\n" +
                    "{\n" +
                    "    Entry _top;\n" +
                    "\n" +
                    "    public void Push(T data)\n" +
                    "    {\n" +
                    "        _top = new Entry(_top, data);\n" +
                    "    }\n" +
                    "\n" +
                    "    public T Pop()\n" +
                    "    {\n" +
                    "        if (_top == null)\n" +
                    "        {\n" +
                    "            throw new InvalidOperationException();\n" +
                    "        }\n" +
                    "        T result = _top.Data;\n" +
                    "        _top = _top.Next;\n" +
                    "\n" +
                    "        return result;\n" +
                    "    }\n" +
                    "\n" +
                    "    class Entry\n" +
                    "    {\n" +
                    "        public Entry Next { get; set; }\n" +
                    "        public T Data { get; set; }\n" +
                    "\n" +
                    "        public Entry(Entry next, T data)\n" +
                    "        {\n" +
                    "            Next = next;\n" +
                    "            Data = data;\n" +
                    "        }\n" +
                    "    }\n" +
                    "}\n" +
                    "Bu sınıfın tam adı olur Acme.Collections.Stack. sınıfı birkaç üye içerir: adlı bir alan _top, ve adlı iki yöntem PushPopve adlı iç içe geçmiş bir sınıf Entry. Sınıfı Entry daha fazla üç üye içerir: adlı bir özellik Next, adlı bir özellik ve Databir oluşturucu. , Stack genel bir Stack . Bir tür parametresi vardır ve T bu parametre kullanıldığında somut bir türle değiştirilir.\n" +
                    "\n" +
                    "Yığın , \"ilk gelen - son çıkar\" (FILO) koleksiyonudur. Yığının en üstüne yeni öğeler eklenir. Bir öğe kaldırıldığı zaman, yığının üst kısmından kaldırılır. Önceki örnek, bir yığının Stack depolama alanını ve davranışını tanımlayan türü bildirmektedir. Bu işlevi kullanmak için türünün bir örneğine başvuran Stack bir değişken bildirsiniz.\n" +
                    "\n" +
                    "Derlemeler, Ara Dil (IL) yönergeleri ve meta veriler şeklinde sembolik bilgiler şeklinde yürütülebilir kod içerir. Yürütülmeden önce, .NET Ortak Dil Çalışma Zamanı'nın Tam Zamanında (JIT) derleyicisi, derlemede IL kodunu işlemciye özgü koda dönüştürür.\n" +
                    "\n" +
                    "Derleme hem kodu hem de meta verileri içeren kendini açıklayan bir işlev birimi olduğundan, #include C# içinde yönergelere ve üst bilgi dosyalarına gerek yoktur. Belirli bir derlemede yer alan ortak türler ve üyeler, yalnızca programı derlemek için bu derlemeye başvurarak bir C# programında kullanılabilir hale yapılır. Örneğin, bu program derlemeden Acme.Collections.Stack sınıfını acme.dll kullanır:\n" +
                    "\n" +
                    "C#\n" +
                    "\n" +
                    "Kopyala\n" +
                    "class Example\n" +
                    "{\n" +
                    "    public static void Main()\n" +
                    "    {\n" +
                    "        var s = new Acme.Collections.Stack<int>();\n" +
                    "        s.Push(1); // stack contains 1\n" +
                    "        s.Push(10); // stack contains 1, 10\n" +
                    "        s.Push(100); // stack contains 1, 10, 100\n" +
                    "        Console.WriteLine(s.Pop()); // stack contains 1, 10\n" +
                    "        Console.WriteLine(s.Pop()); // stack contains 1\n" +
                    "        Console.WriteLine(s.Pop()); // stack is empty\n" +
                    "    }\n" +
                    "}\n" +
                    "Bu programı derlemek için önceki örnekte tanımlanan yığın sınıfını içeren derlemeye başvurabilirsiniz.\n" +
                    "\n" +
                    "C# programları çeşitli kaynak dosyalarda depolanmış olabilir. Bir C# programı derlendiğinde, tüm kaynak dosyalar birlikte işlenir ve kaynak dosyalar birbirine ücretsiz olarak başvurur. Kavramsal olarak, tüm kaynak dosyalar işlenmeden önce tek bir büyük dosyada birlenmiş gibi olur. Birkaç özel durum dışında bildirim sırası önemsiz olduğundan, C# içinde hiçbir zaman ileri bildirim gerekmez. C# bir kaynak dosyayı yalnızca bir ortak türü bildirecek şekilde sınırlamaz ve kaynak dosyanın adının kaynak dosyada bildirilen bir türle eşleşmesi için gerekli değildir.\n" +
                    "\n" +
                    "Bu turda yer alan diğer makalelerde bu kurumsal bloklar açıklayacak."),
            Product(R.drawable.pt, "PYTHON","Python Nedir?\n" +
                    "Python; web uygulamaları, yazılım geliştirme, veri bilimi ve makine öğreniminde (ML) yaygın olarak kullanılan bir programlama dilidir. Geliştiriciler, etkili ve öğrenmesi kolay olduğu ve birçok farklı platformda çalıştırılabildiği için Python'ı kullanır. Python yazılımı ücretsiz olarak indirilebilir, her türlü sistemle iyi bir entegrasyon sağlar ve geliştirme hızını artırır.\n" +
                    "\n" +
                    "Python'ın avantajları nelerdir?\n" +
                    "Python'ın avantajlarından bazıları şunlardır:\n" +
                    "\n" +
                    "Geliştiriciler, basit ve İngilizceye benzer bir söz dizimine sahip olduğundan Python programını kolayca okuyabilir ve anlayabilir. \n" +
                    "Geliştiriciler, diğer birçok dile kıyasla çok daha az kod satırıyla bir Python programı yazabildiğinden Python, geliştiricilerin daha üretken olmasını sağlar.\n" +
                    "Python, neredeyse her görev için yeniden kullanılabilir kodları içeren geniş bir standart kitaplığa sahiptir. Dolayısıyla geliştiricilerin kodu sıfırdan yazmasına gerek yoktur.\n" +
                    "Geliştiriciler Python'ı Java, C ve C++ gibi diğer popüler programlama dilleriyle kolayca kullanabilir.\n" +
                    "Dünya genelinde aktif Python topluluğunda, destek sunmaya hazır milyonlarca geliştirici bulunmaktadır. Bir sorunla karşılaşırsanız bu topluluktan hızlıca destek alabilirsiniz.\n" +
                    "Python'ı öğrenmek isterseniz internette birçok yararlı kaynak bulunmaktadır. Örneğin, kolayca videolar, dersler, belgeler ve geliştirici kılavuzları bulabilirsiniz.\n" +
                    "Python; Windows, macOS, Linux ve Unix gibi farklı bilgisayar işletim sistemleri arasında taşınabilir.\n" +
                    "Python nasıl kullanılır?\n" +
                    "Python dili, uygulama geliştirme alanında birçok şekilde kullanılabilir. Bunlardan bazıları şu şekildedir:\n" +
                    "\n" +
                    "Sunucu tarafında web geliştirme\n" +
                    "Sunucu tarafında web geliştirme, web sitelerinin kullanıcıya bilgiler göstermek için gerçekleştirdiği karmaşık arka uç işlevleri içerir. Örneğin, web siteleri veritabanlarıyla etkileşim kurmalı, diğer web siteleriyle konuşmalı ve verileri ağ üzerinden gönderirken korumalıdır. \n" +
                    "\n" +
                    "Python, karmaşık arka uç işlevleri için önceden yazılmış koddan oluşan birçok kitaplık sunduğundan sunucu tarafında kod yazma açısından kullanışlıdır. Geliştiriciler, web uygulamalarını daha hızlı ve daha kolay oluşturmak için gereken tüm araçları sağlayan çok çeşitli Python çerçevelerinden de yararlanabilir. Örneğin, geliştiriciler, baştan yazmak zorunda olmadıklarından saniyeler içinde web uygulaması çatısı oluşturabilirler. Sonrasında, başka test araçlarına ihtiyaçları olmadan çerçevenin test araçlarını kullanarak bu çatıyı test edebilirler.\n" +
                    "\n" +
                    "Python betikleriyle otomasyon\n" +
                    "Bir betik dili, normalde insanların gerçekleştirdiği görevleri otomatikleştiren bir programlama dilidir. Programcılar, aşağıdakiler gibi her gün yaptıkları birçok görevi otomatikleştirmek için Python betiklerini yaygın olarak kullanırlar:\n" +
                    "\n" +
                    "Çok sayıda dosyayı tek seferde yeniden adlandırma\n" +
                    "Bir dosyayı başka bir dosya türüne dönüştürme\n" +
                    "Bir metin dosyasındaki tekrarlayan kelimeleri silme\n" +
                    "Temel matematiksel işlemleri gerçekleştirme\n" +
                    "E-posta iletileri gönderme\n" +
                    "İçerik indirme\n" +
                    "Temel günlük analizi gerçekleştirme\n" +
                    "Birçok dosyada hata bulma\n" +
                    "Veri bilimi ve makine öğrenimi\n" +
                    "Veri bilimi, verilerden değerli bilgileri ayıklamaktır ve makine öğrenimi (ML), bilgisayarlara verilerden otomatik olarak öğrenmesini ve doğru tahminlerde bulunmasını öğretir. Veri bilimciler, aşağıdakiler gibi veri bilimi görevleri için Python'ı kullanır:\n" +
                    "\n" +
                    "Veri temizleme olarak bilinen, yanlış verileri düzeltme ve kaldırma \n" +
                    "Verileri ayıklama ve verilerin çeşitli özelliklerini seçme\n" +
                    "Veri etiketleme, yani veriler için anlamlı adlar ekleme\n" +
                    "Verilerden farklı öngörüler çıkarma\n" +
                    "Çizgi grafikler, çubuk grafikler, sütun grafikler ve dilim grafikler gibi grafikleri kullanarak verileri görselleştirme\n" +
                    " \n" +
                    "Veri bilimciler, ML modellerini eğitmek ve verileri doğru şekilde sınıflandıran sınıflandırıcılar derlemek için Python ML kitaplıklarını kullanır. Farklı alanlarda çalışan kişiler; görüntü, metin ve ağ trafiği sınıflandırması, konuşma tanıma ve yüz tanıma gibi sınıflandırma görevlerini yapması için Python tabanlı sınıflandırıcılar kullanır. Veri bilimciler, gelişmiş bir ML tekniği olan derin öğrenme için de Python kullanır.\n" +
                    "Yazılım geliştirme\n" +
                    "Yazılım geliştiriciler, Python'ı sıklıkla aşağıdakiler gibi farklı geliştirme görevleri ve yazılım uygulamaları için kullanır:\n" +
                    "\n" +
                    "Yazılım kodundaki hataları izleme\n" +
                    "Yazılımı otomatik olarak derleme\n" +
                    "Yazılım proje yönetimini gerçekleştirme\n" +
                    "Yazılım prototipleri geliştirme\n" +
                    "Grafik Kullanıcı Arabirimi (GUI) kitaplıklarını kullanarak masaüstü uygulamaları geliştirme\n" +
                    "Basit metin tabanlı oyunlardan daha karmaşık video oyunlarına kadar çeşitli oyunlar geliştirme\n" +
                    "Yazılım testi otomasyonu\n" +
                    "Yazılım testi, yazılımda hata olmadığından emin olmak için yazılımdan elde edilen sonuçların, beklenen sonuçlarla eşleşip eşleşmediğini kontrol etme işlemidir. \n" +
                    "\n" +
                    "Geliştiriciler, yazdıkları işlevleri test etmek için Unittest, Robot ve PyUnit gibi Python birim testi çerçevelerini kullanır. \n" +
                    "Yazılım testinden sorumlu kişiler, çeşitli test senaryoları için test örnek olayları yazmak için Python'ı kullanır. Örneğin, Python'ı bir web uygulamasının, birden çok yazılım bileşeninin ve yeni özelliklerin kullanıcı arabirimini test etmek için kullanırlar. \n" +
                    "Geliştiriciler, test betiklerini otomatik olarak çalıştırmak için birçok araç kullanabilir. Bu araçlar, Sürekli Entegrasyon/Sürekli Dağıtım (CI/CD) araçları olarak bilinir. Yazılım testinden sorumlu kişiler ve geliştiriciler, testleri otomatikleştirmek için Travis CI ve Jenkins gibi CI/CD araçlarını kullanır. CI/CD aracı, Python test betiklerini otomatik olarak çalıştırır ve geliştiricilerin yaptığı her yeni kod değişikliğinde test sonuçlarını bildirir.\n" +
                    "\n" +
                    "Python'ın tarihi nedir?\n" +
                    "Python, Hollanda'da bir bilgisayar programcısı olan Guido Van Rossum tarafından oluşturulmuştur. İlk başta Noel tatilinde vakit geçirmek için hobi olarak ilgilendiği proje, 1989 yılında Centrum Wiskunde & Informatica'da (CWI) başladı. Dilin adı, Guido Van Rossum'un büyük bir hayranı olduğu Monty Python'ın Uçan Sirki adlı BBC televizyon dizisinden geliyordu. \n" +
                    "\n" +
                    "Python sürümlerinin tarihi\n" +
                    "Guido Van Rossum, Python kodunun ilk sürümünü (sürüm 0.9.0) 1991 yılında yayımladı. Bu sürümde, hatalarla ilgilenmek için bazı veri türleri ve işlevler gibi iyi özellikler bulunuyordu. \n" +
                    "Python 1.0, 1994 yılında eşleştirme, filtreleme ve azaltma gibi bir veri listesini kolayca işlemek için yeni özelliklerle birlikte kullanıma sunuldu.\n" +
                    "Python 2.0, 16 Ekim 2000 tarihinde, Unicode karakter desteği ve bir listeyi taramanın daha kısa yolu gibi, programcılar için yeni kullanışlı özelliklerle yayımlandı.\n" +
                    "Python 3.0, 3 Aralık 2008 tarihinde kullanıma sunuldu. Bu sürüme, yazdırma işlevi ve sayıların bölünmesi ve ayrıca hatalarla ilgilenme için daha fazla destek gibi özellikler eklendi. \n" +
                    "Python'ın özellikleri nelerdir?\n" +
                    "Aşağıdaki özellikler, Python programlama dilinin benzersiz olmasını sağlamaktadır:\n" +
                    "\n" +
                    "Yorumlanan bir dil\n" +
                    "Python, yorumlanan bir dildir, yani kodu doğrudan, satır satır çalıştırır. Program kodunda hatalar varsa çalışmayı durdurur. Bu nedenle programcılar, koddaki hataları hızlıca bulabilir.\n" +
                    "\n" +
                    "Kullanımı kolay dil\n" +
                    "Python, İngilizceye benzer kelimeler kullanır. Diğer programlama dillerinin aksine Python, süslü ayraç işaretleri kullanmaz. Bunun yerine girintileme kullanır. \n" +
                    "\n" +
                    "Dinamik olarak yazılan bir dil\n" +
                    "Python, değişken türlerini çalışma sırasında belirlediğinden programcıların, kod yazarken belirlemesine gerek kalmaz. Dolayısıyla, Python programlarını daha hızlı yazabilirsiniz.\n" +
                    "\n" +
                    "Üst düzey bir dil\n" +
                    "Python, diğer programlama dillerine kıyasla insanların kullandığı dile daha yakındır. Bu yüzden programcıların, mimari ve bellek yönetimi gibi temelde yer alan işlevler konusunda düşünmesine gerek yoktur.\n" +
                    "\n" +
                    "Nesne odaklı bir dil\n" +
                    "Python, her şeyi bir nesne olarak varsayar ancak yapılandırılmış ve işlevsel programlama gibi diğer programlama türlerini de destekler.\n" +
                    "\n" +
                    "Python kitaplıkları nelerdir?\n" +
                    "Kitaplık, kodu sıfırdan yazmamak için geliştiricilerin Python programlarına dahil edebileceği, sık kullanılan kodlardan oluşan bir koleksiyondur. Python, varsayılan olarak, Standart Kitaplıkla birlikte sunulur ve bu kitaplıkta birçok yeniden kullanılabilir işlev yer alır. Buna ek olarak web geliştirme, veri bilimi ve makine öğrenimi (ML) gibi çeşitli uygulamalar için kullanılan 137.000'den fazla Python kitaplığı bulunmaktadır.\n" +
                    "\n" +
                    "En popüler Python kitaplıkları hangileridir?\n" +
                    "Matplotlib\n" +
                    "Geliştiriciler, verileri yüksek kaliteli iki veya üç boyutlu (2B ve 3B) grafiklerde göstermek için Matplotlib'i kullanır. Bu, çoğunlukla bilimsel uygulamalarda kullanılır. Matplotlib ile verileri, çubuk grafikler ve çizgi grafikler gibi farklı grafiklerde göstererek görselleştirebilirsiniz. Ayrıca birden fazla grafiği tek seferde çizebilirsiniz ve grafikler tüm platformlar arasında taşınabilir.\n" +
                    "\n" +
                    "Pandas\n" +
                    "Pandas, tablolar ve diziler gibi zaman serisi verileri ve yapılandırılmış verileri işlemek için kullanabileceğiniz optimize edilmiş ve esnek veri yapıları sağlar. Örneğin, verileri okumak, yazmak, birleştirmek, filtrelemek ve gruplandırmak için Pandas'ı kullanabilirsiniz. Çoğu kişi Pandas'ı veri bilimi, veri analizi ve ML görevleri için kullanır.\n" +
                    "\n" +
                    "NumPy\n" +
                    "NumPy, geliştiricilerin kolayca dizi oluşturmak ve yönetmek, mantıksal şekilleri işlemek ve doğrusal cebir işlemleri gerçekleştirmek için kullandığı popüler bir kitaplıktır. NumPy, C ve C++ gibi birçok dille entegrasyon desteği sunar.\n" +
                    "\n" +
                    "Requests\n" +
                    "Requests kitaplığı, web geliştirme için gerekli olan kullanışlı işlevler sağlar. Bu kitaplığı HTTP istekleri göndermek, üst bilgiler eklemek, URL parametreleri eklemek, veriler eklemek ve web uygulamalarıyla iletişim kurarken daha birçok görevi gerçekleştirmek için kullanabilirsiniz. \n" +
                    "\n" +
                    "OpenCV-Python\n" +
                    "OpenCV-Python, geliştiricilerin görüntü işleme uygulamaları için görüntüleri işlemek üzere kullandığı bir kitaplıktır. Bu kitaplık, görüntüleri eş zamanlı olarak okuma ve yazma, 2B bir ortamdan 3B bir ortam oluşturma, videodan görüntüler yakalama ve bunları analiz etme gibi görüntü işleme görevlerine yönelik birçok işlev sunar.\n" +
                    "\n" +
                    "Keras\n" +
                    "Keras; veri işleme, görselleştirme ve daha birçok konuda mükemmel destek sağlayan, Python'ın derin sinir ağı kitaplığıdır. Keras, birçok sinir ağını destekler. İnovasyon uygulamaları yazma konusunda esneklik sağlayan modüler bir yapıya sahiptir.\n" +
                    "\n" +
                    "Python çerçeveleri nelerdir?\n" +
                    "Python çerçevesi, paketlerden ve modüllerden oluşan bir koleksiyondur. Modül, ilgili kodlardan oluşan bir kümeyken, paket ise modüllerden oluşan bir kümedir. Geliştiriciler, Python uygulamalarını daha hızlı derlemek için Python çerçevelerini kullanır ve böylece, web uygulamasında iletişimin nasıl gerçekleştiği ya da Python'ın programı nasıl daha hızlı hale getireceği gibi ayrıntılar konusunda endişelenmelerine gerek kalmaz. Python'da iki tür çerçeve bulunur: \n" +
                    "\n" +
                    "Tam yığın çerçeve, büyük bir uygulama derlemek için neredeyse gerekli olan her şeyi içerir.\n" +
                    "Mikro çerçeve, basit Python uygulamaları derlemek için minimum işlevleri sağlayan temel bir çerçevedir. Uygulamalar için daha gelişmiş işlevler gerekirse uzantılar da sağlar.\n" +
                    "En popüler Python çerçeveleri hangileridir?\n" +
                    "Geliştiriciler, geliştirme süreçlerinin daha verimli olması için aşağıdakiler gibi birçok Python çerçevesini kullanabilir:\n" +
                    "\n" +
                    "Django\n" +
                    "Django, büyük ölçekli web uygulamaları geliştirmek için en yaygın kullanılan tam yığın Python web çerçevelerinden biridir. Geliştirmek ve test etmek için web sunucusu, web sitesi ön ucunu derlemek için şablon altyapısı ve çeşitli güvenlik mekanizmaları gibi birçok kullanışlı özellik sunar.\n" +
                    "\n" +
                    "Flask\n" +
                    "Flask, küçük web uygulamaları geliştirmek için kullanılan bir mikro çerçevedir. Özellikleri arasında güçlü topluluk desteği, iyi yazılmış belgeler, şablon altyapısı, birim testi ve dahili web sunucusu yer alır. Doğrulama desteği, veritabanı eşleştirme katmanları ve web güvenliği için uzantılar da sağlar.\n" +
                    "\n" +
                    "TurboGears\n" +
                    "TurboGears, web uygulamalarını daha hızlı ve daha kolay şekilde derlemek için tasarlanmış bir çerçevedir. Popüler özelliklerinden bazıları şunlardır: \n" +
                    "\n" +
                    "Belirli bir veritabanı tablo yapısı\n" +
                    "Proje oluşturma ve yönetme araçları\n" +
                    "Veritabanları derlemek için şablon altyapısı\n" +
                    "Ön uç derlemek için şablon altyapısı\n" +
                    "Web güvenliğini sağlama mekanizmaları\n" +
                    "Apache MXNet\n" +
                    "Apache MXNet, geliştiricilerin araştırma prototipleri ve derin öğrenme uygulamaları derlemek için kullandığı hızlı, esnek ve ölçeklenebilir bir derin öğrenme çerçevesidir. Java, C++, R ve Perl gibi birçok programlama dilini destekler. Geliştirmeyi desteklemek için zengin bir araç ve kitaplık seti sunar. Örneğin, etkileşimli makine öğrenimi (ML) kitabı ve görüntü işleme araç setlerinin yanı sıra metin ve konuşma gibi doğal dilleri işleyen Doğal Dil İşleme'ye (NLP) yönelik derin öğrenme modelleri bulabilirsiniz.\n" +
                    "\n" +
                    "PyTorch\n" +
                    "PyTorch, başka bir açık kaynak ML kitaplığı olan Torch kitaplığı üzerine kurulmuş, makine öğrenimine yönelik bir çerçevedir.  Geliştiriciler, PyTorch'u NLP, robotik ve görüntü işleme gibi uygulamalarda kullanarak görüntülerdeki ve videolardaki anlamlı bilgileri bulurlar. Ayrıca bu uygulamaları CPU ve GPU'larda çalıştırmak için de kullanırlar.\n" +
                    "\n" +
                    "Python IDE'leri nelerdir?\n" +
                    "Entegre geliştirme ortamı (IDE), geliştiricilerin kod yazmak, kodu düzenlemek, test etmek ve koddaki hataları gidermek için ihtiyaç duyduğu araçları tek bir yerde toplayan bir yazılımdır. \n" +
                    "\n" +
                    "En popüler Python IDE'leri hangileridir?\n" +
                    "PyCharm\n" +
                    "PyCharm, yazılım araçları geliştiren bir Çek şirketi olan JetBrains tarafından oluşturulmuştur. Küçük Python uygulamaları için uygun olan ücretsiz bir topluluk sürümü ve büyük Python uygulamaları derlemek için uygun olan, ücretli bir profesyonel sürümü vardır. Bu sürüm, aşağıdaki tüm özellikleri destekler:\n" +
                    "\n" +
                    "Otomatik kod tamamlama ve kod inceleme\n" +
                    "Hataları giderme ve hızlı düzeltmeler\n" +
                    "İşlevi değiştirmeden kod temizleme\n" +
                    "Django ve Flask gibi web uygulaması çerçeveleri için destek\n" +
                    "JavaScript, CoffeeScript, TypeScript, AngularJS ve Node gibi diğer programlama dilleri için destek\n" +
                    "Matplotlib ve NumPy gibi bilimsel araçlar ve kitaplıklar\n" +
                    "Uzak sanal makinelerde uygulamalar çalıştırabilme, hata ayıklayabilme, test edebilme ve dağıtabilme özelliği\n" +
                    "Koddaki hataları bulan bir hata ayıklayıcı, koddaki performans sorunlarını belirleyen profil oluşturucu ve birim testleri çalıştırmak için test çalıştırma aracı\n" +
                    "Veritabanları desteği\n" +
                    "IDLE\n" +
                    "Entegre Geliştirme ve Öğrenme Ortamı (IDLE), varsayılan olarak yüklenen Python IDE'sidir. Tkinter GUI araç seti kullanılarak yalnızca Python ile geliştirilmiştir ve aşağıdaki özellikleri sunar:\n" +
                    " \n" +
                    "Windows, Unix ve macOS gibi birçok işletim sisteminde çalışır\n" +
                    "Komutları çalıştırmak ve çıktıyı görüntülemek için bir kabuk penceresi sağlar\n" +
                    "Kod söz dizimi vurgulama ve otomatik kod tamamlama sağlayan çok pencereli metin editörü sunar\n" +
                    "Kendi hata ayıklayıcısı bulunur \n" +
                    "Spyder\n" +
                    "Spyder, birçok bilim insanının ve veri analistinin kullandığı açık kaynak bir IDE'dir. Gelişmiş veri analizi, veri görselleştirme ve hata ayıklamaya yönelik özelliklerle kapsamlı bir geliştirme deneyimi sağlar. Ayrıca aşağıdaki özellikleri içerir:\n" +
                    "\n" +
                    "Birden çok dili destekleyen zengin kod editörü\n" +
                    "Etkileşimli IPython konsolu\n" +
                    "Basit hata ayıklayıcı\n" +
                    "Matplotlib, SciPy ve NumPy gibi bilimsel kitaplıklar\n" +
                    "Koddaki değişkenleri bulabilme\n" +
                    "Belgeleri gerçek zamanlı olarak görüntüleyebilme\n" +
                    "Atom\n" +
                    "Atom, Python da dahil olmak üzere birçok programlama dilinde kodlamayı destekleyen, GitHub tarafından geliştirilen ücretsiz bir editördür. Geliştiriciler, Atom'u kullanarak, kodunuzu merkezi olarak kaydedebileceğiniz web sitesi GitHub ile doğrudan çalışabilirler. Atom, aşağıdaki özellikleri sunar:\n" +
                    "\n" +
                    "Birçok işletim sisteminde kullanılabilme \n" +
                    "Yeni paketlerin kolay yüklenmesi veya oluşturulması\n" +
                    "Daha hızlı otomatik kod tamamlama\n" +
                    "Dosyaları ve projeleri araştırabilme\n" +
                    "Arabirimin kolayca özelleştirilmesi\n" +
                    "Python SDK'leri nelerdir?\n" +
                    "Yazılım geliştirme seti (SDK), geliştiricilerin belirli bir dilde yazılım uygulamaları oluşturmak için kullanabildiği bir yazılım araçları koleksiyonudur. Çoğu SDK, farklı donanım platformlarına ve işletim sistemlerine özgüdür. Python SDK'leri; kitaplıklar, kod örnekleri ve geliştiricilerin uygulama yazarken yararlandığı geliştirici rehberleri gibi birçok araç içerir.\n" +
                    "\n" +
                    "AWS PyCharm nedir?\n" +
                    "PyCharm İçin AWS Araç Seti, AWS'de Python uygulamalarını oluşturmayı, dağıtmayı ve bunlardaki hataları ayıklamayı kolaylaştıran PyCharm IDE eklentisidir. Geliştiriciler, AWS Toolkit for PyCharm'ı kullanarak Python ile geliştirmeye kolayca başlayabilir. Geliştiricilere başlangıç kılavuzları, adım adım hata ayıklama ve IDE dağıtımı gibi birçok kullanışlı özellik sağlar.\n" +
                    "\n" +
                    "Python'da Boto3 nedir?\n" +
                    "Boto3, Python için AWS SDK'sidir. Bunu; Amazon Esnek İşlem Bulutu (EC2), Amazon Basit Depolama Hizmeti (S3) ve Amazon DynamoDB gibi AWS hizmetlerini oluşturmak, yapılandırmak ve yönetmek için kullanabilirsiniz. Boto3 ayrıca iki tür API sağlar: düşük düzey API'ler ve geliştiriciler için Kaynak API'leri."),
            Product(R.drawable.sql, "SQL ","SQL nedir?\n" +
                    "Yapılandırılmış sorgu dili (SQL), bilgileri ilişkisel bir veri tabanında depolamak ve işlemek için kullanılan bir programlama dilidir. İlişkisel bir veri tabanı, farklı veri niteliklerini ve veri değerleri arasındaki çeşitli ilişkileri temsil eden satırlar ve sütunlar ile bilgileri tablo biçiminde depolar. Veri tabanından bilgi depolamak, güncellemek, kaldırmak, aramak ve almak için SQL ifadelerini kullanabilirsiniz. Veri tabanı performansını korumak ve optimize etmek için SQL'i de kullanabilirsiniz.\n" +
                    "\n" +
                    "SQL neden önemlidir?\n" +
                    "Yapılandırılmış sorgu dili (SQL), her tür uygulamada sıkça kullanılan popüler bir sorgu dilidir. Veri analistleri ve geliştiriciler, farklı programlama dilleriyle iyi bütünleştiği için SQL'i öğrenir ve kullanır. Örneğin, Oracle veya MS SQL Server gibi büyük SQL veri tabanı sistemleriyle yüksek performanslı veri işleme uygulamaları oluşturmak için Java programlama diliyle SQL sorguları ekleyebilirler. SQL, ifadelerinde ortak İngilizce anahtar kelimeler kullandığı için öğrenmesi oldukça kolaydır\n" +
                    "\n" +
                    "SQL'in Tarihçesi\n" +
                    "SQL, 1970'lerde ilişkisel veri modeline dayanarak yaratılmıştır. Başlangıçta yapılandırılmış İngilizce sorgu dili (SEQUEL) olarak biliniyordu. Terim daha sonra SQL olarak kısaltılmıştır. Eskiden İlişkisel Yazılım olarak bilinen Oracle, ticari bir SQL ilişkisel veri tabanı yönetim sistemi sunan ilk satıcı olmuştur.\n" +
                    "\n" +
                    "SQL sisteminin bileşenleri nelerdir?\n" +
                    "İlişkisel veri tabanı yönetim sistemleri, verileri depolamak ve yönetmek için yapılandırılmış sorgu dili (SQL) kullanır. Sistem, birbiriyle ilgili birden çok veri tabanı tablosunu depolar. MS SQL Server, MySQL veya MS Access ilişkisel veri tabanı yönetim sistemlerine örnektir. Aşağıdakiler böyle bir sistemin bileşenleridir. \n" +
                    "\n" +
                    "SQL tablosu\n" +
                    "SQL tablosu, bir ilişkisel veri tabanının temel ögesidir. SQL veri tabanı tablosu satır ve sütunlardan oluşur. Veri tabanı mühendisleri, veri depolama alanını optimize etmek için birden çok veri tabanı tablosu arasında ilişkiler oluşturur.\n" +
                    "\n" +
                    "Örneğin, veri tabanı mühendisi bir mağazadaki ürünler için bir SQL tablosu oluşturur: \n" +
                    "\n" +
                    "Ürün kimliği\n" +
                    "\n" +
                    "Ürün Adı\n" +
                    "\n" +
                    "Renk Kimliği\n" +
                    "\n" +
                    "0001\n" +
                    "\n" +
                    "Yatak\n" +
                    "\n" +
                    "Renk 1\n" +
                    "\n" +
                    "0002\n" +
                    "\n" +
                    "Yastık\n" +
                    "\n" +
                    "Renk 2\n" +
                    "\n" +
                    "Ardından veri tabanı mühendisi ürün tablosunu Renk Kimliği ile renk tablosuna bağlar:\n" +
                    "\n" +
                    "Renk Kimliği\n" +
                    "\n" +
                    "Renk Adı\n" +
                    "\n" +
                    "Renk 1\n" +
                    "\n" +
                    "Mavi\n" +
                    "\n" +
                    "Renk 2\n" +
                    "\n" +
                    "Kırmızı\n" +
                    "\n" +
                    "SQL ifadeleri\n" +
                    "SQL ifadeleri veya SQL sorguları, ilişkisel veri tabanı yönetim sistemlerinin anladığı geçerli talimatlardır. Yazılım geliştiricileri, farklı SQL dil ögelerini kullanarak SQL ifadeleri oluşturur. SQL dil ögeleri tanımlayıcılar, değişkenler ve doğru bir SQL ifadesi oluşturan arama koşulları gibi bileşenlerdir.\n" +
                    "\n" +
                    "Örneğin, aşağıdaki SQL ifadesi, 499 \$ fiyatındaki A Marka Yatak'ı Yatak_tablosu adlı bir tabloda marka_adı ve maliyet adlı sütunlarla birlikte depolamak için bir SQL INSERT komutu kullanır:\n" +
                    "\n" +
                    "INSERT INTO Yatak_tablosu (marka_adı, maliyet)\n" +
                    "\n" +
                    "VALUES('A','499');\n" +
                    "\n" +
                    "Depolanmış prosedürler\n" +
                    "Depolanmış prosedürler, ilişkisel veri tabanında depolanan bir veya daha fazla SQL ifadesi topluluğudur. Yazılım geliştiricileri, verimliliği ve performansı artırmak için depolanmış prosedürleri kullanır. Örneğin, farklı uygulamalarda aynı SQL ifadesini yazmak yerine satış tablolarını güncellemek için depolanmış bir prosedür oluşturabilirler. \n" +
                    "\n" +
                    "SQL nasıl çalışır?\n" +
                    "Yapılandırılmış sorgu dili (SQL) uygulaması, veri tabanı sorgularını işleyen ve sonuçları döndüren bir sunucu makinesini içerir. SQL işlemi, aşağıdakiler de dâhil olmak üzere çeşitli yazılım bileşenlerinden geçer. \n" +
                    "\n" +
                    "Ayrıştırıcı\n" +
                    "Ayrıştırıcı, SQL ifadelerindeki bazı kelimeleri özel sembollerle sınıflandırarak veya değiştirerek başlar. Daha sonra aşağıdaki unsurlara göre ifadeyi kontrol eder:\n" +
                    "\n" +
                    "Doğruluk\n" +
                    "Ayrıştırıcı, SQL ifadesinin SQL semantiğine veya kurallarına uygun olduğunu ya da sorgu ifadesinin doğruluğunu sağladığını doğrular. Örneğin, ayrıştırıcı SQL komutunun bir noktalı virgülle bitip bitmediğini kontrol eder. Noktalı virgül eksikse ayrıştırıcı bir hata döndürür.\n" +
                    "\n" +
                    "Yetkilendirme\n" +
                    "Ayrıştırıcı ayrıca, sorguyu çalıştıran kullanıcının ilgili verileri işlemek için gerekli yetkiye sahip olduğunu doğrular. Örneğin, yalnızca yönetici kullanıcılar verileri silme hakkına sahip olabilir. \n" +
                    "\n" +
                    "İlişkisel motor\n" +
                    "İlişkisel motor veya sorgu işlemcisi, ilgili verileri en etkili şekilde almak, yazmak veya güncellemek için bir plan oluşturur. Örneğin, benzer sorguları denetler, önceki veri işleme yöntemlerini yeniden kullanır veya yeni bir tane oluşturur. Planı bayt kodu adı verilen SQL ifadesinin orta düzey bir temsilinde yazar. İlişkisel veri tabanları, veri tabanı aramalarını ve değişikliklerini verimli bir şekilde gerçekleştirmek için bayt kodu kullanır. \n" +
                    "\n" +
                    "Depolama motoru\n" +
                    "Depolama motoru veya veri tabanı motoru, bayt kodunu işleyen ve amaçlanan SQL ifadesini çalıştıran yazılım bileşenidir. Fiziksel disk depolama alanındaki veri tabanı dosyalarındaki verileri okur ve depolar. Tamamlandığında, depolama motoru sonucu talep eden uygulamaya döndürür.\n" +
                    "\n" +
                    "SQL komutları nelerdir?\n" +
                    "Yapılandırılmış sorgu dili (SQL) komutları, geliştiricilerin bir ilişkisel veri tabanında depolanan verileri işlemek için kullandıkları belirli anahtar kelimeler veya SQL ifadeleridir. SQL komutlarını aşağıdaki gibi kategorilere ayırabilirsiniz.\n" +
                    "\n" +
                    "Veri tanımlama dili\n" +
                    "Veri tanımlama dili (DDL), veri tabanı yapısını tasarlayan SQL komutlarını ifade eder. Veri tabanı mühendisleri, iş gereksinimlerine göre veri tabanı nesneleri oluşturmak ve değiştirmek için DDL kullanır. Örneğin, veri tabanı mühendisi tablolar, görünümler ve dizinler gibi veri tabanı nesneleri oluşturmak için CREATE komutunu kullanır.\n" +
                    "\n" +
                    "Veri sorgulama dili\n" +
                    "Veri sorgulama dili (DQL) ilişkisel veri tabanlarında depolanan verileri almaya yönelik talimatlardan oluşur. Yazılım uygulamaları, SQL tablosundaki belirli sonuçları filtrelemek ve döndürmek için SELECT komutunu kullanır. \n" +
                    "\n" +
                    "Veri işleme dili\n" +
                    "Veri işleme dili (DML) ifadeleri, ilişkisel bir veri tabanında yeni bilgiler yazar veya mevcut kayıtları değiştirir. Örneğin, bir uygulama veri tabanında yeni bir kayıt depolamak için INSERT komutunu kullanır.\n" +
                    "\n" +
                    "Veri kontrol dili\n" +
                    "Veri tabanı yöneticileri, diğer kullanıcılar için veri tabanı erişimini yönetmek veya yetkilendirmek için veri kontrol dilini (DCL) kullanır. Örneğin, belirli uygulamaların bir veya daha fazla tabloyu işlemesine izin vermek için GRANT komutunu kullanabilirler. \n" +
                    "\n" +
                    "İşlem kontrol dili\n" +
                    "İlişkisel motor, veri tabanı değişikliklerini otomatik olarak yapmak için işlem kontrol dilini (TCL) kullanır. Örneğin, veri tabanı hatalı bir işlemi geri almak için ROLLBACK komutunu kullanır. ")
        )

        productAdapter = ProductAdapter(this, productList)
        recyclerView.adapter = productAdapter
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing)
        recyclerView.addItemDecoration(SpacesItemDecoration(spacingInPixels))

        val otherProductAdapter = ProductAdapter(this, otherProductList)
        recyclerView1.adapter = otherProductAdapter
        recyclerView1.addItemDecoration(SpacesItemDecoration(spacingInPixels))

        val thirdProductAdapter = ProductAdapter(this, thirdProductList)
        recyclerView2.adapter = thirdProductAdapter
        recyclerView2.addItemDecoration(SpacesItemDecoration(spacingInPixels))
    }
}
