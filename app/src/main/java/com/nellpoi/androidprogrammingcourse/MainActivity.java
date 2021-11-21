package com.nellpoi.androidprogrammingcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ListView myListview;
    private ArrayList<Class> activitiesNameList = new ArrayList<Class>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> list = new ArrayList<>();
        String[] activitiesName = new String[]{
                "LinearLayout 布局（线性布局）",
                "TableLayout 布局（表格布局）",
                "RelativeLayout 布局（相对布局）",
                "ConstraintLayout 布局（约束布局）",
                "Guideline 基准线",
                "ListView 列表视图",
                "Spinner 下拉列表框",
                "Android 应用资源",
                "StateListDrawable 资源",
                "单击事件、Toast（提示信息框)",
                "单选按钮和复选按钮",
                "ProgressBar（进度条）、SeekBar（拖动条）",
                "RatingBar（评分条）"
        };
        myListview = findViewById(R.id.demo_list);
        /*
         * 将全部activities注入ListView
         * */
        for (String i :
                activitiesName) {
            Log.e("NellPoi：", "创建了: " + i + " 窗体");
            list.add(i);
        }
        Toast.makeText(this, "加载完成，共加载" + Arrays.stream(activitiesName).count() + "个窗体", Toast.LENGTH_LONG).show();

        Class[] activitiesClassName = {
                SubActivity_LinearLayout.class,
                SubActivity_TableLayout.class,
                SubActivity_RelativeLayout.class,
                SubActivity_ConstraintLayout.class,
                SubActivity_Guideline.class,
                SubActivity_ListView.class,
                SubActivity_Spinner.class,
                SubActivity_Resources.class,
                SubActivity_StateListDrawable.class,
                SubActivity_Toast.class,
                SubActivity_Radiobutton_And_CheckBox.class,
                SubActivity_ProgressBarAndSeekBar.class,
                SubActivity_RatingBar.class
        };

        for (int i = 0; i < activitiesClassName.length; i++) {
            activitiesNameList.add(activitiesClassName[i]);
        }
        /*
         * 实例化适配器
         * */
        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, list);
        myListview.setAdapter(myArrayAdapter);
        myListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplication(), activitiesNameList.get(i));
                startActivity(intent);
            }
        });
    }

}