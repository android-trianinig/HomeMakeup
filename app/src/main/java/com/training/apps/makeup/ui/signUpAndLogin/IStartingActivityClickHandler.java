package com.training.apps.makeup.ui.signUpAndLogin;

import com.training.apps.makeup.model.Client;
import com.training.apps.makeup.model.MyProvider;

public interface IStartingActivityClickHandler {

    void onSingUpClickHandler();

    void onSignInClickHandler(String phoneNumber, String password);

    void onSkipClickHandler();

    void onNewClientSignUpClickHandler(Client client);

    void selectClientImage();

    void getClientLocation();

    void selectProviderImage();

    void getProviderLocation();

    void onNewProviderSignUpClickHandler(MyProvider myProvider);
}
