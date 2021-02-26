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
import java.util.List;

import static com.example.delivery.utils.Constants.KEY1;
import static com.example.delivery.utils.Constants.KEY2;

public class FragmentMenuList extends Fragment {
    private FragmentMenuListBinding binding;
    private Toolbar toolbar;
    private Button title;
    private NavController navController;
    private MenuViewModel viewModel;
    private SectionViewModel viewModelSection;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel=new ViewModelProvider(requireActivity()).get(MenuViewModel.class);
        viewModelSection=new ViewModelProvider(requireActivity()).get(SectionViewModel.class);

        binding=FragmentMenuListBinding.inflate(inflater);
        binding.setFragment(this);
        View view=binding.getRoot();
        navController= Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        addDinamicView();

        viewModel.getData();

        viewModel.listLive.observe(getViewLifecycleOwner(), (List<Entity> entities) ->{

            //проверяет bundle переданный из RecyclerAdapterSection
            //если его нет, то действие по -умолчанию ->
            if (getArguments()!=null){
                String key=getArguments().getString("key");
                //bundle.key указывает из какого Section был переход по значению PARAM
                switch (key){
                    case KEY1:
                        List<Entity> list1=viewModelSection.sortedListSectionOne(entities);
                        RecyclerSectionItemDecoration sectionItemDecoration=
                                viewModelSection.getDecorForSection1(list1);
                        RecyclerView recycler=recyclerConfig(list1,sectionItemDecoration);

                        String brand=getArguments().getString("value");
                        viewModelSection.toPositionHolderForSection1(recycler,list1,brand);
                        break;

                    case KEY2:
                        List<Entity> list2=viewModelSection.sortedListSectionTwo(entities);
                        RecyclerSectionItemDecoration sectionItemDecoration2=
                                viewModelSection.getDecorForSection2(list2);
                        RecyclerView recycler2=recyclerConfig(list2,sectionItemDecoration2);

                        String param=getArguments().getString("value");
                        viewModelSection.toPositionHolderForSection2(recycler2, list2,param);
                        break;
                }
            }else{
                //действие по -умолчанию
                List<Entity> list=viewModelSection.sortedListSectionOne(entities);
                RecyclerSectionItemDecoration sectionItemDecoration=
                        viewModelSection.getDecorForSection1(list);
                recyclerConfig(list,sectionItemDecoration);
            }
        });
        return view;
    }

    private RecyclerView recyclerConfig (List<Entity> list,
                                 RecyclerSectionItemDecoration sectionItemDecoration){
        RecyclerView recyclerView=binding.recyclerView;
        RecyclerView.Adapter adapter=new RecyclerAdapterList(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        recyclerView.addItemDecoration(sectionItemDecoration);
        return recyclerView;
    }
    //---------------------------------------Dinamic view--------------------------------------
    private void addDinamicView(){
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_up);
        title = new Button(getActivity());
        title.setText(getResources().getString(R.string.menu_sections));
        //title.setBackgroundColor(Color.parseColor("#FF6200EE"));
        title.setClickable(true);
        title.setTextSize(15);
        title.setOnClickListener((View v) ->{
                getNavOptions();
                navController.navigate(R.id.fragmentSectionContainer,null,getNavOptions());
                Loger.log("Dinamic Text View is Cliked");
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