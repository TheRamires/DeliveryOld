package com.example.delivery.menu;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.delivery.Loger;
import com.example.delivery.R;
import com.example.delivery.data.Entity;
import com.example.delivery.databinding.FragmentMenuListBinding;
import com.example.delivery.menu.adapters.RecyclerSectionItemDecoration;
import com.example.delivery.menu.adapters.RecyclerAdapterList;

import java.util.Iterator;
import java.util.List;

public class FragmentMenuList extends Fragment {
    private Toolbar toolbar;
    private Button title;
    private NavController navController;
    private MenuViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel=new ViewModelProvider(requireActivity()).get(MenuViewModel.class);

        FragmentMenuListBinding binding=FragmentMenuListBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();
        navController= Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        addDinamicView();

        //List Test
        viewModel.getData();

        RecyclerView recyclerView=binding.recyclerView;
        viewModel.listLive.observe(getViewLifecycleOwner(), (List<Entity> entities) ->{
            setList(recyclerView,entities);
            if (getArguments()!=null){
                String brand=getArguments().getString("brand");
                Log.d("myLog","••7••• brand "+brand);
                toPositionHolder(recyclerView,entities,brand);
            }
        });

        return view;
    }
    private void setList (RecyclerView recyclerView, List<Entity> list){

        RecyclerView.Adapter adapter=new RecyclerAdapterList(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //RecyclerView Decor 1------------------------------------
        RecyclerSectionItemDecoration sectionItemDecoration =
                new RecyclerSectionItemDecoration(getResources()
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
        recyclerView.addItemDecoration(sectionItemDecoration);
    }
    private void toPositionHolder(RecyclerView recyclerView, List<Entity> entities, String brand){

        Entity entity;
        Iterator iterator=entities.iterator();
        int i=0;
        while (iterator.hasNext()){
            i++;
            entity= (Entity) iterator.next();
            if (brand.equalsIgnoreCase(entity.getBrand())){
                recyclerView.getLayoutManager().scrollToPosition(i);
                return;
            };
        }
    }

    //---------------------------------------Dinamic view--------------------------------------
    private void addDinamicView(){
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_up);
        title = new Button(getActivity());
        title.setText(getResources().getString(R.string.menu_sections));
        //title.setBackgroundColor(Color.parseColor("#FF6200EE"));
        title.setClickable(true);
        title.setTextSize(15);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNavOptions();
                navController.navigate(R.id.fragmentSectionContainer,null,getNavOptions());
                Loger.log("Dinamic Text View is Cliked");
            }
        });
        toolbar.addView(title);
    }
    protected NavOptions getNavOptions() {

        NavOptions navOptions = new NavOptions.Builder()
                .setEnterAnim(R.animator.slide_down)
                //.setExitAnim(R.animator.slide_up)
                //.setPopEnterAnim(R.animator.slide_down)
                .setPopExitAnim(R.animator.slide_up)
                .build();

        return navOptions;
    }

    //Destroy Dinamic View
    @Override
    public void onStop() {
        super.onStop();
        toolbar.removeView(title);
    }
}