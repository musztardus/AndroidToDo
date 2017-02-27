package mmonastyrski.androidtodo;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.ArrayList;


public class TaskAdapter extends ArrayAdapter<Task> {
    
    public TaskAdapter(Context context, ArrayList<Task> tasks) {
        super(context, R.layout.task, tasks);
    }
    
    static class ViewHolder{
        TextView taskDescription;
        CheckBox isDone;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        Task task = getItem(position);
        
        if(view==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.task, parent, false);
            
            holder = new ViewHolder();
            
            holder.taskDescription = (TextView) view.findViewById(R.id.taskDescription);
            holder.isDone = (CheckBox) view.findViewById(R.id.isDone);
            
            view.setTag(holder);
        }
        else {
            holder=(ViewHolder) view.getTag();
        }
        holder.taskDescription.setText(task.get_description());
        holder.isDone.setChecked(task.is_done());
        if(holder.isDone.isChecked()){
            holder.taskDescription.setPaintFlags(holder.taskDescription.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
        
        return view;
    }
    
}
