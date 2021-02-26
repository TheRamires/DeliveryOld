package com.example.delivery.menu;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.delivery.R;
import com.example.delivery.data.Entity;
import com.example.delivery.menu.adapters.RecyclerSectionItemDecoration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SectionsViewModel extends AndroidViewModel {
    private Context context;

    public SectionsViewModel(@NonNull Application application) {
        super(application);
        context=getApplication().getBaseContext();
    }

    public List<Entity> sortedListSectionOne(List<Entity> entities){
        List<Entity> list=new ArrayList<>(entities);
        //sort

        Collections.sort(list, (Entity o1, Entity o2)-> {
                return o1.getBrand().compareTo(o2.getBrand());
        });
        return list;
    }

    public List<Entity> sortedListSectionTwo(List<Entity> entities){
        List<Entity> list=new ArrayList<>(entities);
        //sort

        Collections.sort(list, (Entity o1, Entity o2)-> {
                return o1.getParam1().compareTo(o2.getParam1());
        });
        return list;
    }
    public RecyclerSectionItemDecoration getDecorForSection1(List<Entity>list){
        RecyclerSectionItemDecoration sectionItemDecoration =
                new RecyclerSectionItemDecoration(context.getResources()
                        .getDimensionPixelSize(R.dimen.recycler_section_header_height),
                        true, // true for sticky, false for not
                        new RecyclerSectionItemDecoration.SectionCallback() {
                            @Override
                            public boolean isSection(int position) {
                                return position == 0
                                        || list.get(position)
                                        //.getLastName()

                                        .getBrand()
                                        .charAt(0) != list.get(position - 1)
                                        //.getLastName()
                                        .getBrand()
                                        .charAt(0);
                            }

                            @Override
                            public CharSequence getSectionHeader(int position) {
                                return list.get(position)
                                        //.getLastName()
                                        .getBrand();
                                //.subSequence(0, 3); //.subSequence(0, 1);   //•установление заголовка
                            }
                        });
        return sectionItemDecoration;
    }
    public RecyclerSectionItemDecoration getDecorForSection2(List<Entity>list){
        RecyclerSectionItemDecoration sectionItemDecoration =
                new RecyclerSectionItemDecoration(context.getResources()
                        .getDimensionPixelSize(R.dimen.recycler_section_header_height),
                        true, // true for sticky, false for not
                        new RecyclerSectionItemDecoration.SectionCallback() {
                            @Override
                            public boolean isSection(int position) {
                                return position == 0
                                        || list.get(position)
                                        //.getLastName()

                                        .getParam1()
                                        .charAt(0) != list.get(position - 1)
                                        //.getLastName()
                                        .getParam1()
                                        .charAt(0);
                            }

                            @Override
                            public CharSequence getSectionHeader(int position) {
                                return list.get(position)
                                        //.getLastName()
                                        .getParam1();
                                //.subSequence(0, 3); //.subSequence(0, 1);   //•установление заголовка
                            }
                        });
        return sectionItemDecoration;
    }

    public void toPositionHolderForSection1(RecyclerView recyclerView, List<Entity> entities, String value){
        Entity entity;
        Iterator iterator=entities.iterator();
        int i=0;
        while (iterator.hasNext()){
            entity= (Entity) iterator.next();
            if (value.equalsIgnoreCase(entity.getBrand())){
                recyclerView.getLayoutManager().scrollToPosition(i);
                return;
            };
            i++;
        }
    }
    public void toPositionHolderForSection2(RecyclerView recyclerView, List<Entity> entities, String value){
        Entity entity;
        Iterator iterator=entities.iterator();
        int i=0;
        while (iterator.hasNext()){
            entity= (Entity) iterator.next();
            if (value.equalsIgnoreCase(entity.getParam1())){
                recyclerView.getLayoutManager().scrollToPosition(i);
                return;
            };
            i++;
        }
    }
}
