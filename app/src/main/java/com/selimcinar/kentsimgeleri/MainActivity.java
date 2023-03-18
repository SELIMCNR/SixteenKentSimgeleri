package com.selimcinar.kentsimgeleri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.selimcinar.kentsimgeleri.databinding.ActivityDetailsBinding;
import com.selimcinar.kentsimgeleri.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {


    //Global kapsamlar
    private ActivityMainBinding binding;
    ArrayList<Landmark> landmarkArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //Listeyi initilaze etme yükleme
        landmarkArrayList=new ArrayList<>();

        //Classta tutulan datalar veriler.
        Landmark anitkabir=new Landmark("Anıtkabir","Türkiye","Anıtkabir, Ankara'nın Çankaya ilçesinde yer alan ve Mustafa Kemal Atatürk'ün anıt mezarını içeren komplekstir. Emin Onat ile Orhan Arda'nın tasarımı olan Anıtkabir'in 1944'te başlanan inşası 1953'te tamamlanmıştır. Anıt mezar binası başta olmak üzere çeşitli yapı ve anıtların yanı sıra Barış Parkı olarak adlandırılan ağaçlık alandan oluşur.",R.drawable.anitkabir);
        Landmark saatkulesi=new Landmark("Saat kulesi","Türkiye","İzmir Saat Kulesi, İzmir'de Osmanlı padişahı II. Abdülhamid'in tahta çıkışının 25. yıldönümünü kutlamak için 1901'de inşa edilmiş tarihî saat kulesidir.\n" +
                "\n" +
                "Konak Meydanı'ndaki İzmir Hükûmet Konağı, Kemeraltı Çarşısı girişi, Konak Yalı Camii ve İzmir Büyükşehir Belediyesi binası arasındaki alanda yer alır. 25 metre yüksekliğinde ve dört katlı olan kule, Sultan II. Abdülhamid'in iradesi gereği Osmanlı vilayetlerinde aynı dönemde meydana getirilmiş birçok saat kulesinden birisidir. Ancak özgün mimarisi ve yapımında izlenen yöntem nedeniyle diğer saat kuleleri arasında özel bir yer edinmiştir. Osmanlı saat kuleleri içinde en estetik görünüşlü ve en zarifi olarak kabul edilir.",R.drawable.izmir_saat_kulesi);
        Landmark kizkulesi=new Landmark("Kız kulesi","Türkiye","Kız Kulesi, İstanbul Boğazı'nın Marmara Denizi'ne yakın kısmında, Salacak açıklarında yer alan küçük adacık üzerinde inşa edilmiş yapıdır.",R.drawable.kiz_kulesi);
        Landmark SelimiyeCami=new Landmark("Selimiye Cami","Türkiye","Selimiye Camiî, Osmanlı padişahı II. Selim döneminde Mimar Sinan'ın yaptığı ve Osmanlı'nın önceki başkenti Edirne'de bulunan bir külliyedir. Mimar Sinan'ın 80 yaşında yaptığı ve \"ustalık eserim\" şeklinde nitelendirdiği[1] Selimiye Camii, gerek Mimar Sinan'ın, gerek Osmanlı mimârîsinin en önemli eserleri arasında sayılır.[2]",R.drawable.selimiye_camii);

        //Listeye classta tutulan verileri ekleme
        landmarkArrayList.add(anitkabir);
        landmarkArrayList.add(saatkulesi);
        landmarkArrayList.add(kizkulesi);
        landmarkArrayList.add(SelimiyeCami);

        //Adapter : Layoutu ve veriyi birbirine bağlar.
        //Listview

        //mapping : Bir yapıyı başka bir yapıya döndürür classı yazıya dönüştürme gibi örnek
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,landmarkArrayList.stream().map(landmark -> landmark.name ).collect(Collectors.toList()));
        binding.listView.setAdapter(arrayAdapter);

      //Listviewde herhangi biryere tıklanınca ne olsunu =   binding.listView.setOnClickListener();
      //Listview içerisinde iteme nesneye tıklanınca neolsun  binding.listView.setOnItemClickListener();
      //Listview içerisinde uzun tıklanınca ne olsun binding.listView.setOnLongClickListener();
      binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              //Tıklanan liste elemanınını toast mesajı olarak gösterme
              Toast.makeText(MainActivity.this, landmarkArrayList.get(position).name, Toast.LENGTH_SHORT).show();
              //Tıklanan liste elemanının adını diğer aktiviteye veri olarak yollama
              Intent intent =new Intent(MainActivity.this,DetailsActivity.class);
              intent.putExtra("landmark",landmarkArrayList.get(position));
              startActivity(intent);
          }
      });
    }
}