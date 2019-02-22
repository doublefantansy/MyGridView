package hzkj.cc.mygridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hzkj.cc.gridview.GridItem;
import hzkj.cc.gridview.GridItemClickListenner;
import hzkj.cc.gridview.MyGridView;

public class MainActivity extends AppCompatActivity {
    MyGridView gridView;
    List<GridItem> gridItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridView);
        gridItems = new ArrayList<GridItem>() {{
            add(new GridItem("考勤", R.drawable.ic_kaoqin));
            add(new GridItem("公告", R.drawable.ic_icon_3));
            add(new GridItem("新闻", R.drawable.ic_news_icon));
        }};
        gridView.setListenner(new GridItemClickListenner() {
            @Override
            public void click(int position) {
                Toast.makeText(MainActivity.this, position + "", Toast.LENGTH_SHORT)
                        .show();
            }
        });
        gridView.setGridItems(gridItems);
    }
}
