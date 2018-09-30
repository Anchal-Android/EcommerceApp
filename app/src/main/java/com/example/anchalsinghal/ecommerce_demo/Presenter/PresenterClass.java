package com.example.anchalsinghal.ecommerce_demo.Presenter;

import com.example.anchalsinghal.ecommerce_demo.Model.NetworkManager;
import com.example.anchalsinghal.ecommerce_demo.View.Iview;
import com.example.anchalsinghal.ecommerce_demo.data.Response;


public class PresenterClass implements IPresenter {

    private Iview iView;
    private NetworkManager networkManager;

    public PresenterClass(Iview iView, NetworkManager networkManager) {
        this.iView = iView;
        this.networkManager = networkManager;
    }

    @Override
    public void callApi() {
        networkManager.networkApi(this);
    }

    @Override
    public void getAssessments(Response assesmentList) {

        iView.getList(assesmentList);

    }
}
