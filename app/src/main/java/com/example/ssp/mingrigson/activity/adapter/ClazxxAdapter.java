package com.example.ssp.mingrigson.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ssp.mingrigson.R;
import com.example.ssp.mingrigson.activity.bean.Clazz;

import java.util.List;

/**
 * Created by ${宋少鹏} on 2019/12/27.
 * 功能:
 * 邮箱:4646224@qq.com
 */
public class ClazxxAdapter extends BaseAdapter {
    private List<Clazz.ResultBean> list;
    private Context context;
    private LayoutInflater inflater;

    public ClazxxAdapter(List<Clazz.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
        this.inflater=LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 列表中每一项的展示效果
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(null==convertView){
            holder=new ViewHolder();
            convertView=inflater.inflate(R.layout.list_item,null);
            holder.image=(ImageView)convertView.findViewById(R.id.show_pic);
            holder.teacher=(TextView)convertView.findViewById(R.id.show_teacher);
            holder.title=(TextView)convertView.findViewById(R.id.show_title);
            holder.time=(TextView)convertView.findViewById(R.id.show_time);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        //增加展示的数据
        Clazz.ResultBean resultBean=list.get(position);
        holder.title.setText(resultBean.getCourse_name());
        holder.teacher.setText("主讲"+resultBean.getMain_teacher());
        holder.time.setText("时间"+resultBean.getClass_hour());
        Glide.with(context).load(resultBean.getCover()).into(holder.image);

        return convertView;
    }
    class ViewHolder{
        ImageView image;//显示图片
        TextView title,teacher,time;//标题讲师时间

    }
}
