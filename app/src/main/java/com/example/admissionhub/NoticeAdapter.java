package com.example.admissionhub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {


    private Context mctx;

    private List<NoticeInfo> NoticeList;

    public NoticeAdapter(Context mctx, List<NoticeInfo> noticeList) {
        this.mctx = mctx;
        NoticeList = noticeList;
    }

    @NonNull
    @Override
    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mctx);
        View view = inflater.inflate(R.layout.list_layout,null);
        NoticeViewHolder holder = new NoticeViewHolder(view);
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewHolder holder, int position) {
          NoticeInfo noti = NoticeList.get(position);

          holder.title.setText(noti.getTitle());
          holder.description.setText(noti.getDescription());
    }

    @Override
    public int getItemCount() {
        return NoticeList.size();
    }

    class NoticeViewHolder extends RecyclerView.ViewHolder{
        TextView title,description;


        public NoticeViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);

        }
    }
}
