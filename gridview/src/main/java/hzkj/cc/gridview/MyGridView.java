package hzkj.cc.gridview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.icu.text.UFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyGridView extends GridView {
    //    List<RedPointView> redPointViews = new ArrayList<>();
    List<GridItem> gridItems = new ArrayList<>();
    private List<Map<String, Object>> dataList;
    private SimpleAdapter adapter;
    GridItemClickListenner listenner;

    public void setGridItems(List<GridItem> gridItems) {
        this.gridItems = gridItems;
        init();
    }

    public void setListenner(GridItemClickListenner listenner) {
        this.listenner = listenner;
    }

    public MyGridView(Context context) {
        super(context);
    }

    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void init() {
        this.setNumColumns(3);
        this.setStretchMode(STRETCH_COLUMN_WIDTH);
        dataList = new ArrayList<>();
        String[] from = {"image", "text"};
        int[] to = {R.id.image, R.id.text};
        getData();
        adapter = new SimpleAdapter(getContext(), dataList, R.layout.gridview_item, from, to);
        this.setAdapter(adapter);
        this.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                listenner.click(position);
            }
        });
    }

    public List<Map<String, Object>> getData() {
        for (int i = 0; i < gridItems.size(); i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", gridItems.get(i)
                    .getIcon());
            map.put("text", gridItems.get(i)
                    .getName());
            dataList.add(map);
        }
        return dataList;
    }


}
