package kr.co.tjoeun.pizzastore_20200527;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjoeun.pizzastore_20200527.adapters.StoreAdapter;
import kr.co.tjoeun.pizzastore_20200527.databinding.ActivityMainBinding;
import kr.co.tjoeun.pizzastore_20200527.datas.Store;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;
    List<Store> stores = new ArrayList<>();
    StoreAdapter mStoreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setupEvent();
        setValues();
    }

    @Override
    public void setupEvent() {

    }

    @Override
    public void setValues() {

        addStore();

        mStoreAdapter = new StoreAdapter(mContext, R.layout.store_list_item, stores);
        binding.storeListView.setAdapter(mStoreAdapter);

    }

    void addStore() {

        stores.add(new Store("피자헛","http://mblogthumb2.phinf.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800", "111-111-1111"));
        stores.add(new Store("파파존스","http://mblogthumb2.phinf.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800", "222-222-2222"));
        stores.add(new Store("미스터피자","https://post-phinf.pstatic.net/MjAxODEyMDVfMzYg/MDAxNTQzOTYxOTA4NjM3.8gsStnhxz7eEc9zpt5nmSRZmI-Pzpl4NJvHYU-Dlgmcg.7Vpgk0lopJ5GoTav3CUDqmXi2-_67S5AXD0AGbbR6J4g.JPEG/IMG_1641.jpg?type=w1200", "333-333-3333"));
        stores.add(new Store("도미노피자","https://pbs.twimg.com/profile_images/1098371010548555776/trCrCTDN_400x400.png", "444-444-4444"));

    }
}
