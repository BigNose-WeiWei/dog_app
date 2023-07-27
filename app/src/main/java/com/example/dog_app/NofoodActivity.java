package com.example.dog_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import com.example.dog_app.Adapter.Nofood_MyAdapter;
import com.example.dog_app.Model.Nofood;

import java.util.ArrayList;

public class NofoodActivity extends AppCompatActivity  implements TextWatcher {
    EditText el;
    ListView li;
    String[] name = {"巧克力（可致命）","洋蔥（危險）","肝臟（危險）","骨頭（危險）","生雞蛋（危險）","生肉及家禽肉（危險~致命）","豬肉（不建議餵食）","牛奶（不建議）","菇類（不建議~致命）","酒（建議不要）","蘋果杏仁桃子野莓苦瓜李子梅子(蔬菜水果類)","香蕉(蔬菜水果類)","櫻桃(蔬菜水果類)","洋菇(蔬菜水果類)","洋蔥(蔬菜水果類)","肉荳蔻(蔬菜水果類)","葡萄葡萄乾梅子(蔬菜水果類)"};
    String[] because =  {"巧克力中的咖啡鹹對動物而言是種毒藥。它會使輸送部的血液流量減少，可能會造成心臟病和其他有致命威脅的問題。","生或熟的洋蔥含有二硫化物成分，它對人體無害，卻會造成貓、狗的紅血球氧化的危險。可能引發溶血性貧血。","肝臟是狗最愛的食物之一，許多的零食或狗食都含有肝臟。吃食少量的肝臟其實對狗是不錯的，但如果過量卻可能引起維他命A中毒或維他命A過多症。","不要餵食會碎裂的骨頭，骨頭碎片可能會刺入狗的喉嚨，或割傷狗的嘴巴，食道，胃或腸。窒息現象，應用壓力鍋將骨頭煮爛。","生蛋白含有一種卵白素的蛋白質，它會耗盡狗體內的維生素H。維生素H是狗生長及促進毛皮健康的營養，更可能造成維生素H缺乏症。","免疫系統卻無法適應人工科學飼養出的家禽及肉類。最常見的2種毒素是家禽肉類中的沙門氏菌及肉類中的芽胞桿菌。","豬肉內的脂肪球比其他肉類還大。可能會阻塞了狗的微血管。避免豬製品，尤其是含有硝酸鈉的培垠、香腸。","許多狗都有乳糖不適症，如果你的狗喝了牛奶後會出現放屁，腹瀉，脫水或皮膚發炎等徵狀，應停止餵食牛奶。有乳糖不適症的狗應食用不含乳糖成分的牛奶。","市售的食用香菇，磨菇等對狗是無害的，但還是避免讓狗食用，以免到野外時誤食有毒茹類。","易增加肝、腎負擔。"
            ,"果肉不可多量，種子則是完全不能吃。因為多數瓜果類的種子含有氰化物。以上都可能導致下痢、嘔吐、下腹疼痛。","所謂無毒性植物只是讓狗狗食用後如果有產生上述症狀也還是比較輕微的，或者對於狗狗的胃腸道還沒有很重大的影響，通常不需要特別治療。","導致呼吸急促、休克、口腔炎、心跳急促。","導致急性腸胃反應、肝臟和腎臟損傷、下腹痛、反胃噁心、嘔唾液。","胃腸不適、溶血性貧血。","顫抖，甚至會死亡。","腎衰竭。"};
    int[] image = {R.drawable.no,R.drawable.no,R.drawable.no,R.drawable.no,R.drawable.no,R.drawable.no,R.drawable.no,R.drawable.no,R.drawable.no,R.drawable.no,R.drawable.no,R.drawable.no,R.drawable.no,R.drawable.no,R.drawable.no,R.drawable.no,R.drawable.no,R.drawable.no,R.drawable.no};
    ArrayList<Nofood> mylist;
    Nofood_MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nofood);

        li = findViewById(R.id.listView);
        el = findViewById(R.id.searchView);
        el.addTextChangedListener(this);
        mylist = new ArrayList<> ();
        Nofood sr;
        for(int i=0;i<name.length;i++){
            sr = new  Nofood(name[i],image[i],because[i]);
            mylist.add(sr);
        }
        myAdapter = new Nofood_MyAdapter(this,mylist);
        li.setAdapter(myAdapter);
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        this.myAdapter.getFilter().filter(charSequence);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}

