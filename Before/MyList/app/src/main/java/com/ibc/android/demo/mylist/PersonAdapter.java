package com.ibc.android.demo.mylist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends  RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    ArrayList<Person> items= new ArrayList<Person>(); //담고있을 데이터들.

    OnPersonItemClickListener listener;

    public void addItem(Person item){
        items.add(item);
    }

    public void setItems(ArrayList<Person> items){
        this.items=items;
    }
    public Person getItem(int position){
        return items.get(position);
    }
    public void setItem(int position,Person item){
        items.set(position,item);
    }

    public void setOnItemClickListener(OnPersonItemClickListener listener){
        this.listener = listener;
    }

    //generate implement method
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //ViewHolder라는것을 생성할 시점에 실행된다.
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.person_item,parent,false);
        return new ViewHolder(itemView, listener);
    }

    @Override                                                //position은 위에서 사라진 item의 값.
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {//위로 사라진 item을 재사용하는데 그때 발생하는 이벤트
        Person item = items.get(position);
        holder.setItem(item); //ViewHoler가 이미 만들어져있으므로 새로 생성 x
    }

    @Override
    public int getItemCount() {
        return  items.size();
    }

    //RecyclerView 안에 Item안에 들어갈 Layout들을 관리하는 애
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView,final OnPersonItemClickListener listener){
            super(itemView);
            textView= itemView.findViewById(R.id.textView);//itemView로 전달된 layout안에있는 view들을 findviewById로 연결 할 수 있다.
            textView2= itemView.findViewById(R.id.textView2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position= getAdapterPosition();//몇번째 뷰인지가 넘어옴.
                    if (listener!=null){
                        listener.onItemClick(ViewHolder.this, v ,position);
                    }
                }
            });

        }

        public void setItem(Person item){
            textView.setText(item.getName());
            textView2.setText(item.getMoblie());

        }


    }
}
